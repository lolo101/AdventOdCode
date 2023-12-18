package fr.lbroquet.adventofcode2023.day17;

import fr.lbroquet.Input;

import java.io.BufferedReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader input = Input.load(Main.class)) {
            char[][] mapArray = input.lines().map(String::toCharArray).toArray(char[][]::new);
            HeatMap heatMap = new HeatMap(mapArray);
            System.out.printf("Least heat loss: %d%n", heatMap.leastHeatLoss(new Position(140, 140)));
            System.out.println(heatMap.drawMap());
        }
    }
}
