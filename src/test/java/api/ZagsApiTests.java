package api;

import api.dto.AdminRequestDto;
import api.dto.ApplicationDto;
import api.dto.ApplicationRequestDto;
import api.dto.RequestProcessDto;
import api.mapper.AdminRequestMapper;
import api.mapper.BirthRequestMapper;
import api.mapper.DeathRequestMapper;
import api.mapper.MarriageRequestMapper;
import db.DbRecord;
import db.ZagsDbRepository;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.AdminRandomizer;
import utils.BirthRandomizer;
import utils.DeathRandomizer;
import utils.MarriageRandomizer;

import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.notNullValue;

@Epic("Услуги ЗАГС API + DB")
@Listeners({io.qameta.allure.testng.AllureTestNg.class})
public class ZagsApiTests {

    String baseURl = "https://regoffice.senla.eu";
    String username = "user";
    String password = "senlatest";

    protected RequestSpecification spec;
    protected ResponseSpecification respSpec;
    private static final Logger log = LogManager.getLogger(ZagsApiTests.class);
    private final ZagsDbRepository db = new ZagsDbRepository();

    @BeforeMethod
    public void setUp() {
        log.info("Настройка RequestSpecification для теста");

        spec = new RequestSpecBuilder()
                .setBaseUri(baseURl)
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .setAuth(RestAssured.preemptive().basic(username, password))
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

    @Test(description = "Получение списка всех заявок")
    @Story("Получение заявок")
    public void getApplicationsTest() {
        log.info("=== НАЧАЛО ТЕСТА: getApplicationsTest ===");
        log.debug("Base URL: {}", baseURl);

        given()
                .spec(spec)
                .when()
                .get(baseURl + "/getApplications")
                .then()
                .spec(respSpec)
                .body(matchesJsonSchemaInClasspath("schemas/applications-response.json"));

        log.info("=== ТЕСТ getApplicationsTest ЗАВЕРШЁН УСПЕШНО ===");
    }

    @Test(description = "Получение заявки по ID")
    @Story("Получение заявки по ID")
    public void getApplStatusWithIdTest() {
        log.info("=== НАЧАЛО ТЕСТА: getApplStatusWithIdTest ===");
        log.debug("Base URL: {}", baseURl);

        given()
                .spec(spec)
                .when()
                .get(baseURl + "/getApplStatus/70000")
                .then()
                .spec(respSpec)
                .body(matchesJsonSchemaInClasspath("schemas/application-by-id-response.json"));

        log.info("=== ТЕСТ getApplStatusWithIdTest ЗАВЕРШЁН УСПЕШНО ===");
    }

    @Test(description = "Отправка заявки на регистрацию брака")
    @Story("Подача заявки на регистрацию брака")
    public void sendUserRequestWeddingTest() {
        log.info("=== НАЧАЛО ТЕСТА: sendUserRequestWeddingTest ===");
        log.debug("Base URL: {}", baseURl);

        ApplicationRequestDto requestBody =
                MarriageRequestMapper.toDto(MarriageRandomizer.random());

        Response response = given()
                .spec(spec)
                .body(requestBody)
                .when()
                .post(baseURl + "/sendUserRequest");

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

        log.info("=== ТЕСТ sendUserRequestWeddingTest ЗАВЕРШЁН УСПЕШНО ===");
    }

    @Test(description = "Отправка заявки на регистрацию смерти")
    @Story("Подача заявки на регистрацию смерти")
    public void sendUserRequestDeathTest() {
        log.info("=== НАЧАЛО ТЕСТА: sendUserRequestDeathTest ===");
        log.debug("Base URL: {}", baseURl);

        ApplicationRequestDto requestBody =
                DeathRequestMapper.toDto(DeathRandomizer.random());

        Response response = given()
                .spec(spec)
                .body(requestBody)
                .when()
                .post(baseURl + "/sendUserRequest");

        response.then()
                .spec(respSpec)
                .body(matchesJsonSchemaInClasspath("schemas/death-response.json"));

        int applicantid = response.jsonPath().getInt("data.applicantid");
        log.info("applicantid = {}", applicantid);

        int citizenid = response.jsonPath().getInt("data.citizenid");
        log.info("citizenid = {}", citizenid);

        int applicationid = response.jsonPath().getInt("data.applicationid");
        log.info("applicationid = {}", applicationid);

        int deathcertificateid = response.jsonPath().getInt("data.deathcertificateid");
        log.info("deathcertificateid = {}", deathcertificateid);

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

        log.info("=== ТЕСТ sendUserRequestDeathTest ЗАВЕРШЁН УСПЕШНО ===");
    }

    @Test(description = "Отправка заявки на регистрацию рождения")
    @Story("Подача заявки на регистрацию рождения")
    public void sendUserRequestBirthTest() {
        log.info("=== НАЧАЛО ТЕСТА: sendUserRequestBirthTest ===");
        log.debug("Base URL: {}", baseURl);

        ApplicationRequestDto requestBody =
                BirthRequestMapper.toDto(BirthRandomizer.random());

        Response response = given()
                .spec(spec)
                .body(requestBody)
                .when()
                .post(baseURl + "/sendUserRequest");

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

        log.info("=== ТЕСТ sendUserRequestBirthTest ЗАВЕРШЁН УСПЕШНО ===");
    }

    @Test(description = "Регистрация администратора")
    @Story("Регистрация администратора")
    public void sendAdminRequestTest() {
        log.info("=== НАЧАЛО ТЕСТА: sendAdminRequestTest ===");
        log.debug("Base URL: {}", baseURl);

        AdminRequestDto requestBody =
                AdminRequestMapper.toDto(AdminRandomizer.random());

        Response response = given()
                .spec(spec)
                .body(requestBody)
                .when()
                .post(baseURl + "/sendAdminRequest");

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


        log.info("=== ТЕСТ sendAdminRequestTest ЗАВЕРШЁН УСПЕШНО ===");
    }

    @Test(description = "Обработка заявки: смена статуса на approved")
    @Story("Обработка заявки")
    public void requestProcessTest() {
        log.info("=== НАЧАЛО ТЕСТА: requestProcessTest ===");
        log.debug("Base URL: {}", baseURl);

        List<ApplicationDto> applications = given()
                .spec(spec)
                .when()
                .get(baseURl + "/getApplications")
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
                .post(baseURl + "/requestProcess")
                .then()
                .spec(respSpec)
                .body(matchesJsonSchemaInClasspath("schemas/change-status-response.json"));

        DbRecord row = db.findApplicationById(target.getApplicationid())
                .orElseThrow(() -> new AssertionError("Клиент не найден в БД"));

        Assert.assertEquals(row.str("statusofapplication"), "approved");

        log.info("=== ТЕСТ requestProcessTest ЗАВЕРШЁН УСПЕШНО ===");
    }

}
