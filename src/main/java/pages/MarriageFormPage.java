package pages;

import model.MarriageDetails;

public class MarriageFormPage extends BasePage{

    public void fill(MarriageDetails details) {
        type("Дата регистрации", details.getRegistrationDate());
        type("Новая фамилия", details.getNewLastName());
        type("Фамилия супруга", details.getSpouseLastName());
        type("Имя супруга", details.getSpouseFirstName());
        type("Отчество супруга", details.getSpouseMiddleName());
        type("Дата рождения", details.getSpouseBirthDate());
        type("Номер паспорта", details.getSpousePassportNumber());
    }

}
