package fr.lbroquet.adventofcode2023.day5;

import java.io.BufferedReader;
import java.io.IOException;

import static fr.lbroquet.adventofcode2023.day5.Step.step;

public class Humidities {
    private final Ranges humidities;

    public Humidities(Ranges humidities) {
        this.humidities = humidities;
    }

    public Locations toLocations(BufferedReader input) throws IOException {
        return new Locations(step(input, humidities));
    }
}
