package fr.lbroquet.adventofcode2018.day2;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

public class Main {

    private static BufferedReader loadInput() {
        InputStream inputStream = Main.class.getResourceAsStream("input");
        return new BufferedReader(new InputStreamReader(inputStream));
    }

    public static void main(String[] args) throws IOException {
        long twoRepeatedLetters, threeRepeatedLetters;

        try (BufferedReader reader = loadInput()) {
            twoRepeatedLetters = reader.lines()
                    .filter(line -> hasRepeatedLetters(line, 2))
                    .count();
        }
        try (BufferedReader reader = loadInput()) {
            threeRepeatedLetters = reader.lines()
                    .filter(line -> hasRepeatedLetters(line, 3))
                    .count();
        }
        System.out.println("Checksum: " + Math.multiplyExact(twoRepeatedLetters, threeRepeatedLetters));
    }

    private static boolean hasRepeatedLetters(String line, long repetition) {
        Map<Integer, Long> frequencies = line.chars().boxed().collect(groupingBy(identity(), counting()));
        return frequencies.values().stream().anyMatch(f -> f == repetition);
    }
}
