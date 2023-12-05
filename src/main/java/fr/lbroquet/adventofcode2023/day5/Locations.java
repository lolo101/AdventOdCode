package fr.lbroquet.adventofcode2023.day5;

import java.util.Collection;

import static java.util.Comparator.naturalOrder;

public class Locations {
    private final Collection<Long> locations;

    public Locations(Collection<Long> locations) {
        this.locations = locations;
    }

    public long lowestNumber() {
        return locations.stream().min(naturalOrder()).orElseThrow();
    }
}
