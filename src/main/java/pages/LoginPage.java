package pages;

import io.qameta.allure.Step;
import static utils.LoginCredentials.URL;
import static pages.locators.LoginPageLocators.*;

public class LoginPage extends BasePage {

    @Step("Открыть страницу https://regoffice.senla.eu")
    public void open() {
        driver.get(URL);
    }

    @Step("Войти как пользователь")
    public void loginAsUser() {
        clickUsingLocator(LOGIN_AS_USER_BUTTON);
    }

    @Step("Войти как администратор")
    public void loginAsAdmin() {
        clickUsingLocator(LOGIN_AS_ADMIN_BUTTON);
    }
}