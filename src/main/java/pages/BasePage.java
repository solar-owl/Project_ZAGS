package pages;

import driver.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {

    protected final WebDriver driver = DriverSingleton.getDriver();

    //насколько это хороший вариант в плане использования XPAth? (Обобщение, но что-то может измениться)
    protected By inputByLabel(String label) {
        return By.xpath("//div[contains(., '" + label + "')]/following-sibling::input");
    }

    protected void type(String label, String value) {
        driver.findElement(inputByLabel(label)).sendKeys(value);
    }

    protected void click(By locator) {
        driver.findElement(locator).click();
    }

    protected boolean isEnabled(By locator) {
        return driver.findElement(locator).isEnabled();
    }

    protected String getText(By locator) {
        return driver.findElement(locator).getText();
    }
}