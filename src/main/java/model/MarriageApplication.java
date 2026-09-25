package model;

public final class MarriageApplication {

    private final Applicant applicant;
    private final Citizen citizen;
    private final MarriageDetails marriageDetails;

    private MarriageApplication(Builder builder) {
        this.applicant = builder.applicant;
        this.citizen = builder.citizen;
        this.marriageDetails = builder.marriageDetails;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Applicant getApplicant() { return applicant; }
    public Citizen getCitizen() { return citizen; }
    public MarriageDetails getMarriageDetails() { return marriageDetails; }

    // ---------- Builder ----------
    public static final class Builder {
        private Applicant applicant;
        private Citizen citizen;
        private MarriageDetails marriageDetails;

        private Builder() {}

        public Builder applicant(Applicant applicant) {
            this.applicant = applicant;
            return this;
        }

        public Builder citizen(Citizen citizen) {
            this.citizen = citizen;
            return this;
        }

        public Builder marriageDetails(MarriageDetails marriageDetails) {
            this.marriageDetails = marriageDetails;
            return this;
        }

        public MarriageApplication build() {
            return new MarriageApplication(this);
        }
    }
}