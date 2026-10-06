package api.mapper;

import api.dto.ApplicationRequestDto;
import model.MarriageApplication;

public final class MarriageRequestMapper {

    private MarriageRequestMapper() {}

    public static ApplicationRequestDto toDto(MarriageApplication app) {
        ApplicationRequestDto dto = new ApplicationRequestDto();
        dto.setMode("wedding");

        CommonMapper.fillCommon(dto, app.getApplicant(), app.getCitizen());

        dto.setDateOfMarriage(app.getMarriageDetails().getRegistrationDate());
        dto.setNewLastName(app.getMarriageDetails().getNewLastName());

        dto.setAnotherPersonLastName(app.getMarriageDetails().getSpouseLastName());
        dto.setAnotherPersonFirstName(app.getMarriageDetails().getSpouseFirstName());
        dto.setAnotherPersonMiddleName(app.getMarriageDetails().getSpouseMiddleName());
        dto.setAnotherPersonPassport(app.getMarriageDetails().getSpousePassportNumber());
        dto.setBirthOfAnotherPerson(app.getMarriageDetails().getSpouseBirthDate());

        return dto;
    }
}