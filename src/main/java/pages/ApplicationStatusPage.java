package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class ApplicationStatusPage extends BasePage {

    private final By thanksMessage = By.xpath("//span[contains(text(),'Спасибо')]");
    private final By statusMessage = By.xpath("//span[contains(.,'Статус заявки:')]");
    private final By registrationDateMessage = By.xpath("//span[contains(.,'Дата')]");

    public String getThanksText() {
        return driver.findElement(thanksMessage).getText();
    }

    public String getStatusText() {
        return driver.findElement(statusMessage).getText();
    }

    public String getRegistrationDateText() {
        return driver.findElement(registrationDateMessage).getText();
    }

    public String getExpectedRegistrationDate() {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE MMM d yyyy", Locale.ENGLISH);
        return "Дата регистрации заявки " + today.format(formatter);
    }

    @Step("Проверить текст благодарности: '{expectedText}'")
    public void checkThanksText(String expectedText) {
        Assert.assertEquals(getThanksText(), expectedText,
                "Неверный текст благодарности");
    }

    @Step("Проверить статус заявки: '{expectedStatus}'")
    public void checkStatusText(String expectedStatus) {
        Assert.assertEquals(getStatusText(), expectedStatus,
                "Неверный статус заявки");
    }

    @Step("Проверить дату регистрации заявки")
    public void checkRegistrationDate() {
        Assert.assertEquals(getRegistrationDateText(), getExpectedRegistrationDate(),
                "Неверная дата регистрации");
    }
}