package pages.locators;

import org.openqa.selenium.By;

public final class FormStepPageLocators {

    private FormStepPageLocators() {
    }

    public static final By NEXT_BUTTON = By.xpath("//button[text()='Далее']");
    public static final By COMPLETE_BUTTON = By.xpath("//button[text()='Завершить']");
}
