package model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class AdminDetails {
    String lastName;
    String firstName;
    String middleName;
    String phone;
    String passportNumber;
    String birthDate;
}