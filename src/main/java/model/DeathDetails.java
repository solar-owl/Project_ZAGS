package model;

import java.util.Objects;

public final class DeathDetails {

    private final String deathDate;
    private final String deathPlace;

    public DeathDetails(String deathDate, String deathPlace) {
        this.deathDate = deathDate;
        this.deathPlace = deathPlace;
    }

    public String getDeathDate() { return deathDate; }
    public String getDeathPlace() { return deathPlace; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DeathDetails that)) return false;
        return Objects.equals(deathDate, that.deathDate)
                && Objects.equals(deathPlace, that.deathPlace);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deathDate, deathPlace);
    }
}
