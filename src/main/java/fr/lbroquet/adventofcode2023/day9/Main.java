package fr.lbroquet.adventofcode2023.day9;

import fr.lbroquet.Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader input = Input.load(Main.class)) {
            long sum = input.lines().map(Main::toSequence).mapToLong(Sequence::extrapolate).sum();
            System.out.printf("Sum of extrapolated values: %d%n", sum);
        }
    }

    private static Sequence toSequence(String line) {
        long[] values = Stream.of(line.split(" ")).mapToLong(Long::parseLong).toArray();
        return new Sequence(values);
    }
}
