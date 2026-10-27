package ui;

import driver.DriverSingleton;
import io.qameta.allure.Epic;
import listeners.ScreenshotListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;
import pages.*;

@Listeners(ScreenshotListener.class)
@Epic("Услуги ЗАГС UI")
public abstract class BaseTestUI {

    protected static final String STATUS_PENDING = "На рассмотрении";
    protected static final String STATUS_APPROVED = "Одобрена";
    protected static final String STATUS_REJECTED = "Отклонена";

    protected final Logger logger = LogManager.getLogger(getClass());

    protected LoginPage loginPage;
    protected FormStepPage stepPage;
    protected ApplicantFormPage applicantFormPage;
    protected ServiceSelectionPage serviceSelectionPage;
    protected CitizenFormPage citizenFormPage;
    protected MarriageFormPage marriageFormPage;
    protected DeathFormPage deathFormPage;
    protected BirthFormPage birthFormPage;
    protected ApplicationStatusPage statusPage;
    protected AdminDetailsPage adminDetailsPage;
    protected AdminApplicationPage adminApplicationPage;

    @BeforeMethod(alwaysRun = true)
    @Parameters("browser")
    public void setUp(@Optional("chrome") String browser) {
        logger.info("Инициализация Page Object'ов");
        DriverSingleton.getDriver(browser);
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

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        logger.info("Закрытие драйвера");
        DriverSingleton.quitDriver();
    }
}