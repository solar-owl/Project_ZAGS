import driver.DriverSingleton;
import elements.ApplicationRow;
import model.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

public class ZagsRegistrationTest {

    private static final MarriageApplication MARRIAGE_APPLICATION = new MarriageApplication(
            new Applicant("Холланд", "Том", "Иванович", "85553535", "85553535", "Москва"),
            new Citizen("Холланд", "Том", "Иванович", "01.06.1996", "85553535", "Муж", "Москва"),
            new MarriageDetails("05.08.2026", "Холланд", "Коулман", "Зендея", "Ивановна", "01.09.1996", "85553535")
    );

    private static final BirthApplication BIRTH_APPLICATION = new BirthApplication(
            new Applicant("Холланд", "Том", "Иванович", "85553535", "85553535", "Москва"),
            new Citizen("Холланд", "Том", "Иванович", "01.06.1996", "85553535", "Муж", "Москва"),
            new BirthDetails("Лондон", "Зендея", "Том", "Мария", "Иван")
    );

    private static final DeathApplication DEATH_APPLICATION = new DeathApplication(
            new Applicant("Иванов", "Иван", "Иванович", "85553535", "85553535", "Москва"),
            new Citizen("Иванов", "Иван", "Иванович", "01.06.1996", "85553535", "Муж", "Москва"),
            new DeathDetails("20.02.2026", "Москва")
    );

    private static final AdminDetails ADMIN_APPLICATION = new AdminDetails(
            "Иванов", "Иван", "Иванович", "85553535", "85553535", "01.09.1996"
    );

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

