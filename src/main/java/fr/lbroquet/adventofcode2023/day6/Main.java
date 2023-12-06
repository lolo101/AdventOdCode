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
        part1();
        part2();
    }

    private static void part1() throws IOException {
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

    private static void part2() throws IOException {
        try (BufferedReader input = Input.load(Main.class)) {
            String time = SPACES.matcher(input.readLine().substring("Time:".length()).trim()).replaceAll("");
            String distance = SPACES.matcher(input.readLine().substring("Distance:".length()).trim()).replaceAll("");

            Race race = new Race(time, distance);
            long waysToBeatRace = race.waysToBeat();
            System.out.printf("Ways to beat long race: %d%n", waysToBeatRace);
        }
    }
}
