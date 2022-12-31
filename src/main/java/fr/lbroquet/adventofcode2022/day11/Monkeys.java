package fr.lbroquet.adventofcode2022.day11;

import java.util.Comparator;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class Monkeys {
    private final SortedMap<MonkeyNumber, Monkey> monkeys = new TreeMap<>();
    private int divisorsProduct = 1;

    public void add(Monkey monkey) {
        monkeys.put(monkey.number(), monkey);
        divisorsProduct *= monkey.divisor();
    }

    public void playOneRound() {
        for (Monkey monkey : monkeys.values()) {
            monkey.playOneRound(monkeys, divisorsProduct);
        }
    }

    public long monkeyBusiness() {
        List<Monkey> mostActiveMonkeys = monkeys.values()
                .stream()
                .sorted(Comparator.comparingLong(Monkey::inspections).reversed())
                .limit(2)
                .toList();
        return mostActiveMonkeys.stream().mapToLong(Monkey::inspections).reduce(1, Math::multiplyExact);
    }
}
