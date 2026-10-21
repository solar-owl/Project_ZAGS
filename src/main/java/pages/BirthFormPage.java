package pages;

import io.qameta.allure.Step;
import model.BirthDetails;
import static pages.locators.BirthFormPageLocators.*;

public class BirthFormPage extends BasePage{


    @Step("Заполнить все поля формы рождения")
    public void fillAllFieldsInBirthForm(BirthDetails details) {
        fillBirthPlace(details.getBirthPlace());
        fillMother(details.getMother());
        fillFather(details.getFather());
        fillGrandMother(details.getGrandMother());
        fillGrandFather(details.getGrandFather());
    }

    @Step("Заполнить поле 'Место рождения': {birthPlace}")
    public void fillBirthPlace(String birthPlace) {
        fillUsingLocator(FIELD_BIRTH_PLACE, birthPlace);
    }

    @Step("Заполнить поле 'Мать': {mother}")
    public void fillMother(String mother) {
        fillUsingLocator(FIELD_MOTHER, mother);
    }

    @Step("Заполнить поле 'Отец': {father}")
    public void fillFather(String father) {
        fillUsingLocator(FIELD_FATHER, father);
    }

    @Step("Заполнить поле 'Бабушка': {grandMother}")
    public void fillGrandMother(String grandMother) {
        fillUsingLocator(FIELD_GRAND_MOTHER, grandMother);
    }

    @Step("Заполнить поле 'Дедушка': {grandFather}")
    public void fillGrandFather(String grandFather) {
        fillUsingLocator(FIELD_GRAND_FATHER, grandFather);
    }
}
