package fr.lbroquet.adventofcode2022.day11;

import java.util.*;

public class Monkeys {
    private final SortedMap<Integer, Monkey> monkeys = new TreeMap<>();

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

    public void printItems() {
        monkeys.forEach((number, monkey) -> System.out.printf("Monkey %d: %s%n", number, monkey.items()));
    }
}
