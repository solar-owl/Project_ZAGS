package api;

import api.dto.AdminRequestDto;
import api.mapper.AdminRequestMapper;
import db.DbRecord;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.AdminRandomizer;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static utils.LoginCredentials.BASE_URL;

@Feature("Регистрация администратора")
@Story("Регистрация администратора")
public class SendAdminRequestTest extends BaseTestAPI {

    @Test(description = "Регистрация администратора")
    @Description("Проверка, что администратор создаётся и его данные корректно сохраняются в БД")
    public void sendAdminRequestTest() {
        log.info("НАЧАЛО ТЕСТА: sendAdminRequestTest");
        log.debug("Base URL: {}", BASE_URL);

        AdminRequestDto requestBody =
                AdminRequestMapper.toDto(AdminRandomizer.random());

        Response response = given()
                .spec(spec)
                .body(requestBody)
                .when()
                .post(BASE_URL + "/sendAdminRequest");

        response.then()
                .spec(respSpec)
                .body(matchesJsonSchemaInClasspath("schemas/admin-response.json"));

        int staffId = response.jsonPath().getInt("data.staffid");
        log.info("staffid = {}", staffId);

        DbRecord row = db.findAdminById(staffId)
                .orElseThrow(() -> new AssertionError("Клиент не найден в БД"));

        Assert.assertEquals(row.str("surname"), requestBody.getPersonalLastName());
        Assert.assertEquals(row.str("name"), requestBody.getPersonalFirstName());
        Assert.assertEquals(row.str("middlename"), requestBody.getPersonalMiddleName());
        Assert.assertEquals(row.str("dateofbirth"), requestBody.getDateOfBirth());
        Assert.assertEquals(row.str("passportnumber"), requestBody.getPersonalNumberOfPassport());
        Assert.assertEquals(row.str("phonenumber"), requestBody.getPersonalPhoneNumber());

        log.info("ТЕСТ sendAdminRequestTest ЗАВЕРШЁН УСПЕШНО");
    }
}