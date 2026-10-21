package pages;

import io.qameta.allure.Step;
import model.Citizen;
import static pages.locators.CitizenFormPageLocators.*;

public class CitizenFormPage extends BasePage{

    @Step("Заполнить все поля формы Данные гражданина")
    public void fillAllFieldsInCitizenForm(Citizen citizen) {
        fillLastName(citizen.getLastName());
        fillFirstName(citizen.getFirstName());
        fillMiddleName(citizen.getMiddleName());
        fillBirthDate(citizen.getBirthDate());
        fillPassportNumber(citizen.getPassportNumber());
        fillGender(citizen.getGender());
        fillRegistrationAddress(citizen.getRegistrationAddress());

    }

    @Step("Заполнить поле 'Фамилия': {lastName}")
    public void fillLastName(String lastName) {
        fillUsingLocator(FIELD_LAST_NAME, lastName);
    }

    @Step("Заполнить поле 'Имя': {firstName}")
    public void fillFirstName(String firstName) {
        fillUsingLocator(FIELD_FIRST_NAME, firstName);
    }

    @Step("Заполнить поле 'Отчество': {middleName}")
    public void fillMiddleName(String middleName) {
        fillUsingLocator(FIELD_MIDDLE_NAME, middleName);
    }

    @Step("Заполнить поле 'Дата рождения': {birthDate}")
    public void fillPassportNumber(String passportNumber) {
        fillUsingLocator(FIELD_PASSPORT_NUMBER, passportNumber);
    }

    @Step("Заполнить поле 'Номер паспорта': {passportNumber}")
    public void fillBirthDate(String birthDate) {
        fillUsingLocator(FIELD_BIRTH_DATE, birthDate);
    }

    @Step("Заполнить поле 'Пол': {gender}")
    public void fillGender(String gender) {
        fillUsingLocator(FIELD_GENDER, gender);
    }

    @Step("Заполнить поле 'Адрес прописки': {registrationAddress}")
    public void fillRegistrationAddress(String registrationAddress) {
        fillUsingLocator(FIELD_REGISTRATION_ADDRESS, registrationAddress);
    }

}
