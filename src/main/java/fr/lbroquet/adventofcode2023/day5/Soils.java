package fr.lbroquet.adventofcode2023.day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Collection;

public class Soils extends Step {
    private final Collection<Long> soils;

    public Soils(Collection<Long> soils) {
        this.soils = soils;
    }

    public Fertilizers toFertilizers(BufferedReader input) throws IOException {
        return new Fertilizers(step(input, soils));
    }
}
