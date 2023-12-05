package fr.lbroquet.adventofcode2023.day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Collection;

import static fr.lbroquet.adventofcode2023.day5.Step.step;

public class Humidities {
    private final Collection<Long> humidities;

    public Humidities(Collection<Long> humidities) {
        this.humidities = humidities;
    }

    public Locations toLocations(BufferedReader input) throws IOException {
        return new Locations(step(input, humidities));
    }
}
