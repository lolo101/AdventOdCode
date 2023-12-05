package fr.lbroquet.adventofcode2023.day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Collection;

public class Lights extends Step {
    private final Collection<Long> lights;

    public Lights(Collection<Long> lights) {
        this.lights = lights;
    }

    public Temperatures toTemperatures(BufferedReader input) throws IOException {
        return new Temperatures(step(input, lights));
    }
}
