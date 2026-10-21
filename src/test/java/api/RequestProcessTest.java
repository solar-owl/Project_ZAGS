package api;

import api.dto.ApplicationDto;
import api.dto.RequestProcessDto;
import db.DbRecord;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static utils.LoginCredentials.BASE_URL;

@Feature("Обработка заявки")
@Story("Обработка заявки")
public class RequestProcessTest extends BaseTestAPI {

    @Test(description = "Обработка заявки: смена статуса на approved")
    @Description("Проверка, что эндпоинт /requestProcess переводит заявку в статус approved и это отражается в БД")
    public void requestProcessTest() {
        log.info("НАЧАЛО ТЕСТА: requestProcessTest");
        log.debug("Base URL: {}", BASE_URL);

        List<ApplicationDto> applications = given()
                .spec(spec)
                .when()
                .get(BASE_URL + "/getApplications")
                .then()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getList("data", ApplicationDto.class);

        ApplicationDto target = applications.stream()
                .filter(a -> "under consideration".equals(a.getStatusofapplication()))
                .findFirst()
                .orElseThrow(() -> new AssertionError(
                        "Не найдено ни одной заявки со статусом 'under consideration'"));

        DbRecord rowBefore = db.findApplicationById(target.getApplicationid())
                .orElseThrow(() -> new AssertionError("Клиент не найден в БД"));

        Assert.assertEquals(rowBefore.str("statusofapplication"), "under consideration");

        RequestProcessDto requestBody = new RequestProcessDto(
                target.getApplicationid(),
                target.getStaffid(),
                "approved");

        given()
                .spec(spec)
                .body(requestBody)
                .when()
                .post(BASE_URL + "/requestProcess")
                .then()
                .spec(respSpec)
                .body(matchesJsonSchemaInClasspath("schemas/change-status-response.json"));

        DbRecord row = db.findApplicationById(target.getApplicationid())
                .orElseThrow(() -> new AssertionError("Клиент не найден в БД"));

        Assert.assertEquals(row.str("statusofapplication"), "approved");

        log.info("ТЕСТ requestProcessTest ЗАВЕРШЁН УСПЕШНО");
    }
}