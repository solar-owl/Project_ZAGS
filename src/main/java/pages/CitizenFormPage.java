package pages;

import io.qameta.allure.Step;
import model.Citizen;
import org.openqa.selenium.By;

public class CitizenFormPage extends BasePage{

    private final By fieldLastName = By.xpath("//div[contains(., 'Фамилия')]/following-sibling::input");
    private final By fieldFirstName = By.xpath("//div[contains(., 'Имя')]/following-sibling::input");
    private final By fieldMiddleName = By.xpath("//div[contains(., 'Отчество')]/following-sibling::input");
    private final By fieldPassportNumber = By.xpath("//div[contains(., 'Номер паспорта')]/following-sibling::input");
    private final By fieldBirthDate = By.xpath("//div[contains(., 'Дата рождения')]/following-sibling::input");
    private final By fieldGender = By.xpath("//div[contains(., 'Пол')]/following-sibling::input");
    private final By fieldRegistrationAddress = By.xpath("//div[contains(., 'Адрес прописки')]/following-sibling::input");

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
        driver.findElement(fieldLastName).sendKeys(lastName);
    }

    @Step("Заполнить поле 'Имя': {firstName}")
    public void fillFirstName(String firstName) {
        driver.findElement(fieldFirstName).sendKeys(firstName);
    }

    @Step("Заполнить поле 'Отчество': {middleName}")
    public void fillMiddleName(String middleName) {
        driver.findElement(fieldMiddleName).sendKeys(middleName);
    }

    @Step("Заполнить поле 'Дата рождения': {birthDate}")
    public void fillPassportNumber(String passportNumber) {
        driver.findElement(fieldPassportNumber).sendKeys(passportNumber);
    }

    @Step("Заполнить поле 'Номер паспорта': {passportNumber}")
    public void fillBirthDate(String birthDate) {
        driver.findElement(fieldBirthDate).sendKeys(birthDate);
    }

    @Step("Заполнить поле 'Пол': {gender}")
    public void fillGender(String gender) {
        driver.findElement(fieldGender).sendKeys(gender);
    }

    @Step("Заполнить поле 'Адрес прописки': {registrationAddress}")
    public void fillRegistrationAddress(String registrationAddress) {
        driver.findElement(fieldRegistrationAddress).sendKeys(registrationAddress);
    }

}
