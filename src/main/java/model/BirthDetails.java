package model;

public final class BirthDetails {

    private final String birthPlace;
    private final String mother;
    private final String father;
    private final String grandMother;
    private final String grandFather;

    private BirthDetails(Builder builder) {
        this.birthPlace = builder.birthPlace;
        this.mother = builder.mother;
        this.father = builder.father;
        this.grandMother = builder.grandMother;
        this.grandFather = builder.grandFather;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getBirthPlace() { return birthPlace; }
    public String getMother() { return mother; }
    public String getFather() { return father; }
    public String getGrandMother() { return grandMother; }
    public String getGrandFather() { return grandFather; }

    // ---------- Builder ----------
    public static final class Builder {
        private String birthPlace;
        private String mother;
        private String father;
        private String grandMother;
        private String grandFather;

        private Builder() {}

        public Builder birthPlace(String birthPlace) {
            this.birthPlace = birthPlace;
            return this;
        }

        public Builder mother(String mother) {
            this.mother = mother;
            return this;
        }

        public Builder father(String father) {
            this.father = father;
            return this;
        }

        public Builder grandMother(String grandMother) {
            this.grandMother = grandMother;
            return this;
        }

        public Builder grandFather(String grandFather) {
            this.grandFather = grandFather;
            return this;
        }

        public BirthDetails build() {
            return new BirthDetails(this);
        }
    }
}