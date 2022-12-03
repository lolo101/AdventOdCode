package fr.lbroquet.adventofcode2018.day1;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main {

    private static BufferedReader loadInput() {
        InputStream inputStream = Main.class.getResourceAsStream("input");
        return new BufferedReader(new InputStreamReader(inputStream));
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = loadInput()) {
            int sum = reader.lines()
                    .mapToInt(Integer::parseInt)
                    .sum();
            System.out.println("Final frequency : " + sum);
        }

        try (BufferedReader reader = loadInput()) {
            Iterable<Integer> changes = reader.lines()
                    .map(Integer::valueOf)
                    .collect(toList());
            Accumulator accu = new Accumulator(changes);
            System.out.println("First repeated frequency : " + accu.firstDuplicate());
        }
    }
}
