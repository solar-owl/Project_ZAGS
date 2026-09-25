package driver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public final class DriverSingleton {

    private static final Logger logger = LogManager.getLogger(DriverSingleton.class);
    private static WebDriver driver;

    private DriverSingleton(){}

    public static WebDriver getDriver() {
        if (driver == null) {
            logger.info("Создание нового экземпляра ChromeDriver");
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
            driver.manage().window().maximize();
            logger.info("ChromeDriver создан, окно развёрнуто");
        }else {
            logger.debug("Возврат существующего экземпляра ChromeDriver");
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            logger.info("Закрытие ChromeDriver");
            driver.quit();
            driver = null;logger.info("ChromeDriver закрыт, ссылка обнулена");
        } else {
            logger.warn("Попытка закрыть драйвер, но он уже null");
        }
    }
}