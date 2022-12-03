package fr.lbroquet.adventofcode2022.day1;

import fr.lbroquet.Input;

import java.io.BufferedReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader input = Input.load(Main.class);
        Elves elevs = input.lines().collect(
                Elves::new,
                Elves::addCalories,
                (e1, e2) -> {}
        );
        System.out.println(elevs);
    }
}
