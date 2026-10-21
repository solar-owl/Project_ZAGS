package pages;

import io.qameta.allure.Step;
import model.Applicant;
import static pages.locators.ApplicantFormPageLocators.*;

public class ApplicantFormPage extends BasePage{

    @Step("Заполнить все поля формы заявителя")
    public void fillAllFieldsInApplicantForm(Applicant applicant) {
        fillLastName(applicant.getLastName());
        fillFirstName(applicant.getFirstName());
        fillMiddleName(applicant.getMiddleName());
        fillPhone(applicant.getPhone());
        fillPassportNumber(applicant.getPassportNumber());
        fillRedistrationAddress(applicant.getRegistrationAddress());
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

    @Step("Заполнить поле 'Адрес прописки': {registrationAddress}")
    public void fillRedistrationAddress(String birthDate) {
        fillUsingLocator(FIELD_REGISTRATION_ADDRESS, birthDate);
    }
}
