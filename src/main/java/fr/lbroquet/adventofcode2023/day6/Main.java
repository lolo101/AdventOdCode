package fr.lbroquet.adventofcode2023.day6;

import fr.lbroquet.Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.regex.Pattern;

public class Main {
    private static final Pattern SPACES = Pattern.compile("\\s+");

    public static void main(String[] args) throws IOException {
        try (BufferedReader input = Input.load(Main.class)) {
            String[] times = SPACES.split(input.readLine().substring("Time:".length()).trim());
            String[] distances = SPACES.split(input.readLine().substring("Distance:".length()).trim());

            Collection<Race> races = new ArrayList<>();
            for (int race = 0; race < times.length; ++race) {
                races.add(new Race(times[race], distances[race]));
            }
            long waysToBeatAllRaces = races.stream().mapToLong(Race::waysToBeat).reduce(1, Math::multiplyExact);
            System.out.printf("Ways to beat all races: %d%n", waysToBeatAllRaces);
        }
    }
}
