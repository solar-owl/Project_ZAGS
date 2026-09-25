package pages;

import io.qameta.allure.Step;
import model.DeathDetails;
import org.openqa.selenium.By;

public class DeathFormPage extends BasePage{

    private final By fieldDeathDate = By.xpath("//div[contains(., 'Дата смерти')]/following-sibling::input");
    private final By fieldDeathPlace = By.xpath("//div[contains(., 'Место смерти')]/following-sibling::input");

    @Step("Заполнить все поля формы регистрация смерти")
    public void fill_all_fields_in_death_form(DeathDetails details) {
        fillDeathDate(details.getDeathDate());
        fillDeathPlace(details.getDeathPlace());
    }

    @Step("Заполнить поле 'Дата смерти': {deathDate}")
    public void fillDeathDate(String deathDate) {
        driver.findElement(fieldDeathDate).sendKeys(deathDate);
    }

    @Step("Заполнить поле 'Место смерти': {deathPlace}")
    public void fillDeathPlace(String deathPlace) {
        driver.findElement(fieldDeathPlace).sendKeys(deathPlace);
    }

}
