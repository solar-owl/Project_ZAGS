package model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class DeathDetails {
    String deathDate;
    String deathPlace;
}