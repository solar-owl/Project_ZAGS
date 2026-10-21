package pages;

import elements.ApplicationRow;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import static pages.locators.AdminApplicationPageLocators.*;

public class AdminApplicationPage extends BasePage{


    public List<ApplicationRow> getRows() {
        List<WebElement> rows = driver.findElements(TABLE_ROWS);
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

    @Step("Перейти на страницу номер {pageNumber}")
    public AdminApplicationPage goToPage(int pageNumber) {
        By locator = By.xpath(String.format(PAGE_NUMBER_BUTTON_XPATH, pageNumber));
        driver.findElement(locator).click();
        return this;
    }

    @Step("Перейти на следующую страницу")
    public AdminApplicationPage goToNextPage() {
        driver.findElement(NEXT_PAGE_BUTTON).click();
        return this;
    }

    @Step("Перейти на предыдущую страницу")
    public AdminApplicationPage goToPreviousPage() {
        clickUsingLocator(PREV_PAGE_BUTTON);
        return this;
    }

    @Step("Нажать кнопку 'Обновить'")
    public void refresh() {
        clickUsingLocator(REFRESH_BUTTON);
    }

    @Step("Проверить, что заявка {row} имеет статус '{expectedStatus}'")
    public void checkRowStatus(ApplicationRow row, String expectedStatus) {
        Assert.assertEquals(row.getStatus(), expectedStatus,
                "Заявка № " + row.getNumber() + " должна иметь статус '" + expectedStatus + "'");
    }
}
