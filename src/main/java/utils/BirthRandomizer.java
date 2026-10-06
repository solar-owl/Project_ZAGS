package utils;

import model.Applicant;
import model.BirthApplication;
import model.BirthDetails;

/**
 Сборка BirthApplication.
 **/
public final class BirthRandomizer {

    private BirthRandomizer() {}

    public static BirthApplication random() {
        Applicant applicant = ApplicantRandomizer.random();
        return BirthApplication.builder()
                .applicant(applicant)
                .citizen(CitizenRandomizer.fromApplicant(applicant))
                .birthDetails(randomDetails())
                .build();
    }

    private static BirthDetails randomDetails() {
        return BirthDetails.builder()
                .birthPlace(RandomUtils.city())
                .mother(RandomUtils.firstName())
                .father(RandomUtils.firstName())
                .grandMother(RandomUtils.firstName())
                .grandFather(RandomUtils.firstName())
                .build();
    }
}