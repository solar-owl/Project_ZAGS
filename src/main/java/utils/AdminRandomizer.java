package utils;

import model.AdminDetails;

/**
 Генерация AdminDetails.
 **/
public final class AdminRandomizer {

    private AdminRandomizer() {}

    public static AdminDetails random() {
        return AdminDetails.builder()
                .lastName(RandomUtils.lastName())
                .firstName(RandomUtils.firstName())
                .middleName(RandomUtils.middleName())
                .phone(RandomUtils.phoneRu())
                .passportNumber(RandomUtils.passportRu())
                .birthDate(RandomUtils.birthDate(18, 60))
                .build();
    }
}