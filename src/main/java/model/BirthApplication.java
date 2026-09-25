package model;

public final class BirthApplication {

    private final Applicant applicant;
    private final Citizen citizen;
    private final BirthDetails birthDetails;

    private BirthApplication(Builder builder) {
        this.applicant = builder.applicant;
        this.citizen = builder.citizen;
        this.birthDetails = builder.birthDetails;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Applicant getApplicant() { return applicant; }
    public Citizen getCitizen() { return citizen; }
    public BirthDetails getBirthDetails() { return birthDetails; }

    // ---------- Builder ----------
    public static final class Builder {
        private Applicant applicant;
        private Citizen citizen;
        private BirthDetails birthDetails;

        private Builder() {}

        public Builder applicant(Applicant applicant) {
            this.applicant = applicant;
            return this;
        }

        public Builder citizen(Citizen citizen) {
            this.citizen = citizen;
            return this;
        }

        public Builder birthDetails(BirthDetails birthDetails) {
            this.birthDetails = birthDetails;
            return this;
        }

        public BirthApplication build() {
            return new BirthApplication(this);
        }
    }
}