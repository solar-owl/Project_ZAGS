package pages;

import driver.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {

    protected final WebDriver driver = DriverSingleton.getDriver();

    public void fillUsingLocator(By locator, String value) {
        driver.findElement(locator).sendKeys(value);
    }

    public void clickUsingLocator(By locator) {
        driver.findElement(locator).click();
    }

    public boolean isButtonEnabled(By locator) {
        return driver.findElement(locator).isEnabled();
    }

    public String getText(By locator) {
        return driver.findElement(locator).getText();
    }
}