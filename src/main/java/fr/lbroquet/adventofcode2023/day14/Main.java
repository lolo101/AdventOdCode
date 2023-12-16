package fr.lbroquet.adventofcode2023.day14;

import fr.lbroquet.Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader input = Input.load(Main.class)) {
            char[][] platformArray = input.lines().map(String::toCharArray).toArray(char[][]::new);
            Platform platform = new Platform(platformArray);
            List<Slider> sliders = platform.tilt();
            long load = sliders.stream().mapToLong(Slider::load).sum();
            System.out.printf("Total load: %d%n", load);
        }
    }
}
