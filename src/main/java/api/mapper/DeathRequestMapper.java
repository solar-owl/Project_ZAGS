package api.mapper;

import api.dto.ApplicationRequestDto;
import model.DeathApplication;

public final class DeathRequestMapper {

    private DeathRequestMapper() {}

    public static ApplicationRequestDto toDto(DeathApplication app) {
        ApplicationRequestDto dto = new ApplicationRequestDto();
        dto.setMode("death");

        CommonMapper.fillCommon(dto, app.getApplicant(), app.getCitizen());

        dto.setBirthGrandpa(app.getDeathDetails().getDeathDate());
        dto.setBirthGrandma(app.getDeathDetails().getDeathDate());
        dto.setDeathDateOfDeath(app.getDeathDetails().getDeathDate());
        dto.setDeathPlaceOfDeath(app.getDeathDetails().getDeathPlace());

        return dto;
    }
}