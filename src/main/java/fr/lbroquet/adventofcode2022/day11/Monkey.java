package fr.lbroquet.adventofcode2022.day11;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Monkey {
    private static final Pattern NUMBER_PATTERN = Pattern.compile("Monkey (?<number>\\d+):");
    private static final Pattern ITEMS_PATTERN = Pattern.compile("  Starting items: (?<items>\\d+(, \\d+)*)");
    private static final Pattern ITEM_SEPARATOR = Pattern.compile(", ");
    private static final Pattern OPERATION_PATTERN = Pattern.compile("  Operation: new = (?<operation>old (\\+|\\*) (old|\\d+))");
    private static final Pattern TEST_PATTERN = Pattern.compile("  Test: divisible by (?<divisor>\\d+)");
    private static final Pattern IF_TRUE_PATTERN = Pattern.compile("    If true: throw to monkey (?<targetWhenTrue>\\d+)");
    private static final Pattern IF_FALSE_PATTERN = Pattern.compile("    If false: throw to monkey (?<targetWhenFalse>\\d+)");
    private final int number;
    private final List<Item> items;

    private Monkey(int number, String[] items) {
        this.number = number;
        this.items = Stream.of(items).map(Item::new).toList();
    }

    public static Monkey of(BufferedReader reader) throws IOException {
        int number = Integer.parseInt(read(NUMBER_PATTERN, "number", reader.readLine()));
        String[] items = ITEM_SEPARATOR.split(read(ITEMS_PATTERN, "items", reader.readLine()));
        String operation = reader.readLine().substring(13);
        String test = reader.readLine().substring(8);
        String ifTrue = reader.readLine().substring(13);
        String ifFalse = reader.readLine().substring(14);
        reader.readLine();
        return new Monkey(number, items);
    }

    private static String read(Pattern pattern, String groupName, String line) {
        Matcher matcher = pattern.matcher(line);
        if(matcher.matches()) return matcher.group(groupName);
        throw new IllegalArgumentException("No match for group %s of pattern %s in string %s".formatted(groupName, pattern, line));
    }

    public int number() {
        return number;
    }

    public void playOneRound() {
        for (Item item : items) {
            System.out.printf("  Monkey inspects an item with a worry level of %s.%n", item.worryLevel());
        }
        //TODO examine each item
    }
}
