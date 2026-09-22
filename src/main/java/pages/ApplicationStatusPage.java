package pages;

import org.openqa.selenium.By;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class ApplicationStatusPage extends BasePage {

    private final By thanksMessage = By.xpath("//span[contains(text(),'Спасибо')]");
    private final By statusMessage = By.xpath("//span[contains(.,'Статус заявки:')]");
    private final By registrationDateMessage = By.xpath("//span[contains(.,'Дата')]");

    public String getThanksText() {
        return getText(thanksMessage);
    }

    public String getStatusText() {
        return getText(statusMessage);
    }

    public String getRegistrationDateText() {
        return getText(registrationDateMessage);
    }

    public String getExpectedRegistrationDate() {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE MMM d yyyy", Locale.ENGLISH);
        return "Дата регистрации заявки " + today.format(formatter);
    }
}