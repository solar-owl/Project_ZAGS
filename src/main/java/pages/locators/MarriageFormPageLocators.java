package pages.locators;

import org.openqa.selenium.By;

public final class MarriageFormPageLocators {

    private MarriageFormPageLocators() {
    }

    public static final By FIELD_REGISTRATION_DATE =
            By.xpath("//div[contains(., 'Дата регистрации')]/following-sibling::input");
    public static final By FIELD_NEW_LAST_NAME =
            By.xpath("//div[contains(., 'Новая фамилия')]/following-sibling::input");
    public static final By FIELD_SPOUSE_LAST_NAME =
            By.xpath("//div[contains(., 'Фамилия супруга')]/following-sibling::input");
    public static final By FIELD_SPOUSE_FIRST_NAME =
            By.xpath("//div[contains(., 'Имя супруга')]/following-sibling::input");
    public static final By FIELD_SPOUSE_MIDDLE_NAME =
            By.xpath("//div[contains(., 'Отчество супруга')]/following-sibling::input");
    public static final By FIELD_SPOUSE_BIRTH_DATE =
            By.xpath("//div[contains(., 'Дата рождения')]/following-sibling::input");
    public static final By FIELD_SPOUSE_PASSPORT_NUMBER =
            By.xpath("//div[contains(., 'Номер паспорта')]/following-sibling::input");
}