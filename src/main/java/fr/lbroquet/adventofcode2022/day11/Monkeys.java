package fr.lbroquet.adventofcode2022.day11;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Monkeys {
    private final Map<Integer, Monkey> monkeys = new HashMap<>();

    public void add(Monkey monkey) {
        monkeys.put(monkey.number(), monkey);
    }

    public void playOneRound() {
        for (Monkey monkey : monkeys.values()) {
            System.out.printf("Monkey %d:%n", monkey.number());
            Map<Integer, List<Item>> thrown = monkey.playOneRound();
            thrown.forEach((number, items) -> monkeys.get(number).recieve(items));
        }
    }

    public int monkeyBusiness() {
        List<Monkey> mostActiveMonkeys = monkeys.values()
                .stream()
                .sorted(Comparator.comparingInt(Monkey::inspections).reversed())
                .limit(2)
                .toList();
        return mostActiveMonkeys.stream().mapToInt(Monkey::inspections).reduce(1, Math::multiplyExact);
    }
}
