package model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class BirthApplication {
    Applicant applicant;
    Citizen citizen;
    BirthDetails birthDetails;
}