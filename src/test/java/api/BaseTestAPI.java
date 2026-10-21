package api;

import io.qameta.allure.Epic;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import db.ZagsDbRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;


import static org.hamcrest.Matchers.notNullValue;
import static utils.LoginCredentials.BASE_URL;
import static utils.LoginCredentials.PASSWORD;
import static utils.LoginCredentials.USERNAME;

@Epic("Услуги ЗАГС API + DB")
@Listeners({io.qameta.allure.testng.AllureTestNg.class})
public abstract class BaseTestAPI {

    protected final Logger log = LogManager.getLogger(getClass());
    protected final ZagsDbRepository db = new ZagsDbRepository();

    protected RequestSpecification spec;
    protected ResponseSpecification respSpec;

    @BeforeMethod
    public void setUp() {
        log.info("Настройка RequestSpecification для теста");

        spec = new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .setAuth(RestAssured.preemptive().basic(USERNAME, PASSWORD))
                .addFilter(new AllureRestAssured())
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();

        respSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectBody(notNullValue())
                .build();

        RestAssured.requestSpecification = spec;
        RestAssured.responseSpecification = respSpec;
    }

    @AfterMethod
    public void tearDown() {
        RestAssured.reset();
        log.info("REST Assured сброшен");
    }
}