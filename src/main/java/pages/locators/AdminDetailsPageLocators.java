package pages.locators;

import org.openqa.selenium.By;

public final class AdminDetailsPageLocators {

    private AdminDetailsPageLocators() {
    }

    public static final By FIELD_LAST_NAME =
            By.xpath("//div[contains(., 'Фамилия')]/following-sibling::input");
    public static final By FIELD_FIRST_NAME =
            By.xpath("//div[contains(., 'Имя')]/following-sibling::input");
    public static final By FIELD_MIDDLE_NAME =
            By.xpath("//div[contains(., 'Отчество')]/following-sibling::input");
    public static final By FIELD_PHONE_NUMBER =
            By.xpath("//div[contains(., 'Телефон')]/following-sibling::input");
    public static final By FIELD_PASSPORT_NUMBER =
            By.xpath("//div[contains(., 'Номер паспорта')]/following-sibling::input");
    public static final By FIELD_BIRTH_DATE =
            By.xpath("//div[contains(., 'Дата рождения')]/following-sibling::input");
}