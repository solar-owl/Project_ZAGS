package cucumber;

import driver.DriverSingleton;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.*;

public class Hooks {

    private static final Logger log = LogManager.getLogger(Hooks.class);

    public static LoginPage loginPage;
    public static FormStepPage stepPage;
    public static ApplicantFormPage applicantFormPage;
    public static ServiceSelectionPage serviceSelectionPage;
    public static CitizenFormPage citizenFormPage;
    public static MarriageFormPage marriageFormPage;
    public static ApplicationStatusPage statusPage;

    @Before
    public void setUp() {
        log.info("Инициализация Page Object'ов");
        loginPage = new LoginPage();
        stepPage = new FormStepPage();
        applicantFormPage = new ApplicantFormPage();
        serviceSelectionPage = new ServiceSelectionPage();
        citizenFormPage = new CitizenFormPage();
        marriageFormPage = new MarriageFormPage();
        statusPage = new ApplicationStatusPage();
        log.info("Открытие основной страницы");
        loginPage.open();
    }

    @After
    public void tearDown() {
        log.info("Закрытие драйвера");
        DriverSingleton.quitDriver();
    }
}