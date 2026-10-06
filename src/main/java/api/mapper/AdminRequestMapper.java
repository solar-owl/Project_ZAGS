package api.mapper;

import api.dto.AdminRequestDto;
import model.AdminDetails;

public final class AdminRequestMapper {

    private AdminRequestMapper() {}

    public static AdminRequestDto toDto(AdminDetails details) {
        AdminRequestDto dto = new AdminRequestDto();
        dto.setPersonalLastName(details.getLastName());
        dto.setPersonalFirstName(details.getFirstName());
        dto.setPersonalMiddleName(details.getMiddleName());
        dto.setPersonalPhoneNumber(details.getPhone());
        dto.setPersonalNumberOfPassport(details.getPassportNumber());
        dto.setDateOfBirth(details.getBirthDate());
        return dto;
    }
}