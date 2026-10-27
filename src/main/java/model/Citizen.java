package model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Citizen {
    String lastName;
    String firstName;
    String middleName;
    String birthDate;
    String passportNumber;
    String gender;
    String registrationAddress;
}