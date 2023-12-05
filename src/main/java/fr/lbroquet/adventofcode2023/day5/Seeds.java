package fr.lbroquet.adventofcode2023.day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Collection;

import static fr.lbroquet.adventofcode2023.day5.Step.step;

public class Seeds {
    private final Collection<Long> seeds;

    public Seeds(Collection<Long> seeds) {
        this.seeds = seeds;
    }

    public Soils toSoils(BufferedReader input) throws IOException {
        return new Soils(step(input, seeds));
    }
}
