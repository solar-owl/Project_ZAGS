package api.mapper;

import api.dto.ApplicationRequestDto;
import model.BirthApplication;

public final class BirthRequestMapper {

    private BirthRequestMapper() {}

    public static ApplicationRequestDto toDto(BirthApplication app) {
        ApplicationRequestDto dto = new ApplicationRequestDto();
        dto.setMode("birth");

        CommonMapper.fillCommon(dto, app.getApplicant(), app.getCitizen());

        dto.setBirth_place(app.getBirthDetails().getBirthPlace());
        dto.setBirth_mother(app.getBirthDetails().getMother());
        dto.setBirth_father(app.getBirthDetails().getFather());
        dto.setBirthGrandpa(app.getBirthDetails().getGrandMother());
        dto.setBirthGrandma(app.getBirthDetails().getGrandFather());

        return dto;
    }
}