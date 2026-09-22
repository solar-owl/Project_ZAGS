package model;

import java.util.Objects;

public final class MarriageApplication {

    private final Applicant applicant;
    private final Citizen citizen;
    private final MarriageDetails marriageDetails;

    public MarriageApplication(Applicant applicant, Citizen citizen, MarriageDetails marriageDetails) {
        this.applicant = applicant;
        this.citizen = citizen;
        this.marriageDetails = marriageDetails;
    }

    public Applicant getApplicant() { return applicant; }
    public Citizen getCitizen() { return citizen; }
    public MarriageDetails getMarriageDetails() { return marriageDetails; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MarriageApplication that)) return false;
        return Objects.equals(applicant, that.applicant)
                && Objects.equals(citizen, that.citizen)
                && Objects.equals(marriageDetails, that.marriageDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(applicant, citizen, marriageDetails);
    }
}