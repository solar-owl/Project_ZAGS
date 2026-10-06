package utils;

import model.Applicant;
import model.DeathApplication;
import model.DeathDetails;

/**
  Сборка DeathApplication.
 **/
public final class DeathRandomizer {

    private DeathRandomizer() {}

    public static DeathApplication random() {
        Applicant applicant = ApplicantRandomizer.random();
        return DeathApplication.builder()
                .applicant(applicant)
                .citizen(CitizenRandomizer.fromApplicant(applicant))
                .deathDetails(randomDetails())
                .build();
    }

    private static DeathDetails randomDetails() {
        return DeathDetails.builder()
                .deathDate(RandomUtils.pastDate(1, 30))
                .deathPlace(RandomUtils.city())
                .build();
    }
}