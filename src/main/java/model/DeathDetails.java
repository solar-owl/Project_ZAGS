package model;

public final class DeathDetails {

    private final String deathDate;
    private final String deathPlace;

    private DeathDetails(Builder builder) {
        this.deathDate = builder.deathDate;
        this.deathPlace = builder.deathPlace;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getDeathDate() { return deathDate; }
    public String getDeathPlace() { return deathPlace; }

    // ---------- Builder ----------
    public static final class Builder {
        private String deathDate;
        private String deathPlace;

        private Builder() {}

        public Builder deathDate(String deathDate) {
            this.deathDate = deathDate;
            return this;
        }

        public Builder deathPlace(String deathPlace) {
            this.deathPlace = deathPlace;
            return this;
        }

        public DeathDetails build() {
            return new DeathDetails(this);
        }
    }
}