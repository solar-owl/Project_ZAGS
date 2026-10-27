package model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class BirthDetails {
    String birthPlace;
    String mother;
    String father;
    String grandMother;
    String grandFather;
}