package fr.lbroquet.adventofcode2023.day5;

import fr.lbroquet.Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader input = Input.load(Main.class)) {
            Seeds seeds = seeds(input);
            Soils soils = seeds.toSoils(input);
            Fertilizers fertilizers = soils.toFertilizers(input);
            Waters waters = fertilizers.toWaters(input);
            Lights lights = waters.toLights(input);
            Temperatures temperatures = lights.toTemperatures(input);
            Humidities humidities = temperatures.toHumidities(input);
            Locations locations = humidities.toLocations(input);
            System.out.printf("Lowest location number: %d%n", locations.lowestNumber());
        }
    }

    private static Seeds seeds(BufferedReader input) throws IOException {
        String line = input.readLine();
        String[] seeds = line.substring("seeds: ".length()).split(" ");
        input.readLine();

        List<Long> pairs = Arrays.stream(seeds).map(Long::parseLong).toList();
        Collection<Range> ranges = new ArrayList<>();
        for (int pair = 0; pair < pairs.size(); pair += 2) {
            ranges.add(new Range(pairs.get(pair), pairs.get(pair + 1)));
        }
        return new Seeds(new Ranges(ranges));
    }

}
