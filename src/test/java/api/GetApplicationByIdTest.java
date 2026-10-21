package api;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static utils.LoginCredentials.BASE_URL;

@Feature("Получение заявки по ID")
@Story("Получение заявки по ID")
public class GetApplicationByIdTest extends BaseTestAPI {

    @Test(description = "Получение заявки по ID")
    @Description("Проверка, что эндпоинт /getApplStatus/{id} возвращает заявку и валидный JSON по схеме")
    public void getApplStatusWithIdTest() {
        log.info("НАЧАЛО ТЕСТА: getApplStatusWithIdTest");
        log.debug("Base URL: {}", BASE_URL);

        given()
                .spec(spec)
                .when()
                .get(BASE_URL + "/getApplStatus/70000")
                .then()
                .spec(respSpec)
                .body(matchesJsonSchemaInClasspath("schemas/application-by-id-response.json"));

        log.info("ТЕСТ getApplStatusWithIdTest ЗАВЕРШЁН УСПЕШНО");
    }
}