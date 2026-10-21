package pages;

import io.qameta.allure.Step;
import model.DeathDetails;

import static pages.locators.DeathFormPageLocators.*;

public class DeathFormPage extends BasePage{


    @Step("Заполнить все поля формы регистрация смерти")
    public void fillAllFieldsInDeathForm(DeathDetails details) {
        fillDeathDate(details.getDeathDate());
        fillDeathPlace(details.getDeathPlace());
    }

    @Step("Заполнить поле 'Дата смерти': {deathDate}")
    public void fillDeathDate(String deathDate) {
        fillUsingLocator(FIELD_DEATH_DATE, deathDate);
    }

    @Step("Заполнить поле 'Место смерти': {deathPlace}")
    public void fillDeathPlace(String deathPlace) {
        fillUsingLocator(FIELD_DEATH_PLACE, deathPlace);
    }

}
