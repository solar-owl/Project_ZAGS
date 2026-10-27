package api.mapper;

import api.dto.ApplicationRequestDto;
import model.BirthApplication;

public final class BirthRequestMapper {

    private BirthRequestMapper() {}

    public static ApplicationRequestDto toDto(BirthApplication app) {
        ApplicationRequestDto dto = new ApplicationRequestDto();
        dto.setMode("birth");

        CommonMapper.fillCommon(dto, app.getApplicant(), app.getCitizen());

        dto.setBirthPlace(app.getBirthDetails().getBirthPlace());
        dto.setBirthMother(app.getBirthDetails().getMother());
        dto.setBirthFather(app.getBirthDetails().getFather());
        dto.setBirthGrandpa(app.getBirthDetails().getGrandMother());
        dto.setBirthGrandma(app.getBirthDetails().getGrandFather());

        return dto;
    }
}