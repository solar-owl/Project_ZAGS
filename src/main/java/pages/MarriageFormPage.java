package pages;

import io.qameta.allure.Step;
import model.MarriageDetails;
import org.openqa.selenium.By;

public class MarriageFormPage extends BasePage{

    private final By fieldRegistrationDate = By.xpath("//div[contains(., 'Дата регистрации')]/following-sibling::input");
    private final By fieldNewLastName = By.xpath("//div[contains(., 'Новая фамилия')]/following-sibling::input");
    private final By fieldSpouseLastName = By.xpath("//div[contains(., 'Фамилия супруга')]/following-sibling::input");
    private final By fieldSpouseFirstName = By.xpath("//div[contains(., 'Имя супруга')]/following-sibling::input");
    private final By fieldSpouseMiddleName = By.xpath("//div[contains(., 'Отчество супруга')]/following-sibling::input");
    private final By fieldSpouseBirthDate = By.xpath("//div[contains(., 'Дата рождения')]/following-sibling::input");
    private final By fieldSpousePassportNumber = By.xpath("//div[contains(., 'Номер паспорта')]/following-sibling::input");

    @Step("Заполнить все поля формы регистрация брака")
    public void fill_all_fields_in_marriage_form(MarriageDetails details) {
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
        driver.findElement(fieldRegistrationDate).sendKeys(registrationDate);
    }

    @Step("Заполнить поле 'Новая фамилия': {newLastName}")
    public void fillNewLastName(String newLastName) {
        driver.findElement(fieldNewLastName).sendKeys(newLastName);
    }

    @Step("Заполнить поле 'Фамилия супруга': {spouseLastName}")
    public void fillSpouseLastName(String spouseLastName) {
        driver.findElement(fieldSpouseLastName).sendKeys(spouseLastName);
    }

    @Step("Заполнить поле 'Имя супруга': {spouseFirstName}")
    public void fillSpouseFirstName(String spouseFirstName) {
        driver.findElement(fieldSpouseFirstName).sendKeys(spouseFirstName);
    }

    @Step("Заполнить поле 'Отчество супруга': {spouseMiddleName}")
    public void fillSpouseMiddleName(String spouseMiddleName) {
        driver.findElement(fieldSpouseMiddleName).sendKeys(spouseMiddleName);
    }

    @Step("Заполнить поле 'Дата рождения супруга': {spouseBirthDate}")
    public void fillSpouseBirthDate(String spouseBirthDate) {
        driver.findElement(fieldSpouseBirthDate).sendKeys(spouseBirthDate);
    }

    @Step("Заполнить поле 'Номер паспорта супруга': {spousePassportNumber}")
    public void fillSpousePassportNumber(String spousePassportNumber) {
        driver.findElement(fieldSpousePassportNumber).sendKeys(spousePassportNumber);
    }

}
