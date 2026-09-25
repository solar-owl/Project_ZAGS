package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class ServiceSelectionPage extends BasePage {
    private static final By marriageRegistrationButton = By.xpath("//button[text()='Регистрация брака']");
    private static final By birthRegistrationButton = By.xpath("//button[text()='Регистрация рождения']");
    private static final By deathRegistrationButton = By.xpath("//button[text()='Регистрация смерти']");

    @Step("Выбрать услугу: регистрация брака")
    public void selectMarriageRegistration() {
        driver.findElement(marriageRegistrationButton).click();
    }

    @Step("Выбрать услугу: регистрация рождения")
    public void selectBirthRegistration() {
        driver.findElement(birthRegistrationButton).click();
    }

    @Step("Выбрать услугу: регистрация смерти")
    public void selectDeathRegistration() {
        driver.findElement(deathRegistrationButton).click();
    }
}