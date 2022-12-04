package fr.lbroquet.adventofcode2022.day4;

import fr.lbroquet.Input;

public class Main {
    public static void main(String[] args) {
        long fullOverlap = Input.load(Main.class)
                .lines()
                .map(AssignmentPair::of)
                .filter(AssignmentPair::fullOverlap)
                .count();
        long simpleOverlap = Input.load(Main.class)
                .lines()
                .map(AssignmentPair::of)
                .filter(AssignmentPair::overlap)
                .count();
        System.out.printf("""
                # of full overlap: %d
                # of simple overlap: %d
                """, fullOverlap, simpleOverlap);
    }
}
