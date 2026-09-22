package model;

import java.util.Objects;

public final class Applicant {

    private final String lastName;
    private final String firstName;
    private final String middleName;
    private final String phone;
    private final String passportNumber;
    private final String registrationAddress;

    public Applicant(String lastName, String firstName, String middleName,
                     String phone, String passportNumber, String registrationAddress) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.phone = phone;
        this.passportNumber = passportNumber;
        this.registrationAddress = registrationAddress;
    }

    public String getLastName() { return lastName; }
    public String getFirstName() { return firstName; }
    public String getMiddleName() { return middleName; }
    public String getPhone() { return phone; }
    public String getPassportNumber() { return passportNumber; }
    public String getRegistrationAddress() { return registrationAddress; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Applicant that)) return false;
        return Objects.equals(lastName, that.lastName)
                && Objects.equals(firstName, that.firstName)
                && Objects.equals(middleName, that.middleName)
                && Objects.equals(phone, that.phone)
                && Objects.equals(passportNumber, that.passportNumber)
                && Objects.equals(registrationAddress, that.registrationAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName, middleName, phone, passportNumber, registrationAddress);
    }
}