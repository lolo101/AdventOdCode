package fr.lbroquet.adventofcode2023.day4;

import fr.lbroquet.Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static final Pattern CARD_PATTERN = Pattern.compile("Card (?<id>\\s*\\d+):(?<winningNumbers>( {2}\\d| \\d{2})+) \\|(?<havingNumbers>( {2}\\d| \\d{2})+)");
    private static final Pattern SPACES = Pattern.compile("\\s+");

    public static void main(String[] args) throws IOException {
        try (BufferedReader input = Input.load(Main.class)) {
            long sum = input.lines().map(Main::toCard).mapToLong(Card::points).sum();
            System.out.printf("sum of points: %d%n", sum);
        }
    }

    private static Card toCard(String line) {
        Matcher matcher = CARD_PATTERN.matcher(line);
        if (matcher.matches()) {
            String winningNumbers = matcher.group("winningNumbers");
            String havingNumbers = matcher.group("havingNumbers");
            return new Card(SPACES.split(winningNumbers.trim()), SPACES.split(havingNumbers.trim()));
        }
        throw new IllegalArgumentException(line);
    }
}
