package fr.lbroquet.adventofcode2023.day5;

import java.io.BufferedReader;
import java.io.IOException;

public abstract class Step {
    protected static Ranges step(BufferedReader input, Ranges ranges) throws IOException {
        input.readLine();
        Mappings mappings = new Mappings();
        for (String line; (line = input.readLine()) != null && !line.isEmpty(); ) {
            String[] mapping = line.split(" ");
            mappings.add(mapping);
        }
        return mappings.map(ranges);
    }
}
