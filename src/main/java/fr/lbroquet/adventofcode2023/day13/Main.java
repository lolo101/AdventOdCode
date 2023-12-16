package fr.lbroquet.adventofcode2023.day13;

import fr.lbroquet.Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> patterns = readPatterns();
        long sum = patterns.stream().map(Main::toPattern).mapToLong(Pattern::summarize).sum();
        System.out.printf("Sum of summaries: %d%n", sum);
    }

    private static List<String> readPatterns() throws IOException {
        List<String> patterns = new ArrayList<>();
        try (BufferedReader input = Input.load(Main.class)) {
            StringBuilder pattern = new StringBuilder();
            for (String line; (line = input.readLine()) != null; ) {
                if (line.isEmpty()) {
                    patterns.add(pattern.toString());
                    pattern.setLength(0);
                } else {
                    pattern.append(line).append('\n');
                }
            }
            patterns.add(pattern.toString());
        }
        return patterns;
    }

    private static Pattern toPattern(String block) {
        List<String> blockLines = Arrays.asList(block.split("\n"));
        return new Pattern(blockLines);
    }
}
