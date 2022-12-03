package fr.lbroquet.adventofcode2016.day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main {

    private static BufferedReader loadInput() {
        InputStream inputStream = Main.class.getResourceAsStream("input");
        return new BufferedReader(new InputStreamReader(inputStream));
    }

    public static void main(String[] args) throws IOException {
        Dedup dedup = new Dedup();
        try (BufferedReader reader = loadInput()) {
            reader.lines().forEach(dedup::repeat);
        }
        System.out.println(dedup.decode());
        System.out.println(dedup.decodeReversed());
    }
}
