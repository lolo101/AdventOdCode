package fr.lbroquet.adventofcode2023.day3;

import fr.lbroquet.Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.SortedSet;
import java.util.TreeSet;

import static java.util.Comparator.comparing;

public class Main {
    private static final Collection<PartNumber> partNumbers = new ArrayList<>();
    private static final SortedSet<Symbol> symbols = new TreeSet<>(comparing(Symbol::row).thenComparing(Symbol::column));
    private static final SortedSet<Gear> gears = new TreeSet<>(comparing(Gear::row).thenComparing(Gear::column));

    public static void main(String[] args) throws IOException {
        BufferedReader input = Input.load(Main.class);
        initialize(input);

        long sum = partNumbers.stream().filter(partNumber -> partNumber.isAdjacentToAny(symbols)).mapToLong(PartNumber::value).sum();
        System.out.printf("Sum of part numbers: %d%n", sum);

        partNumbers.forEach(partNumber -> partNumber.attachTo(gears));
        long ratios = gears.stream().filter(Gear::isProperlyConnected).mapToLong(Gear::ratio).sum();
        System.out.printf("Sum of gear ratios: %d%n", ratios);
    }

    private static void initialize(BufferedReader input) throws IOException {
        StringBuilder partNumberAccumulator = new StringBuilder();
        String line;
        int row = 0;
        int column = 0;
        for (; (line = input.readLine()) != null; ++row) {
            char[] chars = line.toCharArray();
            for (column = 0; column < chars.length; ++column) {
                char columnChar = chars[column];
                if (isNumber(columnChar)) {
                    partNumberAccumulator.append(columnChar);
                } else {
                    numberFinished(partNumberAccumulator, row, column);
                    if (isSymbol(columnChar)) {
                        symbols.add(new Symbol(row, column));
                    }
                    if (isGear(columnChar)) {
                        gears.add(new Gear(row, column));
                    }
                }
            }
            numberFinished(partNumberAccumulator, row, column);
        }
        numberFinished(partNumberAccumulator, row, column);
    }

    private static boolean isNumber(char columnChar) {
        return '0' <= columnChar && columnChar <= '9';
    }

    private static boolean isSymbol(char columnChar) {
        return !isNumber(columnChar) && columnChar != '.';
    }

    private static boolean isGear(char columnChar) {
        return columnChar == '*';
    }

    private static void numberFinished(StringBuilder partNumberAccumulator, int row, int column) {
        if (!partNumberAccumulator.isEmpty()) {
            PartNumber partNumber = new PartNumber(partNumberAccumulator.toString(), row, column);
            partNumbers.add(partNumber);
            partNumberAccumulator.setLength(0);
        }
    }
}
