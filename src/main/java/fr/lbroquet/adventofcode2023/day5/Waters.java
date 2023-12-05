package fr.lbroquet.adventofcode2023.day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Collection;

import static fr.lbroquet.adventofcode2023.day5.Step.step;

public class Waters {
    private final Collection<Long> waters;

    public Waters(Collection<Long> waters) {
        this.waters = waters;
    }

    public Lights toLights(BufferedReader input) throws IOException {
        return new Lights(step(input, waters));
    }
}
