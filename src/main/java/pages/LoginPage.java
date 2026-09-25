package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private static final String USERNAME = "user";
    private static final String PASSWORD = "senlatest";
    private static final String URL = "https://" + USERNAME + ":" + PASSWORD + "@regoffice.senla.eu";

    private final By loginAsUserButton = By.xpath("//button[contains(., 'Войти как пользователь')]");
    private final By loginAsAdminButton = By.xpath("//button[contains(., 'Войти как администратор')]");

    @Step("Открыть страницу https://regoffice.senla.eu")
    public void open() {
        driver.get(URL);
    }

    @Step("Войти как пользователь")
    public void loginAsUser() {
        driver.findElement(loginAsUserButton).click();
    }

    @Step("Войти как администратор")
    public void loginAsAdmin() {
        driver.findElement(loginAsAdminButton).click();
    }
}