package model;

public final class MarriageDetails {

    private final String registrationDate;
    private final String newLastName;
    private final String spouseLastName;
    private final String spouseFirstName;
    private final String spouseMiddleName;
    private final String spouseBirthDate;
    private final String spousePassportNumber;

    private MarriageDetails(Builder builder) {
        this.registrationDate = builder.registrationDate;
        this.newLastName = builder.newLastName;
        this.spouseLastName = builder.spouseLastName;
        this.spouseFirstName = builder.spouseFirstName;
        this.spouseMiddleName = builder.spouseMiddleName;
        this.spouseBirthDate = builder.spouseBirthDate;
        this.spousePassportNumber = builder.spousePassportNumber;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getRegistrationDate() { return registrationDate; }
    public String getNewLastName() { return newLastName; }
    public String getSpouseLastName() { return spouseLastName; }
    public String getSpouseFirstName() { return spouseFirstName; }
    public String getSpouseMiddleName() { return spouseMiddleName; }
    public String getSpouseBirthDate() { return spouseBirthDate; }
    public String getSpousePassportNumber() { return spousePassportNumber; }


    // ---------- Builder ----------
    public static final class Builder {
        private String registrationDate;
        private String newLastName;
        private String spouseLastName;
        private String spouseFirstName;
        private String spouseMiddleName;
        private String spouseBirthDate;
        private String spousePassportNumber;

        private Builder() {}

        public Builder registrationDate(String registrationDate) {
            this.registrationDate = registrationDate;
            return this;
        }

        public Builder newLastName(String newLastName) {
            this.newLastName = newLastName;
            return this;
        }

        public Builder spouseLastName(String spouseLastName) {
            this.spouseLastName = spouseLastName;
            return this;
        }

        public Builder spouseFirstName(String spouseFirstName) {
            this.spouseFirstName = spouseFirstName;
            return this;
        }

        public Builder spouseMiddleName(String spouseMiddleName) {
            this.spouseMiddleName = spouseMiddleName;
            return this;
        }

        public Builder spouseBirthDate(String spouseBirthDate) {
            this.spouseBirthDate = spouseBirthDate;
            return this;
        }

        public Builder spousePassportNumber(String spousePassportNumber) {
            this.spousePassportNumber = spousePassportNumber;
            return this;
        }

        public MarriageDetails build() {
            return new MarriageDetails(this);
        }
    }
}