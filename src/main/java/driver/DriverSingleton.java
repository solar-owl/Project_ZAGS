package driver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URI;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public final class DriverSingleton {

    private static final Logger logger = LogManager.getLogger(DriverSingleton.class);
    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();
    private static final String HUB_URL =
            System.getProperty("selenoid.url", "http://localhost:4444/wd/hub");

    private DriverSingleton() {}

    public static WebDriver getDriver() {
        return getDriver("chrome");
    }

    public static WebDriver getDriver(String browser) {
        if (DRIVER.get() == null) {
            logger.info("Создание RemoteWebDriver ({}) в потоке {}",
                    browser, Thread.currentThread().getName());
            try {
                Capabilities caps = buildCapabilities(browser);
                WebDriver driver = new RemoteWebDriver(URI.create(HUB_URL).toURL(), caps);
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
                driver.manage().window().maximize();
                DRIVER.set(driver);
            } catch (Exception e) {
                throw new RuntimeException("Не удалось создать RemoteWebDriver для " + browser, e);
            }
        }
        return DRIVER.get();
    }

    private static Capabilities buildCapabilities(String browser) {
        Map<String, Object> selenoidOptions = new HashMap<>();
        selenoidOptions.put("enableVNC", true);
        selenoidOptions.put("name", browser + " @ " + Thread.currentThread().getName());
        selenoidOptions.put("screenResolution", "1920x1080x24");
        selenoidOptions.put("sessionTimeout", "2m");

        switch (browser.toLowerCase()) {
            case "firefox": {
                FirefoxOptions options = new FirefoxOptions();
                options.setCapability("selenoid:options", selenoidOptions);
                return options;
            }
            case "edge": {
                EdgeOptions options = new EdgeOptions();
                options.setCapability("selenoid:options", selenoidOptions);
                return options;
            }
            case "chrome":
            default: {
                ChromeOptions options = new ChromeOptions();
                options.setCapability("selenoid:options", selenoidOptions);
                return options;
            }
        }
    }

    public static void quitDriver() {
        WebDriver driver = DRIVER.get();
        if (driver != null) {
            logger.info("Закрытие драйвера в потоке {}", Thread.currentThread().getName());
            driver.quit();
            DRIVER.remove();
        } else {
            logger.warn("Попытка закрыть драйвер, но он уже null");
        }
    }
}