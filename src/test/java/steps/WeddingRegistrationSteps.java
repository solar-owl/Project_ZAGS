package steps;

import cucumber.Hooks;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Тогда;
import model.MarriageApplication;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.MarriageRandomizer;

public class WeddingRegistrationSteps {

    private static final Logger log = LogManager.getLogger(WeddingRegistrationSteps.class);

    private MarriageApplication marriageData;

    @Дано("пользователь авторизуется как {string}")
    public void userLogsInAs(String role) {
        log.info("авторизация как '{}'", role);
        if ("пользователь".equalsIgnoreCase(role)) {
            Hooks.loginPage.loginAsUser();
        } else if ("администратор".equalsIgnoreCase(role)) {
            Hooks.loginPage.loginAsAdmin();
        }
        log.info("авторизация выполнена успешно");
    }

    @И("пользователь заполняет форму заявителя случайными данными для заявки регистрации брака")
    public void userFillsApplicantFormWithRandomData() {
        log.info("генерация данных");
        marriageData = MarriageRandomizer.random();
        log.info("заполнение формы заявителя");
        Hooks.applicantFormPage.fillAllFieldsInApplicantForm(marriageData.getApplicant());
        log.info("форма заявителя заполнена");
    }

    @И("пользователь нажимает кнопку {string}")
    public void userClicksButton(String buttonName) {
        log.info("нажатие кнопки '{}'", buttonName);
        switch (buttonName) {
            case "Далее":
                Hooks.stepPage.checkNextButtonEnabled().clickNextButton();
                break;
            case "Завершить":
                Hooks.stepPage.checkCompleteButtonEnabled().clickCompleteButton();
                break;
        }
        log.info("Кнопка '{}' нажата", buttonName);
    }

    @И("пользователь выбирает услугу {string}")
    public void userSelectsService(String serviceName) {
        log.info("выбор услуги '{}'", serviceName);
        if ("Регистрация брака".equals(serviceName)) {
            Hooks.serviceSelectionPage.selectMarriageRegistration();
        }
        log.info("услуга '{}' выбрана", serviceName);
    }

    @И("пользователь заполняет форму гражданина случайными данными для заявки регистрации брака")
    public void userFillsCitizenFormWithRandomData() {
        log.info("заполнение формы гражданина");
        Hooks.citizenFormPage.fillAllFieldsInCitizenForm(marriageData.getCitizen());
        log.info("форма гражданина заполнена");
    }

    @И("пользователь заполняет форму брака случайными данными")
    public void userFillsMarriageFormWithRandomData() {
        log.info("заполнение формы данные услуги: регистрация брака");
        Hooks.marriageFormPage.fillAllFieldsInMarriageForm(marriageData.getMarriageDetails());
        log.info("форма данные услуги заполнена");
    }

    @Тогда("отображается текст {string}")
    public void thanksTextIsDisplayed(String expectedText) {
        log.info("проверка текста '{}'", expectedText);
        Hooks.statusPage.checkThanksText(expectedText);
        log.info("текст отображается");
    }

    @И("статус заявки равен {string}")
    public void applicationStatusEquals(String expectedStatus) {
        log.info("проверка статуса заявки '{}'", expectedStatus);
        Hooks.statusPage.checkStatusText(expectedStatus);
        log.info("статус заявки соответствует ожидаемому");
    }

    @И("отображается дата регистрации заявки")
    public void registrationDateIsDisplayed() {
        log.info("проверка отображения даты регистрации");
        Hooks.statusPage.checkRegistrationDate();
        log.info("дата регистрации отображается верно");
    }
}