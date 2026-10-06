package utils;

import model.Applicant;
import model.Citizen;

/**
 Генерация Citizen. Умеет строить Citizen на основе Applicant.
 **/
public final class CitizenRandomizer {

    private CitizenRandomizer() {}

    public static Citizen random() {
        return Citizen.builder()
                .lastName(RandomUtils.lastName())
                .firstName(RandomUtils.firstName())
                .middleName(RandomUtils.middleName())
                .birthDate(RandomUtils.birthDate(18, 60))
                .passportNumber(RandomUtils.passportRu())
                .gender("Муж")
                .registrationAddress(RandomUtils.city())
                .build();
    }

    public static Citizen fromApplicant(Applicant applicant) {
        return Citizen.builder()
                .lastName(applicant.getLastName())
                .firstName(applicant.getFirstName())
                .middleName(applicant.getMiddleName())
                .passportNumber(applicant.getPassportNumber())
                .registrationAddress(applicant.getRegistrationAddress())
                .birthDate(RandomUtils.birthDate(18, 60))
                .gender("Муж")
                .build();
    }
}