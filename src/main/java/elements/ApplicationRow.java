package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ApplicationRow {

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
    }

    public String getNumber() {
        return row.findElement(numberCell).getText();
    }

    public String getApplicant() {
        return row.findElement(applicantCell).getText();
    }

    public String getType() {
        return row.findElement(typeCell).getText();
    }

    public String getTime() {
        return row.findElement(timeCell).getText();
    }

    public String getStatus() {
        return row.findElement(statusCell).getText();
    }

    public void approve() {
        row.findElement(approveButton).click();
    }

    public void reject() {
        row.findElement(rejectButton).click();
    }
}
