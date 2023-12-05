package fr.lbroquet.adventofcode2023.day5;

import java.io.BufferedReader;
import java.io.IOException;

import static fr.lbroquet.adventofcode2023.day5.Step.step;

public class Waters {
    private final Ranges waters;

    public Waters(Ranges waters) {
        this.waters = waters;
    }

    public Lights toLights(BufferedReader input) throws IOException {
        return new Lights(step(input, waters));
    }
}
