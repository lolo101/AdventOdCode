package fr.lbroquet.adventofcode2020.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static BufferedReader loadInput() {
        InputStream inputStream = Main.class.getResourceAsStream("input");
        return new BufferedReader(new InputStreamReader(inputStream));
    }

    public static void main(String... args) throws IOException {
        try (BufferedReader reader = loadInput()) {
            List<Integer> numbers = reader.lines()
                    .mapToInt(Integer::parseInt)
                    .collect(ArrayList::new, List::add, List::addAll);

            for (int i = 0; i < numbers.size() - 2; i++) {
                for (int j = i + 1; j < numbers.size() - 1; j++) {
                    for (int k = j + 1; k < numbers.size(); k++) {
                        int n1 = numbers.get(i);
                        int n2 = numbers.get(j);
                        int n3 = numbers.get(k);
                        if (n1 + n2 + n3 == 2020) {
                            System.out.printf("%1$d + %2$d + %3$d = 2020; %1$d x %2$d x %3$d = %4$d", n1, n2, n3, n1 * n2 * n3);
                        }
                    }
                }
            }
        }
    }
}
