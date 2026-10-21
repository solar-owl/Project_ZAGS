package pages;

import io.qameta.allure.Step;
import model.AdminDetails;
import static pages.locators.AdminDetailsPageLocators.*;

public class AdminDetailsPage extends BasePage{

    @Step("Заполнить все поля формы данных администратора")
    public void fillAllFieldsInDetailForm(AdminDetails adminDetails) {
        fillLastName(adminDetails.getLastName());
        fillFirstName(adminDetails.getFirstName());
        fillMiddleName(adminDetails.getMiddleName());
        fillPhone(adminDetails.getPhone());
        fillPassportNumber(adminDetails.getPassportNumber());
        fillBirthDate(adminDetails.getBirthDate());
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

    @Step("Заполнить поле 'Телефон': {phone}")
    public void fillPhone(String phone) {
        fillUsingLocator(FIELD_PHONE_NUMBER, phone);
    }

    @Step("Заполнить поле 'Номер паспорта': {passportNumber}")
    public void fillPassportNumber(String passportNumber) {
        fillUsingLocator(FIELD_PASSPORT_NUMBER, passportNumber);
    }

    @Step("Заполнить поле 'Дата рождения': {birthDate}")
    public void fillBirthDate(String birthDate) {
        fillUsingLocator(FIELD_BIRTH_DATE, birthDate);
    }
}
