package fr.lbroquet.adventofcode2022.day11;

import fr.lbroquet.Input;

import java.io.BufferedReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Monkeys monkeys = readMonkeys();
        monkeys.playOneRound();
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
