package fr.lbroquet.adventofcode2023.day15;

import fr.lbroquet.Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader input = Input.load(Main.class)) {
            String[] instructions = input.readLine().split(",");
            long sum = Stream.of(instructions).mapToLong(Main::hash).sum();
            System.out.printf("Sum of HASH: %d%n", sum);
        }
    }

    private static int hash(String instruction) {
        int currentValue = 0;
        for (char c : instruction.toCharArray()) {
            currentValue += c;
            currentValue *= 17;
            currentValue %= 256;
        }
        return currentValue;
    }
}
