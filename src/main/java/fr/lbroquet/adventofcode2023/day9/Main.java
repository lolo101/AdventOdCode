package fr.lbroquet.adventofcode2023.day9;

import fr.lbroquet.Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader input = Input.load(Main.class)) {
            List<Sequence> sequences = input.lines().map(Main::toSequence).toList();
            long sumForward = sequences.stream().mapToLong(Sequence::extrapolateForward).sum();
            System.out.printf("Sum of extrapolated forward values: %d%n", sumForward);
            long sumBackward = sequences.stream().mapToLong(Sequence::extrapolateBackward).sum();
            System.out.printf("Sum of extrapolated backward values: %d%n", sumBackward);
        }
    }

    private static Sequence toSequence(String line) {
        long[] values = Stream.of(line.split(" ")).mapToLong(Long::parseLong).toArray();
        return new Sequence(values);
    }
}
