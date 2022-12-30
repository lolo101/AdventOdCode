package fr.lbroquet.adventofcode2022.day11;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;
import java.util.function.Function;
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
    private final MonkeyNumber number;
    private final Queue<WorryLevel> items;
    private final Operation operation;
    private final Function<WorryLevel, MonkeyNumber> monkeySelector;
    private int inspections;

    private Monkey(int number, String[] items, String operation, Function<WorryLevel, MonkeyNumber> monkeySelector) {
        this.number = new MonkeyNumber(number);
        this.items = Stream.of(items)
                .mapToInt(Integer::parseInt)
                .mapToObj(WorryLevel::new)
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
        return new Monkey(number, items, operation, selector(divisor, ifTrue, ifFalse));
    }

    private static String read(Pattern pattern, String groupName, String line) {
        Matcher matcher = pattern.matcher(line);
        if(matcher.matches()) return matcher.group(groupName);
        throw new IllegalArgumentException("No match for group %s of pattern %s in string %s".formatted(groupName, pattern, line));
    }

    private static Function<WorryLevel, MonkeyNumber> selector(int divisor, int ifTrue, int ifFalse) {
        return worryLevel ->  new MonkeyNumber(worryLevel.value() % divisor == 0 ? ifTrue : ifFalse);
    }

    public MonkeyNumber number() {
        return number;
    }

    public int inspections() {
        return inspections;
    }

    public Collection<WorryLevel> items() {
        return items;
    }

    public void recieve(Collection<WorryLevel> items) {
        this.items.addAll(items);
    }

    public Map<MonkeyNumber, List<WorryLevel>> playOneRound() {
        Map<MonkeyNumber, List<WorryLevel>> thrown = new HashMap<>();
        while (!items.isEmpty()) {
            WorryLevel item = items.remove();
            WorryLevel inspectedItem = inspect(item);
            MonkeyNumber target = monkeySelector.apply(inspectedItem);
            List<WorryLevel> targetItems = thrown.getOrDefault(target, new ArrayList<>());
            targetItems.add(inspectedItem);
            thrown.put(target, targetItems);
        }
        return thrown;
    }

    private WorryLevel inspect(WorryLevel item) {
        inspections++;
        return operation.operate(item);
    }
}
