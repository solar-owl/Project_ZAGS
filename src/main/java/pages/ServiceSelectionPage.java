package pages;

import io.qameta.allure.Step;
import static pages.locators.ServiceSelectionPageLocators.*;

public class ServiceSelectionPage extends BasePage {

    @Step("Выбрать услугу: регистрация брака")
    public void selectMarriageRegistration() {
        clickUsingLocator(MARRIAGE_REGISTRATION_BUTTON);
    }

    @Step("Выбрать услугу: регистрация рождения")
    public void selectBirthRegistration() {
        clickUsingLocator(BIRTH_REGISTRATION_BUTTON);
    }

    @Step("Выбрать услугу: регистрация смерти")
    public void selectDeathRegistration() {
        clickUsingLocator(DEATH_REGISTRATION_BUTTON);
    }
}