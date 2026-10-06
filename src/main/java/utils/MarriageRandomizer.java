package utils;

import model.Applicant;
import model.MarriageApplication;
import model.MarriageDetails;

/**
 Сборка MarriageApplication из случайных.
 **/
public final class MarriageRandomizer {

    private MarriageRandomizer() {}

    public static MarriageApplication random() {
        Applicant applicant = ApplicantRandomizer.random();
        return MarriageApplication.builder()
                .applicant(applicant)
                .citizen(CitizenRandomizer.fromApplicant(applicant))
                .marriageDetails(randomDetails())
                .build();
    }

    private static MarriageDetails randomDetails() {
        return MarriageDetails.builder()
                .registrationDate(RandomUtils.futureDate(30, 180))
                .newLastName(RandomUtils.lastName())
                .spouseLastName(RandomUtils.lastName())
                .spouseFirstName(RandomUtils.firstName())
                .spouseMiddleName(RandomUtils.middleName())
                .spouseBirthDate(RandomUtils.birthDate(18, 60))
                .spousePassportNumber(RandomUtils.passportRu())
                .build();
    }
}