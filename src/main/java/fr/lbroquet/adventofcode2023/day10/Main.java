package fr.lbroquet.adventofcode2023.day10;

import fr.lbroquet.Input;

import java.io.BufferedReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader input = Input.load(Main.class)) {
            char[][] mazeArray = input.lines().map(String::toCharArray).toArray(char[][]::new);
            Maze maze = new Maze(mazeArray);
            System.out.printf("Farthest distance from start: %d%n", maze.farthestDistanceFromStart());
        }
    }
}
