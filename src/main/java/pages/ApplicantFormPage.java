package pages;

import model.Applicant;

public class ApplicantFormPage extends BasePage{

        public void fill(Applicant applicant) {
            type("Фамилия", applicant.getLastName());
            type("Имя", applicant.getFirstName());
            type("Отчество", applicant.getMiddleName());
            type("Телефон", applicant.getPhone());
            type("Номер паспорта", applicant.getPassportNumber());
            type("Адрес прописки", applicant.getRegistrationAddress());
        }

}
