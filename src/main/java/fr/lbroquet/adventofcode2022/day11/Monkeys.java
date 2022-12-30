package fr.lbroquet.adventofcode2022.day11;

import java.util.*;

import static java.util.stream.Collectors.joining;

public class Monkeys {
    private final SortedMap<MonkeyNumber, Monkey> monkeys = new TreeMap<>();

    public void add(Monkey monkey) {
        monkeys.put(monkey.number(), monkey);
    }

    public void playOneRound() {
        for (Monkey monkey : monkeys.values()) {
            System.out.printf("Monkey %s:%n", monkey.number());
            Map<MonkeyNumber, List<WorryLevel>> thrown = monkey.playOneRound();
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
        monkeys.forEach((number, monkey) -> System.out.printf(
                "Monkey %s: %s%n",
                number,
                monkey.items()
                        .stream()
                        .mapToLong(WorryLevel::value)
                        .mapToObj(Objects::toString)
                        .collect(joining(", "))
                )
        );
    }
}
