package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

public class FormStepPage extends BasePage {
    protected static final By nextButton = By.xpath("//button[text()='Далее']");
    protected static final By completeButton = By.xpath("//button[text()='Завершить']");

    @Step("Проверить, что кнопка 'Далее' активна")
    public boolean isNextButtonEnabled() {
        return driver.findElement(nextButton).isEnabled();
    }

    @Step("Нажать кнопку 'Далее'")
    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }

    @Step("Проверить, что кнопка 'Далее' активна")
    public FormStepPage checkNextButtonEnabled() {
        Assert.assertTrue(isNextButtonEnabled(), "Кнопка 'Далее' disabled");
        return this;
    }

    @Step("Проверить, что кнопка 'Завершить' активна")
    public boolean isCompleteButtonEnabled() {
        return driver.findElement(completeButton).isEnabled();
    }

    @Step("Нажать кнопку 'Завершить'")
    public void clickCompleteButton() { driver.findElement(completeButton).click(); }

    @Step("Проверить, что кнопка 'Завершить' активна")
    public FormStepPage checkCompleteButtonEnabled() {
        Assert.assertTrue(isCompleteButtonEnabled(), "Кнопка 'Завершить' disabled");
        return this;
    }
}