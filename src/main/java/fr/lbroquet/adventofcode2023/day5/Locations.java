package fr.lbroquet.adventofcode2023.day5;

public class Locations {
    private final Ranges locations;

    public Locations(Ranges locations) {
        this.locations = locations;
    }

    public long lowestNumber() {
        return locations.lowestBoundary();
    }
}
