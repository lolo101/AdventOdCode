package fr.lbroquet.adventofcode2023.day11;

import fr.lbroquet.Input;

import java.io.BufferedReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader input = Input.load(Main.class)) {
            char[][] universeArray = input.lines().map(String::toCharArray).toArray(char[][]::new);
            Universe universe = new Universe(universeArray);
            System.out.printf("Sum of distances between pairs of galaxies: %d%n", universe.sumOfDistances());
        }
    }
}
