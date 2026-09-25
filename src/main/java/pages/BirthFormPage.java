package pages;

import io.qameta.allure.Step;
import model.BirthDetails;
import org.openqa.selenium.By;

public class BirthFormPage extends BasePage{

    private final By fieldBirthPlace = By.xpath("//div[contains(., 'Место рождения')]/following-sibling::input");
    private final By fieldMother = By.xpath("//div[contains(., 'Мать')]/following-sibling::input");
    private final By fieldFather = By.xpath("//div[contains(., 'Отец')]/following-sibling::input");
    private final By fieldGrandMother = By.xpath("//div[contains(., 'Бабушка')]/following-sibling::input");
    private final By fieldGrandFather = By.xpath("//div[contains(., 'Дедушка')]/following-sibling::input");

    @Step("Заполнить все поля формы рождения")
    public void fill_all_fields_in_birth_form(BirthDetails details) {
        fillBirthPlace(details.getBirthPlace());
        fillMother(details.getMother());
        fillFather(details.getFather());
        fillGrandMother(details.getGrandMother());
        fillGrandFather(details.getGrandFather());
    }

    @Step("Заполнить поле 'Место рождения': {birthPlace}")
    public void fillBirthPlace(String birthPlace) {
        driver.findElement(fieldBirthPlace).sendKeys(birthPlace);
    }

    @Step("Заполнить поле 'Мать': {mother}")
    public void fillMother(String mother) {
        driver.findElement(fieldMother).sendKeys(mother);
    }

    @Step("Заполнить поле 'Отец': {father}")
    public void fillFather(String father) {
        driver.findElement(fieldFather).sendKeys(father);
    }

    @Step("Заполнить поле 'Бабушка': {grandMother}")
    public void fillGrandMother(String grandMother) {
        driver.findElement(fieldGrandMother).sendKeys(grandMother);
    }

    @Step("Заполнить поле 'Дедушка': {grandFather}")
    public void fillGrandFather(String grandFather) {
        driver.findElement(fieldGrandFather).sendKeys(grandFather);
    }
}
