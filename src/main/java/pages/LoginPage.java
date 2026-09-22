package pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private static final String USERNAME = "user";
    private static final String PASSWORD = "senlatest";
    private static final String URL = "https://" + USERNAME + ":" + PASSWORD + "@regoffice.senla.eu";

    private final By loginAsUserButton = By.xpath("//button[contains(., 'Войти как пользователь')]");
    private final By loginAsAdminButton = By.xpath("//button[contains(., 'Войти как администратор')]");

    public void open() {
        driver.get(URL);
    }

    public void loginAsUser() {
        click(loginAsUserButton);
    }

    public void loginAsAdmin() {
        click(loginAsAdminButton);
    }
}