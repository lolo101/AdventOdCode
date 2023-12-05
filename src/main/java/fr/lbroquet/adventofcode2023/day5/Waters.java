package fr.lbroquet.adventofcode2023.day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Collection;

public class Waters extends Step {
    private final Collection<Long> waters;

    public Waters(Collection<Long> waters) {
        this.waters = waters;
    }

    public Lights toLights(BufferedReader input) throws IOException {
        return new Lights(step(input, waters));
    }
}
