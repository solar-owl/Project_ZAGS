package pages;

import org.openqa.selenium.By;

public class ServiceSelectionPage extends BasePage {
    private static final By marriageRegistrationButton = By.xpath("//button[text()='Регистрация брака']");
    private static final By birthRegistrationButton = By.xpath("//button[text()='Регистрация рождения']");
    private static final By deathRegistrationButton = By.xpath("//button[text()='Регистрация смерти']");

    public void selectMarriageRegistration() {
        click(marriageRegistrationButton);
    }

    public void selectBirthRegistration() {
        click(birthRegistrationButton);
    }

    public void selectDeathRegistration() {
        click(deathRegistrationButton);
    }
}