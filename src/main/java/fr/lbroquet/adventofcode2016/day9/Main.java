package fr.lbroquet.adventofcode2016.day9;

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
        try (BufferedReader reader = loadInput()) {
            String compressed = reader.readLine();
            System.out.println("Compressed length = " + compressed.length());

            System.out.println("Decompressed length = " + Decompressor.decompress(compressed));

            System.out.println("Decompressed v2 length = " + Decompressor.decompress_v2(compressed));
        }
    }
}
