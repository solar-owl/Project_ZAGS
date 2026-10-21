package pages.locators;

import org.openqa.selenium.By;

public final class ApplicantFormPageLocators {

    private ApplicantFormPageLocators() {
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
    public static final By FIELD_REGISTRATION_ADDRESS =
            By.xpath("//div[contains(., 'Адрес прописки')]/following-sibling::input");
}