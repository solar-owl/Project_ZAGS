package model;

import java.util.Objects;

public final class BirthDetails {

    private final String birthPlace;
    private final String mother;
    private final String father;
    private final String grandMother;
    private final String grandFather;

    public BirthDetails(String birthPlace, String mother, String father,
                        String grandMother, String grandFather) {
        this.birthPlace = birthPlace;
        this.mother = mother;
        this.father = father;
        this.grandMother = grandMother;
        this.grandFather = grandFather;
    }

    public String getBirthPlace() { return birthPlace; }
    public String getMother() { return mother; }
    public String getFather() { return father; }
    public String getGrandMother() { return grandMother; }
    public String getGrandFather() { return grandFather; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BirthDetails that)) return false;
        return Objects.equals(birthPlace, that.birthPlace)
                && Objects.equals(mother, that.mother)
                && Objects.equals(father, that.father)
                && Objects.equals(grandMother, that.grandMother)
                && Objects.equals(grandFather, that.grandFather);
    }

    @Override
    public int hashCode() {
        return Objects.hash(birthPlace, mother, father, grandMother, grandFather);
    }
}
