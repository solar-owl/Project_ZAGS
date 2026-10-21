package pages.locators;

import org.openqa.selenium.By;

public final class AdminApplicationPageLocators {

    private AdminApplicationPageLocators() {
    }

    public static final By TABLE_ROWS = By.xpath("//table/tr");
    public static final By REFRESH_BUTTON = By.xpath("//button[contains(., 'Обновить')]");
    public static final By NEXT_PAGE_BUTTON = By.xpath("//button[@aria-label='Go to next page']");
    public static final By PREV_PAGE_BUTTON = By.xpath("//button[@aria-label='Go to previous page']");

    public static final String PAGE_NUMBER_BUTTON_XPATH = "//button[text()='%d']";

}