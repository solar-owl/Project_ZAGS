package pages;

import model.BirthDetails;

public class BirthFormPage extends BasePage{

    public void fill(BirthDetails details) {
        type("Место рождения", details.getBirthPlace());
        type("Мать", details.getMother());
        type("Отец", details.getFather());
        type("Бабушка", details.getGrandMother());
        type("Дедушка", details.getGrandFather());
    }

}
