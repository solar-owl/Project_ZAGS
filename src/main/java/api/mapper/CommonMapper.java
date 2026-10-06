package api.mapper;

import api.dto.ApplicationRequestDto;
import model.Applicant;
import model.Citizen;

public final class CommonMapper {

    private CommonMapper() {}

    public static void fillCommon(ApplicationRequestDto dto,
                                  Applicant a,
                                  Citizen c) {
        // заявитель
        dto.setPersonalLastName(a.getLastName());
        dto.setPersonalFirstName(a.getFirstName());
        dto.setPersonalMiddleName(a.getMiddleName());
        dto.setPersonalPhoneNumber(a.getPhone());
        dto.setPersonalNumberOfPassport(a.getPassportNumber());
        dto.setPersonalAddress(a.getRegistrationAddress());

        // гражданин
        dto.setCitizenLastName(c.getLastName());
        dto.setCitizenFirstName(c.getFirstName());
        dto.setCitizenMiddleName(c.getMiddleName());
        dto.setCitizenBirthDate(c.getBirthDate());
        dto.setCitizenNumberOfPassport(c.getPassportNumber());
        dto.setCitizenGender(c.getGender());
        dto.setCitizenAddress(c.getRegistrationAddress());
    }
}