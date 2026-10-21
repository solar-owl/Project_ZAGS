package pages.locators;

import org.openqa.selenium.By;

public final class BirthFormPageLocators {

    private BirthFormPageLocators() {
    }

    public static final By FIELD_BIRTH_PLACE =
            By.xpath("//div[contains(., 'Место рождения')]/following-sibling::input");
    public static final By FIELD_MOTHER =
            By.xpath("//div[contains(., 'Мать')]/following-sibling::input");
    public static final By FIELD_FATHER =
            By.xpath("//div[contains(., 'Отец')]/following-sibling::input");
    public static final By FIELD_GRAND_MOTHER =
            By.xpath("//div[contains(., 'Бабушка')]/following-sibling::input");
    public static final By FIELD_GRAND_FATHER =
            By.xpath("//div[contains(., 'Дедушка')]/following-sibling::input");
}
