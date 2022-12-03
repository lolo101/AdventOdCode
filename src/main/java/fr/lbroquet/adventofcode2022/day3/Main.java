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
        System.out.println(priority);
    }
}
