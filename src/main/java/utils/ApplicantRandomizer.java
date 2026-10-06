package utils;

import model.Applicant;

/**
  Генерация Applicant со случайными данными.
 **/
public final class ApplicantRandomizer {

    private ApplicantRandomizer() {}

    public static Applicant random() {
        return Applicant.builder()
                .lastName(RandomUtils.lastName())
                .firstName(RandomUtils.firstName())
                .middleName(RandomUtils.middleName())
                .phone(RandomUtils.phoneRu())
                .passportNumber(RandomUtils.passportRu())
                .registrationAddress(RandomUtils.city())
                .build();
    }

    public static Applicant withLastName(String lastName) {
        Applicant base = random();
        return Applicant.builder()
                .lastName(lastName)
                .firstName(base.getFirstName())
                .middleName(base.getMiddleName())
                .phone(base.getPhone())
                .passportNumber(base.getPassportNumber())
                .registrationAddress(base.getRegistrationAddress())
                .build();
    }
}