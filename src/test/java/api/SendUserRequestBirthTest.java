package api;

import api.dto.ApplicationRequestDto;
import api.mapper.BirthRequestMapper;
import db.DbRecord;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BirthRandomizer;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static utils.LoginCredentials.BASE_URL;

@Feature("Подача заявки на регистрацию рождения")
@Story("Подача заявки на регистрацию рождения")
public class SendUserRequestBirthTest extends BaseTestAPI {

    @Test(description = "Отправка заявки на регистрацию рождения")
    @Description("Проверка, что заявка на рождение создаётся, возвращает ID и сохраняется в БД корректно")
    public void sendUserRequestBirthTest() {
        log.info("НАЧАЛО ТЕСТА: sendUserRequestBirthTest");
        log.debug("Base URL: {}", BASE_URL);

        ApplicationRequestDto requestBody =
                BirthRequestMapper.toDto(BirthRandomizer.random());

        Response response = given()
                .spec(spec)
                .body(requestBody)
                .when()
                .post(BASE_URL + "/sendUserRequest");

        response.then()
                .spec(respSpec)
                .body(matchesJsonSchemaInClasspath("schemas/birth-response.json"));

        int applicantid = response.jsonPath().getInt("data.applicantid");
        log.info("applicantid = {}", applicantid);

        int citizenid = response.jsonPath().getInt("data.citizenid");
        log.info("citizenid = {}", citizenid);

        int applicationid = response.jsonPath().getInt("data.applicationid");
        log.info("applicationid = {}", applicationid);

        int birthcertificateid = response.jsonPath().getInt("data.birthcertificateid");
        log.info("birthcertificateid = {}", birthcertificateid);

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

        log.info("ТЕСТ sendUserRequestBirthTest ЗАВЕРШЁН УСПЕШНО");
    }
}