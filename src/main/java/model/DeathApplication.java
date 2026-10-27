package model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class DeathApplication {
    Applicant applicant;
    Citizen citizen;
    DeathDetails deathDetails;
}