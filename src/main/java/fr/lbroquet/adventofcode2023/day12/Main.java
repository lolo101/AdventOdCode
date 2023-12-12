package fr.lbroquet.adventofcode2023.day12;

import fr.lbroquet.Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static final Pattern RECORD_ROW = Pattern.compile("(?<conditions>[.#?]+) (?<contiguousGroups>\\d+(?:,\\d+)*)");

    public static void main(String[] args) throws IOException {
        try (BufferedReader input = Input.load(Main.class)) {
            long sum = input.lines().map(Main::toRecordRow).mapToLong(RecordRow::arrangements).sum();
            System.out.printf("Sum of arrangements in the records: %d%n", sum);
        }
    }

    private static RecordRow toRecordRow(String line) {
        Matcher matcher = RECORD_ROW.matcher(line);
        if (matcher.matches()) {
            String conditions = matcher.group("conditions");
            String[] contiguousGroups = matcher.group("contiguousGroups").split(",");
            return new RecordRow(conditions, contiguousGroups);
        }
        throw new IllegalArgumentException(line);
    }
}
