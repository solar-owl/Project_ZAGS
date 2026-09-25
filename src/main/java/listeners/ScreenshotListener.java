package listeners;

import driver.DriverSingleton;
import io.qameta.allure.Attachment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class ScreenshotListener implements IInvokedMethodListener {

    private static final Logger logger = LogManager.getLogger(ScreenshotListener.class);

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult result) {
        if (!method.isTestMethod()) {
            return;
        }

        if (result.getStatus() == ITestResult.FAILURE) {
            logger.error("Тест упал: {} | Причина: {}",
                    result.getName(),
                    result.getThrowable() != null ? result.getThrowable().getMessage() : "неизвестна");

            WebDriver driver = DriverSingleton.getDriver();
            if (driver != null) {
                try {
                    saveScreenshot(driver);
                    logger.info("Скриншот прикреплён к упавшему тесту: {}", result.getName());
                } catch (Exception e) {
                    logger.error("Не удалось сделать скриншот для теста {}: {}",
                            result.getName(), e.getMessage());
                }
            } else {
                logger.warn("Скриншот не сделан: драйвер уже закрыт (тест: {})", result.getName());
            }
        } else if (result.getStatus() == ITestResult.SKIP) {
            logger.warn("Тест пропущен: {}", result.getName());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            logger.debug("Тест пройден: {}", result.getName());
        }
    }

    @Attachment(value = "Скриншот при падении", type = "image/png")
    public byte[] saveScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}