package pages;

import driver.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {

    protected final WebDriver driver = DriverSingleton.getDriver();

}