package model;

import java.util.Objects;

public final class BirthApplication {

    private final Applicant applicant;
    private final Citizen citizen;
    private final BirthDetails birthDetails;

    public BirthApplication(Applicant applicant, Citizen citizen, BirthDetails birthDetails) {
        this.applicant = applicant;
        this.citizen = citizen;
        this.birthDetails = birthDetails;
    }

    public Applicant getApplicant() { return applicant; }
    public Citizen getCitizen() { return citizen; }
    public BirthDetails getBirthDetails() { return birthDetails; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BirthApplication that)) return false;
        return Objects.equals(applicant, that.applicant)
                && Objects.equals(citizen, that.citizen)
                && Objects.equals(birthDetails, that.birthDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(applicant, citizen, birthDetails);
    }
}