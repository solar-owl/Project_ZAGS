package pages.locators;

import org.openqa.selenium.By;

public final class ServiceSelectionPageLocators {

    private ServiceSelectionPageLocators() {
    }

    public static final By MARRIAGE_REGISTRATION_BUTTON =
            By.xpath("//button[text()='Регистрация брака']");
    public static final By BIRTH_REGISTRATION_BUTTON =
            By.xpath("//button[text()='Регистрация рождения']");
    public static final By DEATH_REGISTRATION_BUTTON =
            By.xpath("//button[text()='Регистрация смерти']");
}