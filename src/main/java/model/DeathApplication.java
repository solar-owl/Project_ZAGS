package model;

import java.util.Objects;

public final class DeathApplication {

    private final Applicant applicant;
    private final Citizen citizen;
    private final DeathDetails deathDetails;

    public DeathApplication(Applicant applicant, Citizen citizen, DeathDetails deathDetails) {
        this.applicant = applicant;
        this.citizen = citizen;
        this.deathDetails = deathDetails;
    }

    public Applicant getApplicant() { return applicant; }
    public Citizen getCitizen() { return citizen; }
    public DeathDetails getDeathDetails() { return deathDetails; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DeathApplication that)) return false;
        return Objects.equals(applicant, that.applicant)
                && Objects.equals(citizen, that.citizen)
                && Objects.equals(deathDetails, that.deathDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(applicant, citizen, deathDetails);
    }
}
