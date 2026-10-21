package api;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static utils.LoginCredentials.BASE_URL;

@Feature("Получение заявок")
@Story("Получение заявок")
public class GetApplicationsTest extends BaseTestAPI {

    @Test(description = "Получение списка всех заявок")
    @Description("Проверка, что эндпоинт /getApplications возвращает список заявок и валидный JSON по схеме")
    public void getApplicationsTest() {
        log.info("НАЧАЛО ТЕСТА: getApplicationsTest");
        log.debug("Base URL: {}", BASE_URL);

        given()
                .spec(spec)
                .when()
                .get(BASE_URL + "/getApplications")
                .then()
                .spec(respSpec)
                .body(matchesJsonSchemaInClasspath("schemas/applications-response.json"));

        log.info("ТЕСТ getApplicationsTest ЗАВЕРШЁН УСПЕШНО");
    }
}