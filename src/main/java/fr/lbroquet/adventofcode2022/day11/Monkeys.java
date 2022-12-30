package fr.lbroquet.adventofcode2022.day11;

import java.util.HashMap;
import java.util.Map;

public class Monkeys {
    private final Map<Integer, Monkey> monkeys = new HashMap<>();

    public void add(Monkey monkey) {
        monkeys.put(monkey.number(), monkey);
    }

    public void playOneRound() {
        for (Monkey monkey : monkeys.values()) {
            System.out.printf("Monkey %d:%n", monkey.number());
            monkey.playOneRound();
        }
    }
}
