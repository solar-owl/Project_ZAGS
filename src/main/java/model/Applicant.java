package model;

public final class Applicant {

    private final String lastName;
    private final String firstName;
    private final String middleName;
    private final String phone;
    private final String passportNumber;
    private final String registrationAddress;

    private Applicant(Builder builder) {
        this.lastName = builder.lastName;
        this.firstName = builder.firstName;
        this.middleName = builder.middleName;
        this.phone = builder.phone;
        this.passportNumber = builder.passportNumber;
        this.registrationAddress = builder.registrationAddress;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getLastName() { return lastName; }
    public String getFirstName() { return firstName; }
    public String getMiddleName() { return middleName; }
    public String getPhone() { return phone; }
    public String getPassportNumber() { return passportNumber; }
    public String getRegistrationAddress() { return registrationAddress; }

    // ---------- Builder ----------
    public static final class Builder {
        private String lastName;
        private String firstName;
        private String middleName;
        private String phone;
        private String passportNumber;
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

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder passportNumber(String passportNumber) {
            this.passportNumber = passportNumber;
            return this;
        }

        public Builder registrationAddress(String registrationAddress) {
            this.registrationAddress = registrationAddress;
            return this;
        }

        public Applicant build() {
            return new Applicant(this);
        }
    }
}