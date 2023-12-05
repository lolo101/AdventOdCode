package fr.lbroquet.adventofcode2023.day5;

import java.io.BufferedReader;
import java.io.IOException;

import static fr.lbroquet.adventofcode2023.day5.Step.step;

public class Temperatures {
    private final Ranges temperatures;

    public Temperatures(Ranges temperatures) {
        this.temperatures = temperatures;
    }

    public Humidities toHumidities(BufferedReader input) throws IOException {
        return new Humidities(step(input, temperatures));
    }
}
