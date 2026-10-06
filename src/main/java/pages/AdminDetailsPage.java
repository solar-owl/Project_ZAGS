package pages;

import io.qameta.allure.Step;
import model.AdminDetails;
import org.openqa.selenium.By;

public class AdminDetailsPage extends BasePage{

    private final By fieldLastName = By.xpath("//div[contains(., 'Фамилия')]/following-sibling::input");
    private final By fieldFirstName = By.xpath("//div[contains(., 'Имя')]/following-sibling::input");
    private final By fieldMiddleName = By.xpath("//div[contains(., 'Отчество')]/following-sibling::input");
    private final By fieldPhoneNumber = By.xpath("//div[contains(., 'Телефон')]/following-sibling::input");
    private final By fieldPassportNumber = By.xpath("//div[contains(., 'Номер паспорта')]/following-sibling::input");
    private final By fieldBirthDate = By.xpath("//div[contains(., 'Дата рождения')]/following-sibling::input");

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

    @Step("Заполнить поле 'Телефон': {phone}")
    public void fillPhone(String phone) {
        driver.findElement(fieldPhoneNumber).sendKeys(phone);
    }

    @Step("Заполнить поле 'Номер паспорта': {passportNumber}")
    public void fillPassportNumber(String passportNumber) {
        driver.findElement(fieldPassportNumber).sendKeys(passportNumber);
    }

    @Step("Заполнить поле 'Дата рождения': {birthDate}")
    public void fillBirthDate(String birthDate) {
        driver.findElement(fieldBirthDate).sendKeys(birthDate);
    }
}
