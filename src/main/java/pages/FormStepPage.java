package pages;

import org.openqa.selenium.By;

public class FormStepPage extends BasePage {
    protected static final By nextButton = By.xpath("//button[text()='Далее']");
    protected static final By completeButton = By.xpath("//button[text()='Завершить']");

    public boolean isNextButtonEnabled() {
        return isEnabled(nextButton);
    }

    public void clickNextButton() {
        click(nextButton);
    }

    public boolean isCompleteButtonEnabled() {
        return isEnabled(completeButton);
    }

    public void clickCompleteButton() { click(completeButton); }

}