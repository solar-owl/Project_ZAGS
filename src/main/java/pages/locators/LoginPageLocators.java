package pages.locators;

import org.openqa.selenium.By;

public final class LoginPageLocators {

    private LoginPageLocators() {
    }

    public static final By LOGIN_AS_USER_BUTTON =
            By.xpath("//button[contains(., 'Войти как пользователь')]");
    public static final By LOGIN_AS_ADMIN_BUTTON =
            By.xpath("//button[contains(., 'Войти как администратор')]");
}
