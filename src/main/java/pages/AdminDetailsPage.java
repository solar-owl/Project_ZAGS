package pages;

import model.AdminDetails;

public class AdminDetailsPage extends BasePage{

    public void fill(AdminDetails adminDetails) {
        type("Фамилия", adminDetails.getLastName());
        type("Имя", adminDetails.getFirstName());
        type("Отчество", adminDetails.getMiddleName());
        type("Телефон", adminDetails.getPhone());
        type("Номер паспорта", adminDetails.getPassportNumber());
        type("Дата рождения", adminDetails.getBirthDate());
    }
}
