package fr.lbroquet.adventofcode2023.day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Collection;

public class Fertilizers extends Step {
    private final Collection<Long> fertilizers;

    public Fertilizers(Collection<Long> fertilizers) {
        this.fertilizers = fertilizers;
    }

    public Waters toWaters(BufferedReader input) throws IOException {
        return new Waters(step(input, fertilizers));
    }
}
