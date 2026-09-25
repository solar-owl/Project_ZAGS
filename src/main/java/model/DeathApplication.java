package model;

public final class DeathApplication {

    private final Applicant applicant;
    private final Citizen citizen;
    private final DeathDetails deathDetails;

    private DeathApplication(Builder builder) {
        this.applicant = builder.applicant;
        this.citizen = builder.citizen;
        this.deathDetails = builder.deathDetails;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Applicant getApplicant() { return applicant; }
    public Citizen getCitizen() { return citizen; }
    public DeathDetails getDeathDetails() { return deathDetails; }

    // ---------- Builder ----------
    public static final class Builder {
        private Applicant applicant;
        private Citizen citizen;
        private DeathDetails deathDetails;

        private Builder() {}

        public Builder applicant(Applicant applicant) {
            this.applicant = applicant;
            return this;
        }

        public Builder citizen(Citizen citizen) {
            this.citizen = citizen;
            return this;
        }

        public Builder deathDetails(DeathDetails deathDetails) {
            this.deathDetails = deathDetails;
            return this;
        }

        public DeathApplication build() {
            return new DeathApplication(this);
        }
    }
}