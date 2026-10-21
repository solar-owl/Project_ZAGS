package ui;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import model.DeathApplication;
import org.testng.annotations.Test;
import utils.DeathRandomizer;

@Feature("Регистрация смерти")
@Story("Подача заявки на регистрацию смерти")
public class DeathRegistrationTest extends BaseTestUI {

    @Test(description = "этот тест проверяет услугу Регистрация смерти")
    @Description("Проверка успешной подачи заявки на регистрацию смерти")
    public void deathRegistrationTest() {
        DeathApplication data = DeathRandomizer.random();
        logger.info("НАЧАЛО ТЕСТА: deathRegistrationTest");

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
        logger.info("ТЕСТ deathRegistrationTest ЗАВЕРШЁН УСПЕШНО");
    }
}