package fr.lbroquet.adventofcode2016.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {

    private static final Pattern ROOM_TAG = Pattern.compile("(?<roomName>(?:\\p{Lower}+-)+)(?<sectorId>\\d+)\\[(?<checksum>\\p{Lower}{5})\\]");

    private static BufferedReader loadInput() {
        InputStream inputStream = Main.class.getResourceAsStream("input");
        return new BufferedReader(new InputStreamReader(inputStream));
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = loadInput()) {
            List<Room> rooms = reader.lines()
                    .map(ROOM_TAG::matcher)
                    .filter(Matcher::matches)
                    .map(Room::new)
                    .filter(Room::checksumMatching)
                    .collect(Collectors.toList());

            Optional<Integer> sectorSum = rooms.stream()
                    .map(Room::getSectorId)
                    .reduce(Integer::sum);
            System.out.println(sectorSum.orElse(0));

            System.out.println("--------");

            rooms.stream().forEach(r -> System.out.println(r.shiftName() + " -> " + r.getSectorId()));
        }
    }
}
