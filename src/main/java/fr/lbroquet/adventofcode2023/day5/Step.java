package fr.lbroquet.adventofcode2023.day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Collection;

public abstract class Step {
    protected static Collection<Long> step(BufferedReader input, Collection<Long> from) throws IOException {
        input.readLine();
        Mappings mappings = new Mappings();
        for (String line; (line = input.readLine()) != null && !line.isEmpty(); ) {
            String[] mapping = line.split(" ");
            mappings.add(mapping);
        }
        return mappings.map(from);
    }
}
