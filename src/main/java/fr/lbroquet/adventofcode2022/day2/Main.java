package fr.lbroquet.adventofcode2022.day2;

import fr.lbroquet.Input;

import java.io.BufferedReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader input = Input.load(Main.class);
        int score = input.lines()
                .mapToInt(Main::score)
                .sum();
        System.out.printf("Total score: %d%n", score);
    }

    private static int score(String line) {
        Shape myShape = Shape.from(line.charAt(2));
        Shape opponentShape = Shape.from(line.charAt(0));
        return myShape.score() + myShape.outcome(opponentShape).score();
    }

}
