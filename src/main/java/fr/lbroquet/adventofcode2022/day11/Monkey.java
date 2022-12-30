package fr.lbroquet.adventofcode2022.day11;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;
import java.util.function.UnaryOperator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toCollection;

public class Monkey {
    private static final Pattern NUMBER_PATTERN = Pattern.compile("Monkey (?<number>\\d+):");
    private static final Pattern ITEMS_PATTERN = Pattern.compile(" {2}Starting items: (?<items>\\d+(, \\d+)*)");
    private static final Pattern ITEM_SEPARATOR = Pattern.compile(", ");
    private static final Pattern OPERATION_PATTERN = Pattern.compile(" {2}Operation: new = (?<operation>old ([+*]) (old|\\d+))");
    private static final Pattern TEST_PATTERN = Pattern.compile(" {2}Test: divisible by (?<divisor>\\d+)");
    private static final Pattern IF_TRUE_PATTERN = Pattern.compile(" {4}If true: throw to monkey (?<targetWhenTrue>\\d+)");
    private static final Pattern IF_FALSE_PATTERN = Pattern.compile(" {4}If false: throw to monkey (?<targetWhenFalse>\\d+)");
    private final int number;
    private final Queue<Item> items;
    private final Operation operation;
    private final UnaryOperator<Integer> monkeySelector;
    private int inspections;

    private Monkey(int number, String[] items, String operation, UnaryOperator<Integer> monkeySelector) {
        this.number = number;
        this.items = Stream.of(items)
                .mapToInt(Integer::parseInt)
                .mapToObj(Item::new)
                .collect(toCollection(ArrayDeque::new));
        this.operation = new Operation(operation);
        this.monkeySelector = monkeySelector;
    }

    public static Monkey of(BufferedReader reader) throws IOException {
        int number = Integer.parseInt(read(NUMBER_PATTERN, "number", reader.readLine()));
        String[] items = ITEM_SEPARATOR.split(read(ITEMS_PATTERN, "items", reader.readLine()));
        String operation = read(OPERATION_PATTERN, "operation", reader.readLine());
        int divisor = Integer.parseInt(read(TEST_PATTERN, "divisor", reader.readLine()));
        int ifTrue = Integer.parseInt(read(IF_TRUE_PATTERN, "targetWhenTrue", reader.readLine()));
        int ifFalse = Integer.parseInt(read(IF_FALSE_PATTERN, "targetWhenFalse", reader.readLine()));
        reader.readLine();
        UnaryOperator<Integer> selector = worryLevel -> {
            boolean divisible = worryLevel % divisor == 0;
            if(divisible) {
                System.out.printf("    Current worry level is divisible by %d.%n", divisor);
                System.out.printf("    Item with worry level %d is thrown to monkey %d.%n", worryLevel, ifTrue);
                return ifTrue;
            }
            System.out.printf("    Current worry level is not divisible by %d.%n", divisor);
            System.out.printf("    Item with worry level %d is thrown to monkey %d.%n", worryLevel, ifFalse);
            return ifFalse;
        };
        return new Monkey(number, items, operation, selector);
    }

    private static String read(Pattern pattern, String groupName, String line) {
        Matcher matcher = pattern.matcher(line);
        if(matcher.matches()) return matcher.group(groupName);
        throw new IllegalArgumentException("No match for group %s of pattern %s in string %s".formatted(groupName, pattern, line));
    }

    public int number() {
        return number;
    }

    public void recieve(Collection<Item> items) {
        this.items.addAll(items);
    }

    public Map<Integer, List<Item>> playOneRound() {
        Map<Integer, List<Item>> thrown = new HashMap<>();
        while (!items.isEmpty()) {
            Item item = items.remove();
            inspections++;
            System.out.printf("  Monkey inspects an item with a worry level of %s.%n", item.worryLevel());
            Item worriedItem = operation.operate(item);
            System.out.printf("    Worry level %s to %d.%n", operation, worriedItem.worryLevel());
            Item relievedItem = worriedItem.relief();
            System.out.printf("    Monkey gets bored with item. Worry level is divided by 3 to %d.%n", relievedItem.worryLevel());
            thrown.getOrDefault(monkeySelector.apply(item.worryLevel()), new ArrayList<>()).add(item);
        }
        return thrown;
    }

    public int inspections() {
        return inspections;
    }
}
