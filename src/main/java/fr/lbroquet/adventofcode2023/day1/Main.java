package fr.lbroquet.adventofcode2023.day1;

import fr.lbroquet.Input;

import java.io.BufferedReader;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Main {
    public static void main(String[] args) {
        BufferedReader input = Input.load(Main.class);
        long sum = input.lines().mapToLong(Main::toCalibrationValue).sum();
        System.out.printf("Sum: %d%n", sum);
    }

    private static long toCalibrationValue(String line) {
        int firstDigitIndex = line.length();
        int lastDigitIndex = 0;
        for (char digit = '0'; digit <= '9'; ++digit) {
            int firstIndex = line.indexOf(digit);
            firstDigitIndex = min(firstDigitIndex, firstIndex < 0 ? firstDigitIndex : firstIndex);
            int lastIndex = line.lastIndexOf(digit);
            lastDigitIndex = max(lastDigitIndex, lastIndex < 0 ? lastDigitIndex : lastIndex);
        }
        int firstDigit = line.charAt(firstDigitIndex) - '0';
        int lastDigit = line.charAt(lastDigitIndex) - '0';
        return 10L * firstDigit + lastDigit;
    }
}
