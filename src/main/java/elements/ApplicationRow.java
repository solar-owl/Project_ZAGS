package elements;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ApplicationRow {

    private static final Logger logger = LogManager.getLogger(ApplicationRow.class);

    private final WebElement row;
    private final By numberCell = By.xpath("./td[1]");
    private final By applicantCell = By.xpath("./td[2]");
    private final By typeCell = By.xpath("./td[3]");
    private final By timeCell = By.xpath("./td[4]");
    private final By statusCell = By.xpath("./td[5]");
    private final By approveButton = By.xpath(".//*[@data-testid='ThumbUpIcon']/ancestor::button");
    private final By rejectButton = By.xpath(".//*[@data-testid='ThumbDownIcon']/ancestor::button");

    public ApplicationRow(WebElement row) {
        this.row = row;
        logger.debug("Создан ApplicationRow");
    }

    public String getNumber() {
        String value = row.findElement(numberCell).getText();
        logger.debug("Получен номер заявки: {}", value);
        return value;
    }

    public String getApplicant() {
        String value = row.findElement(applicantCell).getText();
        logger.debug("Получен заявитель: {}", value);
        return value;
    }

    public String getType() {
        String value = row.findElement(typeCell).getText();
        logger.debug("Получен тип услуги: {}", value);
        return value;
    }

    public String getTime() {
        String value = row.findElement(timeCell).getText();
        logger.debug("Получено время подачи: {}", value);
        return value;
    }

    public String getStatus() {
        String value = row.findElement(statusCell).getText();
        logger.debug("Получен статус заявки: {}", value);
        return value;
    }

    public void approve() {
        String number = getNumber();
        logger.info("Подтверждение заявки № {}", number);
        row.findElement(approveButton).click();
        logger.info("Кнопка 'Подтвердить' нажата для заявки № {}", number);
    }

    public void reject() {
        String number = getNumber();
        logger.info("Отклонение заявки № {}", number);
        row.findElement(rejectButton).click();
        logger.info("Кнопка 'Отклонить' нажата для заявки № {}", number);
    }

    @Override
    public String toString() {
        return "заявка № " + getNumber();
    }
}