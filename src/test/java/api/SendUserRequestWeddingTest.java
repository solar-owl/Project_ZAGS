package api;

import api.dto.ApplicationRequestDto;
import api.mapper.MarriageRequestMapper;
import db.DbRecord;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.MarriageRandomizer;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static utils.LoginCredentials.BASE_URL;

@Feature("Подача заявки на регистрацию брака")
@Story("Подача заявки на регистрацию брака")
public class SendUserRequestWeddingTest extends BaseTestAPI {

    @Test(description = "Отправка заявки на регистрацию брака")
    @Description("Проверка, что заявка на брак создаётся, возвращает ID и сохраняется в БД корректно")
    public void sendUserRequestWeddingTest() {
        log.info("НАЧАЛО ТЕСТА: sendUserRequestWeddingTest");
        log.debug("Base URL: {}", BASE_URL);

        ApplicationRequestDto requestBody =
                MarriageRequestMapper.toDto(MarriageRandomizer.random());

        Response response = given()
                .spec(spec)
                .body(requestBody)
                .when()
                .post(BASE_URL + "/sendUserRequest");

        response.then()
                .spec(respSpec)
                .body(matchesJsonSchemaInClasspath("schemas/wedding-response.json"));

        int applicantid = response.jsonPath().getInt("data.applicantid");
        log.info("applicantid = {}", applicantid);

        int citizenid = response.jsonPath().getInt("data.citizenid");
        log.info("citizenid = {}", citizenid);

        int applicationid = response.jsonPath().getInt("data.applicationid");
        log.info("applicationid = {}", applicationid);

        int merrigecertificateid = response.jsonPath().getInt("data.merrigecertificateid");
        log.info("merrigecertificateid = {}", merrigecertificateid);

        DbRecord rowApplicant = db.findApplicantById(applicantid)
                .orElseThrow(() -> new AssertionError("Клиент не найден в БД"));

        Assert.assertEquals(rowApplicant.str("surname"), requestBody.getPersonalLastName());
        Assert.assertEquals(rowApplicant.str("name"), requestBody.getPersonalFirstName());
        Assert.assertEquals(rowApplicant.str("middlename"), requestBody.getPersonalMiddleName());
        Assert.assertEquals(rowApplicant.str("passportnumber"), requestBody.getPersonalNumberOfPassport());
        Assert.assertEquals(rowApplicant.str("phonenumber"), requestBody.getPersonalPhoneNumber());

        DbRecord rowApplication = db.findApplicationById(applicationid)
                .orElseThrow(() -> new AssertionError("Клиент не найден в БД"));
        Assert.assertEquals(rowApplication.getInt("citizenid"), citizenid);
        Assert.assertEquals(rowApplication.getInt("applicantid"), applicantid);

        log.info("ТЕСТ sendUserRequestWeddingTest ЗАВЕРШЁН УСПЕШНО");
    }
}