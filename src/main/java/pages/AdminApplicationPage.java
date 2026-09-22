package pages;

import elements.ApplicationRow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class AdminApplicationPage extends BasePage{

    private final By tableRows = By.xpath("//table/tr");
    private final By refreshButton = By.xpath("//button[contains(., 'Обновить')]");
    private final String PAGE_NUMBER_BUTTON_XPATH = "//button[text()='%d']";
    private final By nextPageButton = By.xpath("//button[@aria-label='Go to next page']");
    private final By prevPageButton = By.xpath("//button[@aria-label='Go to previous page']");

    public List<ApplicationRow> getRows() {
        List<WebElement> rows = driver.findElements(tableRows);
        return rows.stream()
                .map(ApplicationRow::new)
                .collect(Collectors.toList());
    }

    public ApplicationRow getRowByNumber(String number) {
        return getRows().stream()
                .filter(row -> row.getNumber().equals(number))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Заявка № " + number + " не найдена на текущей странице"));
    }

    public ApplicationRow getFirstRowWithStatus(String status) {
        return getRows().stream()
                .filter(row -> row.getStatus().equals(status))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Заявка со статусом" + status + " не найдена на текущей странице"));
    }

    public void waitForStatus(String applicationNumber, String expectedStatus) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(d -> getRowByNumber(applicationNumber).getStatus().equals(expectedStatus));
    }

    public void goToPage(int pageNumber) {
        By locator = By.xpath(String.format(PAGE_NUMBER_BUTTON_XPATH, pageNumber));
        click(locator);
    }

    public void goToNextPage() {
        click(nextPageButton);
    }

    public void goToPreviousPage() {
        click(prevPageButton);
    }

    public void refresh() {
        click(refreshButton);
    }
}
