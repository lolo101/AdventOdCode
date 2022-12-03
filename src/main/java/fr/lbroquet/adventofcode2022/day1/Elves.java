package fr.lbroquet.adventofcode2022.day1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Elves {
    private final Collection<Long> calories = new ArrayList<>();
    private long currentCalories;

    public void addCalories(String line) {
        if (line.isBlank()) {
            calories.add(currentCalories);
            currentCalories = 0;
        } else {
            currentCalories += Long.parseLong(line);
        }
    }

    @Override
    public String toString() {
        return """
                Calories: %s
                Max: %d
                Sum of top three: %d
                """
                .formatted(
                        calories,
                        Collections.max(calories),
                        topThreeSum());
    }

    private long topThreeSum() {
        return calories.stream()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .mapToLong(Long::longValue)
                .sum();
    }
}
