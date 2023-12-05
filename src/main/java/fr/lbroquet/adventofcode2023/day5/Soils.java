package fr.lbroquet.adventofcode2023.day5;

import java.io.BufferedReader;
import java.io.IOException;

import static fr.lbroquet.adventofcode2023.day5.Step.step;

public class Soils {
    private final Ranges soils;

    public Soils(Ranges soils) {
        this.soils = soils;
    }

    public Fertilizers toFertilizers(BufferedReader input) throws IOException {
        return new Fertilizers(step(input, soils));
    }
}
