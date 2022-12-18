package fr.lbroquet.adventofcode2022.day9;

import fr.lbroquet.Input;

public class Main {
    public static void main(String[] args) {
        Rope rope = new Rope();
        Input.load(Main.class)
                .lines()
                .map(Movement::of)
                .forEach(rope::move);

        System.out.println(rope.tailPositions.size());
    }
}
