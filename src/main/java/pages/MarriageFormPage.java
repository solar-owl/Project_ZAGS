package pages;

import io.qameta.allure.Step;
import model.MarriageDetails;

import static pages.locators.MarriageFormPageLocators.*;


public class MarriageFormPage extends BasePage{


    @Step("Заполнить все поля формы регистрация брака")
    public void fillAllFieldsInMarriageForm(MarriageDetails details) {
        fillRegistrationDate(details.getRegistrationDate());
        fillNewLastName(details.getNewLastName());
        fillSpouseLastName(details.getSpouseLastName());
        fillSpouseFirstName(details.getSpouseFirstName());
        fillSpouseMiddleName(details.getSpouseMiddleName());
        fillSpouseBirthDate(details.getSpouseBirthDate());
        fillSpousePassportNumber(details.getSpousePassportNumber());
    }

    @Step("Заполнить поле 'Дата регистрации': {registrationDate}")
    public void fillRegistrationDate(String registrationDate) {
        fillUsingLocator(FIELD_REGISTRATION_DATE, registrationDate);
    }

    @Step("Заполнить поле 'Новая фамилия': {newLastName}")
    public void fillNewLastName(String newLastName) {
        fillUsingLocator(FIELD_NEW_LAST_NAME, newLastName);
    }

    @Step("Заполнить поле 'Фамилия супруга': {spouseLastName}")
    public void fillSpouseLastName(String spouseLastName) {
        fillUsingLocator(FIELD_SPOUSE_LAST_NAME, spouseLastName);
    }

    @Step("Заполнить поле 'Имя супруга': {spouseFirstName}")
    public void fillSpouseFirstName(String spouseFirstName) {
        fillUsingLocator(FIELD_SPOUSE_FIRST_NAME, spouseFirstName);
    }

    @Step("Заполнить поле 'Отчество супруга': {spouseMiddleName}")
    public void fillSpouseMiddleName(String spouseMiddleName) {
        fillUsingLocator(FIELD_SPOUSE_MIDDLE_NAME, spouseMiddleName);
    }

    @Step("Заполнить поле 'Дата рождения супруга': {spouseBirthDate}")
    public void fillSpouseBirthDate(String spouseBirthDate) {
        fillUsingLocator(FIELD_SPOUSE_BIRTH_DATE, spouseBirthDate);
    }

    @Step("Заполнить поле 'Номер паспорта супруга': {spousePassportNumber}")
    public void fillSpousePassportNumber(String spousePassportNumber) {
        fillUsingLocator(FIELD_SPOUSE_PASSPORT_NUMBER, spousePassportNumber);
    }

}
