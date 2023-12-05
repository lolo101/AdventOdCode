package fr.lbroquet.adventofcode2023.day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Collection;

public class Temperatures extends Step {
    private final Collection<Long> temperatures;

    public Temperatures(Collection<Long> temperatures) {
        this.temperatures = temperatures;
    }

    public Humidities toHumidities(BufferedReader input) throws IOException {
        return new Humidities(step(input, temperatures));
    }
}
