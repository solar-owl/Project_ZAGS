package pages;

import io.qameta.allure.Step;
import org.testng.Assert;

import static pages.locators.FormStepPageLocators.*;

public class FormStepPage extends BasePage {

    @Step("Нажать кнопку 'Далее'")
    public void clickNextButton() {
        clickUsingLocator(NEXT_BUTTON);
    }

    @Step("Проверить, что кнопка 'Далее' активна")
    public FormStepPage checkNextButtonEnabled() {
        Assert.assertTrue(isButtonEnabled(NEXT_BUTTON), "Кнопка 'Далее' disabled");
        return this;
    }

    @Step("Нажать кнопку 'Завершить'")
    public void clickCompleteButton() { clickUsingLocator(COMPLETE_BUTTON); }

    @Step("Проверить, что кнопка 'Завершить' активна")
    public FormStepPage checkCompleteButtonEnabled() {
        Assert.assertTrue(isButtonEnabled(COMPLETE_BUTTON), "Кнопка 'Завершить' disabled");
        return this;
    }
}