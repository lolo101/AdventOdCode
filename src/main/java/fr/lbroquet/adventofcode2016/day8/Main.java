package fr.lbroquet.adventofcode2016.day8;

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
            Screen screen = new Screen();
            reader.lines().forEach(screen::addInstr);
            System.out.println(screen.countPixelsOn());
            System.out.println(screen.display());
        }
    }
}
