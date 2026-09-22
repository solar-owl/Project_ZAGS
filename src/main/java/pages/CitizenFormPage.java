package pages;

import model.Citizen;

public class CitizenFormPage extends BasePage{

    public void fill(Citizen citizen) {
        type("Фамилия", citizen.getLastName());
        type("Имя", citizen.getFirstName());
        type("Отчество", citizen.getMiddleName());
        type("Дата рождения", citizen.getBirthDate());
        type("Номер паспорта", citizen.getPassportNumber());
        type("Пол", citizen.getGender());
        type("Адрес прописки", citizen.getRegistrationAddress());
    }

}
