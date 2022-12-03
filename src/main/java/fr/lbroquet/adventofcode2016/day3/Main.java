package fr.lbroquet.adventofcode2016.day3;

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
            System.out.println("Nb of possible triangles: " + reader.lines().map(Triangle::new).filter(Triangle::isPossible).count());
        }
        try (BufferedReader reader = loadInput()) {
            int possible = 0;
            for (String line1, line2, line3; (line1 = reader.readLine()) != null;) {
                line2 = reader.readLine();
                line3 = reader.readLine();
                TriTriangle triTriangle = new TriTriangle(line1 + line2 + line3);
                possible += triTriangle.countPossibles();
            }
            System.out.println("Nb of possile triangles with vertical coords: " + possible);
        }
    }
}
