package fr.lbroquet.adventofcode2023.day15;

import fr.lbroquet.Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.SequencedMap;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Main {
    private static final SortedMap<Integer, SequencedMap<String, Integer>> boxes = new TreeMap<>();
    private static final Pattern INSTRUCTION = Pattern.compile("(?<label>[a-z]+)(?<operation>[-=])(?<focal>[1-9]?)");

    public static void main(String[] args) throws IOException {
        try (BufferedReader input = Input.load(Main.class)) {
            String[] instructions = input.readLine().split(",");
            long sum = Stream.of(instructions).mapToLong(Main::hash).sum();
            System.out.printf("Sum of HASH: %d%n", sum);

            Stream.of(instructions).forEach(Main::operate);

            long focusingPower = 0;
            for (Entry<Integer, SequencedMap<String, Integer>> box : boxes.entrySet()) {
                int boxNumber = box.getKey() + 1;
                int slotNumber = 0;
                for (Entry<String, Integer> lenses : box.getValue().entrySet()) {
                    ++slotNumber;
                    int focal = lenses.getValue();
                    focusingPower += (long) boxNumber * slotNumber * focal;
                }
            }
            System.out.printf("Focusing Power: %d%n", focusingPower);
        }
    }

    private static int hash(String value) {
        int currentValue = 0;
        for (char c : value.toCharArray()) {
            currentValue += c;
            currentValue *= 17;
            currentValue %= 256;
        }
        return currentValue;
    }

    private static void operate(String instruction) {
        Matcher matcher = INSTRUCTION.matcher(instruction);
        if (matcher.matches()) {
            String label = matcher.group("label");
            int box = hash(label);
            SequencedMap<String, Integer> lenses = boxes.computeIfAbsent(box, unused -> new LinkedHashMap<>());
            char operation = matcher.group("operation").charAt(0);
            if (operation == '-') {
                lenses.remove(label);
            }
            if (operation == '=') {
                int focal = Integer.parseInt(matcher.group("focal"));
                lenses.put(label, focal);
            }
        } else {
            throw new IllegalArgumentException(instruction);
        }
    }
}
