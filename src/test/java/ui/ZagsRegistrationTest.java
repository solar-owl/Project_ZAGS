package ui;

import driver.DriverSingleton;
import elements.ApplicationRow;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import listeners.ScreenshotListener;
import model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;
import utils.AdminRandomizer;
import utils.BirthRandomizer;
import utils.DeathRandomizer;
import utils.MarriageRandomizer;

@Listeners(ScreenshotListener.class)
@Epic("Услуги ЗАГС UI")
public class ZagsRegistrationTest {

    private static final Logger logger = LogManager.getLogger(ZagsRegistrationTest.class);

    private static final String STATUS_PENDING = "На рассмотрении";
    private static final String STATUS_APPROVED = "Одобрена";
    private static final String STATUS_REJECTED = "Отклонена";

    private LoginPage loginPage;
    private FormStepPage stepPage;
    private ApplicantFormPage applicantFormPage;
    private ServiceSelectionPage serviceSelectionPage;
    private CitizenFormPage citizenFormPage;
    private MarriageFormPage marriageFormPage;
    private DeathFormPage  deathFormPage;
    private BirthFormPage birthFormPage;
    private ApplicationStatusPage statusPage;
    private AdminDetailsPage adminDetailsPage;
    private AdminApplicationPage adminApplicationPage;


    @BeforeMethod
    public void setUp() {
        logger.info("Инициализация Page Object'ов");
        loginPage = new LoginPage();
        stepPage = new FormStepPage();
        applicantFormPage = new ApplicantFormPage();
        serviceSelectionPage = new ServiceSelectionPage();
        citizenFormPage = new CitizenFormPage();
        marriageFormPage = new MarriageFormPage();
        deathFormPage = new DeathFormPage();
        birthFormPage = new BirthFormPage();
        statusPage = new ApplicationStatusPage();
        adminDetailsPage = new AdminDetailsPage();
        adminApplicationPage = new AdminApplicationPage();

        logger.info("Открытие основной страницы");
        loginPage.open();
    }

    @AfterMethod (alwaysRun= true)
    public void tearDown() {
        logger.info("Закрытие драйвера");
        DriverSingleton.quitDriver();
    }

    @Test (description="этот тест проверяет услугу Регистрация брака")
    @Description("Проверка успешной подачи заявки на регистрацию брака")
    @Feature("Регистрация брака")
    @Story("Подача заявки на регистрацию брака")
    public void marriageRegistrationTest() {
        MarriageApplication data = MarriageRandomizer.random();
        logger.info("=== НАЧАЛО ТЕСТА: marriageRegistrationTest ===");
        logger.info("Авторизация пользователя");
        loginPage.loginAsUser();

        // Первая форма: данные заявителя
        logger.info("Шаг 1: заполнение данных заявителя");
        applicantFormPage.fillAllFieldsInApplicantForm(data.getApplicant());
        stepPage.checkNextButtonEnabled()
                .clickNextButton();

        // Выбор услуги
        logger.info("Шаг 2: выбор услуги 'Регистрация брака'");
        serviceSelectionPage.selectMarriageRegistration();

        // Вторая форма: данные гражданина
        logger.info("Шаг 3: заполнение данных гражданина");
        citizenFormPage.fillAllFieldsInCitizenForm(data.getCitizen());
        stepPage.checkNextButtonEnabled()
                .clickNextButton();

        // Третья форма: данные услуги
        logger.info("Шаг 4: заполнение данных о браке");
        marriageFormPage.fillAllFieldsInMarriageForm(data.getMarriageDetails());
        stepPage.checkCompleteButtonEnabled()
                .clickCompleteButton();

        // Статус заявки
        logger.info("Шаг 5: проверка статуса заявки");
        statusPage.checkThanksText("Спасибо за обращение!")
                  .checkStatusText("Статус заявки: На рассмотрении.")
                  .checkRegistrationDate();
        logger.info("=== ТЕСТ marriageRegistrationTest ЗАВЕРШЁН УСПЕШНО ===");
    }

    @Test(description="этот тест проверяет услугу Регистрация рождения")
    @Description("Проверка успешной подачи заявки на регистрацию рождения")
    @Feature("Регистрация рождения")
    @Story("Подача заявки на регистрацию рождения")
    public void birthRegistrationTest() {
        BirthApplication data = BirthRandomizer.random();
        logger.info("=== НАЧАЛО ТЕСТА: birthRegistrationTest ===");
        logger.info("Авторизация пользователя");
        loginPage.loginAsUser();

        // Первая форма: данные заявителя
        logger.info("Шаг 1: заполнение данных заявителя");
        applicantFormPage.fillAllFieldsInApplicantForm(data.getApplicant());
        stepPage.checkNextButtonEnabled()
                .clickNextButton();

        // Выбор услуги
        logger.info("Шаг 2: выбор услуги 'Регистрация рождения'");
        serviceSelectionPage.selectBirthRegistration();

        // Вторая форма: данные гражданина
        logger.info("Шаг 3: заполнение данных гражданина");
        citizenFormPage.fillAllFieldsInCitizenForm(data.getCitizen());
        stepPage.checkNextButtonEnabled()
                .clickNextButton();

        // Третья форма: данные услуги
        logger.info("Шаг 4: заполнение данных о рождении");
        birthFormPage.fillAllFieldsInBirthForm(data.getBirthDetails());
        stepPage.checkCompleteButtonEnabled()
                .clickCompleteButton();

        // Статус заявки
        logger.info("Шаг 5: проверка статуса заявки");
        statusPage.checkThanksText("Спасибо за обращение!")
                  .checkStatusText("Статус заявки: На рассмотрении.")
                  .checkRegistrationDate();
        logger.info("=== ТЕСТ birthRegistrationTest ЗАВЕРШЁН УСПЕШНО ===");

    }

