package model;

public final class Citizen {

    private final String lastName;
    private final String firstName;
    private final String middleName;
    private final String birthDate;
    private final String passportNumber;
    private final String gender;
    private final String registrationAddress;

    private Citizen(Builder builder) {
        this.lastName = builder.lastName;
        this.firstName = builder.firstName;
        this.middleName = builder.middleName;
        this.birthDate = builder.birthDate;
        this.passportNumber = builder.passportNumber;
        this.gender = builder.gender;
        this.registrationAddress = builder.registrationAddress;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getLastName() { return lastName; }
    public String getFirstName() { return firstName; }
    public String getMiddleName() { return middleName; }
    public String getBirthDate() { return birthDate; }
    public String getPassportNumber() { return passportNumber; }
    public String getGender() { return gender; }
    public String getRegistrationAddress() { return registrationAddress; }

    // ---------- Builder ----------
    public static final class Builder {
        private String lastName;
        private String firstName;
        private String middleName;
        private String birthDate;
        private String passportNumber;
        private String gender;
        private String registrationAddress;

        private Builder() {}

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder middleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public Builder birthDate(String birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public Builder passportNumber(String passportNumber) {
            this.passportNumber = passportNumber;
            return this;
        }

        public Builder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public Builder registrationAddress(String registrationAddress) {
            this.registrationAddress = registrationAddress;
            return this;
        }

        public Citizen build() {
            return new Citizen(this);
        }
    }
}