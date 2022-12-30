package fr.lbroquet.adventofcode2022.day11;

import fr.lbroquet.Input;

import java.io.BufferedReader;
import java.io.IOException;

public class Main {

    private static final int NUMBER_OF_RONDS = 10_000;

    public static void main(String[] args) throws IOException {
        Monkeys monkeys = readMonkeys();
        for (int round = 0; round < NUMBER_OF_RONDS; round++) {
            System.out.println("Round " + round);
            monkeys.playOneRound();
        }
        System.out.printf("Monkey business level: %d%n", monkeys.monkeyBusiness());
    }

    private static Monkeys readMonkeys() throws IOException {
        try (BufferedReader reader = Input.load(Main.class)) {
            Monkeys monkeys = new Monkeys();
            while (reader.ready()) {
                Monkey monkey = Monkey.of(reader);
                monkeys.add(monkey);
            }
            return monkeys;
        }
    }
}