    @Test(description="этот тест проверяет услугу Регистрация смерти")
    @Description("Проверка успешной подачи заявки на регистрацию смерти")
    @Feature("Регистрация смерти")
    @Story("Подача заявки на регистрацию смерти")
    public void deathRegistrationTest() {
        DeathApplication data = DeathRandomizer.random();
        logger.info("=== НАЧАЛО ТЕСТА: deathRegistrationTest ===");

        logger.info("Авторизация пользователя");
        loginPage.loginAsUser();

        // Первая форма: данные заявителя
        logger.info("Шаг 1: заполнение данных заявителя");
        applicantFormPage.fillAllFieldsInApplicantForm(data.getApplicant());
        stepPage.checkNextButtonEnabled()
                .clickNextButton();

        // Выбор услуги
        logger.info("Шаг 2: выбор услуги 'Регистрация смерти'");
        serviceSelectionPage.selectDeathRegistration();

        // Вторая форма: данные гражданина
        logger.info("Шаг 3: заполнение данных гражданина");
        citizenFormPage.fillAllFieldsInCitizenForm(data.getCitizen());
        stepPage.checkNextButtonEnabled()
                .clickNextButton();

        // Третья форма: данные услуги
        logger.info("Шаг 4: заполнение данных о смерти");
        deathFormPage.fillAllFieldsInDeathForm(data.getDeathDetails());
        stepPage.checkCompleteButtonEnabled()
                .clickCompleteButton();

        // Статус заявки
        logger.info("Шаг 5: проверка статуса заявки");
        statusPage.checkThanksText("Спасибо за обращение!")
                  .checkStatusText("Статус заявки: На рассмотрении.")
                  .checkRegistrationDate();
        logger.info("=== ТЕСТ deathRegistrationTest ЗАВЕРШЁН УСПЕШНО ===");
    }

    @Test(description="этот тест проверяет управление заявками от имени администратора")
    @Description("Проверка подтверждения и отклонения заявок администратором")
    @Feature("Администрирование заявок")
    @Story("Управление заявками")
    public void adminTest() {
        AdminDetails data = AdminRandomizer.random();
        logger.info("=== НАЧАЛО ТЕСТА: adminTest ===");

        logger.info("Авторизация администратора");
        loginPage.loginAsAdmin();

        // Первая форма: данные регистрации
        logger.info("Шаг 1: заполнение данных регистрации администратора");
        adminDetailsPage.fillAllFieldsInDetailForm(data);
        stepPage.checkNextButtonEnabled()
                .clickNextButton();

        // Вторая форма: администрирование заявок
        //Подтверждение заявки
        logger.info("Шаг 2: переход по страницам таблицы");
        adminApplicationPage.goToNextPage()
                            .goToPage(3)
                            .goToPreviousPage()
                            .goToPage(1);

        //можно добавить пререквизит с созданием конкретной заявки и потом с ней работать
        logger.info("Шаг 3: подтверждение первой заявки со статусом '{}'", STATUS_PENDING);
        //ApplicationRow rowToApprove = adminApplicationPage.getRows().get(2);
        ApplicationRow rowToApprove = adminApplicationPage.getFirstRowWithStatus(STATUS_PENDING);
        String approvedApplicationNumber = rowToApprove.getNumber();
        logger.info("Найдена заявка для подтверждения: {}", approvedApplicationNumber);
        adminApplicationPage.checkRowStatus(rowToApprove, STATUS_PENDING);

        rowToApprove.approve();
        logger.info("Заявка {} подтверждена, ожидание статуса '{}'", approvedApplicationNumber, STATUS_APPROVED);
        adminApplicationPage.waitForStatus(approvedApplicationNumber, STATUS_APPROVED);

        ApplicationRow approvedRow = adminApplicationPage.getRowByNumber(approvedApplicationNumber);
        adminApplicationPage.checkRowStatus(approvedRow, STATUS_APPROVED);
        logger.info("Статус заявки {} успешно проверен: '{}'", approvedApplicationNumber, STATUS_APPROVED);

        //Отклонение заявки
        logger.info("Шаг 4: отклонение первой заявки со статусом '{}'", STATUS_PENDING);
        //ApplicationRow rowToReject = adminApplicationPage.getRows().get(4);
        ApplicationRow rowToReject = adminApplicationPage.getFirstRowWithStatus(STATUS_PENDING);
        String rejectedApplicationNumber = rowToReject.getNumber();
        logger.info("Найдена заявка для отклонения: {}", rejectedApplicationNumber);
        adminApplicationPage.checkRowStatus(rowToReject, STATUS_PENDING);

        rowToReject.reject();
        logger.info("Заявка {} отклонена, ожидание статуса '{}'", rejectedApplicationNumber, STATUS_REJECTED);
        adminApplicationPage.waitForStatus(rejectedApplicationNumber, STATUS_REJECTED);

        ApplicationRow rejectedRow = adminApplicationPage.getRowByNumber(rejectedApplicationNumber);
        adminApplicationPage.checkRowStatus(rejectedRow, STATUS_REJECTED);
        logger.info("Статус заявки {} успешно проверен: '{}'", rejectedApplicationNumber, STATUS_REJECTED);

        logger.info("=== ТЕСТ adminTest ЗАВЕРШЁН УСПЕШНО ===");
    }
}
