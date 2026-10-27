package model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class MarriageApplication {
    Applicant applicant;
    Citizen citizen;
    MarriageDetails marriageDetails;
}