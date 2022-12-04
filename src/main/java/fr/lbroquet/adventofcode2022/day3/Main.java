package fr.lbroquet.adventofcode2022.day3;

import fr.lbroquet.Input;

import java.io.BufferedReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader input = Input.load(Main.class);
        int priority = input.lines()
                .map(Rucksack::new)
                .mapToInt(Rucksack::priority)
                .sum();
        Groups groups = input.lines()
                .map(Rucksack::new)
                .collect(Groups::new, Groups::add, (g1, g2) -> {});
        System.out.printf("""
                Rucksacks priorities sum: %d
                Groups priorities sum: %d
                """, priority, groups.priority());
    }
}
