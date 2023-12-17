package fr.lbroquet.adventofcode2023.day16;

import fr.lbroquet.Input;

import java.io.BufferedReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader input = Input.load(Main.class)) {
            char[][] contraptionArray = input.lines().map(String::toCharArray).toArray(char[][]::new);
            Contraption contraption = new Contraption(contraptionArray);
            System.out.printf("Energized tiles: %d%n", contraption.energizedTiles());
        }
    }
}
