package fr.lbroquet.adventofcode2023.day1;

import fr.lbroquet.Input;

import java.io.BufferedReader;
import java.util.Comparator;
import java.util.List;
import java.util.SequencedCollection;
import java.util.TreeSet;

public class Main {
    private static final List<String> SPELLED_DIGITS = List.of(
            "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
    );

    public static void main(String[] args) {
        BufferedReader input = Input.load(Main.class);
        long sum = input.lines().mapToLong(Main::toCalibrationValue).sum();
        System.out.printf("Sum: %d%n", sum);
    }

    private static long toCalibrationValue(String line) {
        SequencedCollection<PositionedDigit> digits = new TreeSet<>(Comparator.comparing(PositionedDigit::position));
        for (int spelledDigitValue = 1; spelledDigitValue <= 9; ++spelledDigitValue) {
            String spelledDigit = SPELLED_DIGITS.get(spelledDigitValue - 1);
            int firstIndex = line.indexOf(spelledDigit);
            if (firstIndex >= 0) {
                digits.add(new PositionedDigit(firstIndex, spelledDigitValue));
                int lastIndex = line.lastIndexOf(spelledDigit);
                if (lastIndex > firstIndex) {
                    digits.add(new PositionedDigit(lastIndex, spelledDigitValue));
                }
            }
        }
        for (char digit = '0'; digit <= '9'; ++digit) {
            int firstIndex = line.indexOf(digit);
            if (firstIndex >= 0) {
                digits.add(new PositionedDigit(firstIndex, digit - '0'));
                int lastIndex = line.lastIndexOf(digit);
                if (lastIndex > firstIndex) {
                    digits.add(new PositionedDigit(lastIndex, digit - '0'));
                }
            }
        }
        int firstDigit = digits.getFirst().digit();
        int lastDigit = digits.getLast().digit();
        return 10L * firstDigit + lastDigit;
    }
}
