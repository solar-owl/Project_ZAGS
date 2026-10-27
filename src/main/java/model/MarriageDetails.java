package model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class MarriageDetails {
    String registrationDate;
    String newLastName;
    String spouseLastName;
    String spouseFirstName;
    String spouseMiddleName;
    String spouseBirthDate;
    String spousePassportNumber;
}