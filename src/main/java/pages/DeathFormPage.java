package pages;

import model.DeathDetails;

public class DeathFormPage extends BasePage{

    public void fill(DeathDetails details) {
        type("Дата смерти", details.getDeathDate());
        type("Место смерти", details.getDeathPlace());
    }

}