        loginPage.open();
    }

    @AfterMethod
    public void tearDown() {
        DriverSingleton.quitDriver();
    }

    @Test
    public void marriageRegistrationTest() {
        loginPage.loginAsUser();

        // Первая форма: данные заявителя
        applicantFormPage.fill(MARRIAGE_APPLICATION.getApplicant());
        Assert.assertTrue(stepPage.isNextButtonEnabled(), "Кнопка 'Далее' disabled на форме заявителя");
        stepPage.clickNextButton();

        // Выбор услуги
        serviceSelectionPage.selectMarriageRegistration();

        // Вторая форма: данные гражданина
        citizenFormPage.fill(MARRIAGE_APPLICATION.getCitizen());
        Assert.assertTrue(stepPage.isNextButtonEnabled(), "Кнопка 'Далее' disabled на форме гражданина");
        stepPage.clickNextButton();

        // Третья форма: данные услуги
        marriageFormPage.fill(MARRIAGE_APPLICATION.getMarriageDetails());
        Assert.assertTrue(stepPage.isCompleteButtonEnabled(), "Кнопка 'Завершить' disabled");
        stepPage.clickCompleteButton();

        // Статус заявки
        Assert.assertEquals(statusPage.getThanksText(), "Спасибо за обращение!");
        Assert.assertEquals(statusPage.getStatusText(), "Статус заявки: На рассмотрении.");
        Assert.assertEquals(statusPage.getRegistrationDateText(), statusPage.getExpectedRegistrationDate());
    }

    @Test
    public void birthRegistrationTest() {
        loginPage.loginAsUser();

        // Первая форма: данные заявителя
        applicantFormPage.fill(BIRTH_APPLICATION.getApplicant());
        Assert.assertTrue(stepPage.isNextButtonEnabled(), "Кнопка 'Далее' disabled на форме заявителя");
        stepPage.clickNextButton();

        // Выбор услуги
        serviceSelectionPage.selectBirthRegistration();

        // Вторая форма: данные гражданина
        citizenFormPage.fill(BIRTH_APPLICATION.getCitizen());
        Assert.assertTrue(stepPage.isNextButtonEnabled(), "Кнопка 'Далее' disabled на форме гражданина");
        stepPage.clickNextButton();

        // Третья форма: данные услуги
        birthFormPage.fill(BIRTH_APPLICATION.getBirthDetails());
        Assert.assertTrue(stepPage.isCompleteButtonEnabled(), "Кнопка 'Завершить' disabled");
        stepPage.clickCompleteButton();

        // Статус заявки
        Assert.assertEquals(statusPage.getThanksText(), "Спасибо за обращение!");
        Assert.assertEquals(statusPage.getStatusText(), "Статус заявки: На рассмотрении.");
        Assert.assertEquals(statusPage.getRegistrationDateText(), statusPage.getExpectedRegistrationDate());
    }

    @Test
    public void deathRegistrationTest() {
        loginPage.loginAsUser();

        // Первая форма: данные заявителя
        applicantFormPage.fill(DEATH_APPLICATION.getApplicant());
        Assert.assertTrue(stepPage.isNextButtonEnabled(), "Кнопка 'Далее' disabled на форме заявителя");
        stepPage.clickNextButton();

        // Выбор услуги
        serviceSelectionPage.selectDeathRegistration();

        // Вторая форма: данные гражданина
        citizenFormPage.fill(DEATH_APPLICATION.getCitizen());
        Assert.assertTrue(stepPage.isNextButtonEnabled(), "Кнопка 'Далее' disabled на форме гражданина");
        stepPage.clickNextButton();

        // Третья форма: данные услуги
        deathFormPage.fill(DEATH_APPLICATION.getDeathDetails());
        Assert.assertTrue(stepPage.isCompleteButtonEnabled(), "Кнопка 'Завершить' disabled");
        stepPage.clickCompleteButton();

        // Статус заявки
        Assert.assertEquals(statusPage.getThanksText(), "Спасибо за обращение!");
        Assert.assertEquals(statusPage.getStatusText(), "Статус заявки: На рассмотрении.");
        Assert.assertEquals(statusPage.getRegistrationDateText(), statusPage.getExpectedRegistrationDate());
    }

    @Test
    public void adminTest() {
        loginPage.loginAsAdmin();

        // Первая форма: данные регистрации
        adminDetailsPage.fill(ADMIN_APPLICATION);
        Assert.assertTrue(stepPage.isNextButtonEnabled(), "Кнопка 'Далее' disabled на форме заявителя");
        stepPage.clickNextButton();

        // Вторая форма: администрирование заявок
        //Подтверждение заявки
        adminApplicationPage.goToNextPage();
        adminApplicationPage.goToPage(3);
        adminApplicationPage.goToPreviousPage();
        adminApplicationPage.goToPage(1);

        //можно добавить пререквизит с созданием конкретной заявки и потом с ней работать
        //ApplicationRow rowToApprove = adminApplicationPage.getRows().get(2);
        ApplicationRow rowToApprove = adminApplicationPage.getFirstRowWithStatus(STATUS_PENDING);
        String approvedApplicationNumber = rowToApprove.getNumber();
        Assert.assertEquals(rowToApprove.getStatus(), STATUS_PENDING,
                "Заявка № " + approvedApplicationNumber + " должна быть 'На рассмотрении' до подтверждения");

        rowToApprove.approve();
        adminApplicationPage.waitForStatus(approvedApplicationNumber, STATUS_APPROVED);

        ApplicationRow approvedRow = adminApplicationPage.getRowByNumber(approvedApplicationNumber);
        Assert.assertEquals(approvedRow.getStatus(), STATUS_APPROVED,
                "Заявка № " + approvedApplicationNumber + " должна получить статус 'Одобрена' после подтверждения");

        //Отклонение заявки
        //ApplicationRow rowToReject = adminApplicationPage.getRows().get(4);
        ApplicationRow rowToReject = adminApplicationPage.getFirstRowWithStatus(STATUS_PENDING);
        String rejectedApplicationNumber = rowToReject.getNumber();
        Assert.assertEquals(rowToReject.getStatus(), STATUS_PENDING,
                "Заявка № " + rejectedApplicationNumber + " должна быть 'На рассмотрении' до отклонения");

        rowToReject.reject();
        adminApplicationPage.waitForStatus(rejectedApplicationNumber, STATUS_REJECTED);

        ApplicationRow rejectedRow = adminApplicationPage.getRowByNumber(rejectedApplicationNumber);
        Assert.assertEquals(rejectedRow.getStatus(), STATUS_REJECTED,
                "Заявка № " + rejectedApplicationNumber + " должна получить статус 'Отклонена' после отклонения");
    }
}
