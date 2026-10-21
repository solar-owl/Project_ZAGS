package pages.locators;

import org.openqa.selenium.By;

public final class DeathFormPageLocators {

    private DeathFormPageLocators() {
    }

    public static final By FIELD_DEATH_DATE =
            By.xpath("//div[contains(., 'Дата смерти')]/following-sibling::input");
    public static final By FIELD_DEATH_PLACE =
            By.xpath("//div[contains(., 'Место смерти')]/following-sibling::input");
}
