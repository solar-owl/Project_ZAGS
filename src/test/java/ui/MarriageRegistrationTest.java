package ui;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import model.MarriageApplication;
import org.testng.annotations.Test;
import utils.MarriageRandomizer;

@Feature("Регистрация брака")
@Story("Подача заявки на регистрацию брака")
public class MarriageRegistrationTest extends BaseTestUI {

    @Test(description = "этот тест проверяет услугу Регистрация брака")
    @Description("Проверка успешной подачи заявки на регистрацию брака")
    public void marriageRegistrationTest() {
        MarriageApplication data = MarriageRandomizer.random();
        logger.info("НАЧАЛО ТЕСТА: marriageRegistrationTest");
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
        logger.info("ТЕСТ marriageRegistrationTest ЗАВЕРШЁН УСПЕШНО");
    }
}