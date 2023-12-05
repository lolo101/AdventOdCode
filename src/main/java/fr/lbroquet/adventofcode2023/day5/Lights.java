package fr.lbroquet.adventofcode2023.day5;

import java.io.BufferedReader;
import java.io.IOException;

import static fr.lbroquet.adventofcode2023.day5.Step.step;

public class Lights {
    private final Ranges lights;

    public Lights(Ranges lights) {
        this.lights = lights;
    }

    public Temperatures toTemperatures(BufferedReader input) throws IOException {
        return new Temperatures(step(input, lights));
    }
}
