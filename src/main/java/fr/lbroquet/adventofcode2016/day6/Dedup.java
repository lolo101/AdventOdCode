package fr.lbroquet.adventofcode2016.day6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Dedup {

    private final List<Map<Character, Integer>> positions = new ArrayList<>();

    public Dedup() {
    }

    public void repeat(String message) {
        checkInit(message);
        for (int i = 0; i < message.length(); ++i) {
            Map<Character, Integer> frequencies = positions.get(i);
            char c = message.charAt(i);
            Integer f = frequencies.getOrDefault(c, 0);
            frequencies.put(c, f + 1);
        }
    }

    public String decode() {
        return decodeWith(Map.Entry.comparingByValue(Comparator.reverseOrder()));
    }

    public String decodeReversed() {
        return decodeWith(Map.Entry.comparingByValue());
    }

    private String decodeWith(Comparator<Map.Entry<Character, Integer>> comparator) {
        return positions.stream()
                .map(m -> sort(m, comparator))
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    private static char sort(Map<Character, Integer> frequencies, Comparator<Map.Entry<Character, Integer>> comparator) {
        return frequencies.entrySet().stream()
                .sorted(comparator)
                .findFirst()
                .map(Map.Entry::getKey)
                .orElse('?');
    }

    private void checkInit(String message) {
        if (positions.isEmpty()) {
            for(int i = 0; i < message.length(); ++i) {
                positions.add(new HashMap<>());
            }
        }
    }
}
