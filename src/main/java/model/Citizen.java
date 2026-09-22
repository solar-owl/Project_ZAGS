package model;

import java.util.Objects;

public final class Citizen {

    private final String lastName;
    private final String firstName;
    private final String middleName;
    private final String birthDate;
    private final String passportNumber;
    private final String gender;
    private final String registrationAddress;

    public Citizen(String lastName, String firstName, String middleName, String birthDate,
                   String passportNumber, String gender, String registrationAddress) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.birthDate = birthDate;
        this.passportNumber = passportNumber;
        this.gender = gender;
        this.registrationAddress = registrationAddress;
    }

    public String getLastName() { return lastName; }
    public String getFirstName() { return firstName; }
    public String getMiddleName() { return middleName; }
    public String getBirthDate() { return birthDate; }
    public String getPassportNumber() { return passportNumber; }
    public String getGender() { return gender; }
    public String getRegistrationAddress() { return registrationAddress; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Citizen that)) return false;
        return Objects.equals(lastName, that.lastName)
                && Objects.equals(firstName, that.firstName)
                && Objects.equals(middleName, that.middleName)
                && Objects.equals(birthDate, that.birthDate)
                && Objects.equals(passportNumber, that.passportNumber)
                && Objects.equals(gender, that.gender)
                && Objects.equals(registrationAddress, that.registrationAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName, middleName, birthDate, passportNumber, gender, registrationAddress);
    }
}