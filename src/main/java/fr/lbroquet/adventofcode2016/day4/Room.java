package fr.lbroquet.adventofcode2016.day4;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Matcher;

public class Room {

    private final String roomName;
    private final String checksum;
    private final int sectorId;

    Room(Matcher matcher) {
        roomName = matcher.group("roomName");
        checksum = matcher.group("checksum");
        sectorId = Integer.parseInt(matcher.group("sectorId"));
    }

    public boolean checksumMatching() {
        return checksum().equals(checksum);
    }

    public String shiftName() {
        int shift = sectorId % 26;
        return roomName.chars()
                .mapToObj(c -> c == '-' ? ' ' : shiftLetter(c, shift))
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
    }

    public int getSectorId() {
        return sectorId;
    }

    private static char shiftLetter(int c, int shift) {
        int alphaIndex = (c - 'a' + shift) % 26;
        return (char) ('a' + alphaIndex);
    }

    private String checksum() {
        Map<Integer, Integer> frequencies = roomName.chars()
                .filter(c -> c != '-')
                .collect(HashMap::new, (m, c) -> m.put(c, m.getOrDefault(c, 0) + 1), Room::merge);
        SortedMap<Integer, SortedSet<Integer>> orderedByFrequency = new TreeMap<>(Comparator.reverseOrder());
        for (Map.Entry<Integer, Integer> e : frequencies.entrySet()) {
            SortedSet<Integer> chars = orderedByFrequency.get(e.getValue());
            if (chars == null) {
                chars = new TreeSet<>();
                orderedByFrequency.put(e.getValue(), chars);
            }
            chars.add(e.getKey());
        }
        StringBuilder longChecksum = orderedByFrequency.values().stream()
                .flatMap(Set::stream)
                .map(i -> (char)i.intValue())
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
        return longChecksum.substring(0, 5);
    }

    private static void merge(Map<Integer, Integer> m1, Map<Integer, Integer> m2) {
        for (Integer c : m2.keySet()) {
            m1.put(c, m1.getOrDefault(c, 0) + m2.get(c));
        }
    }
}
