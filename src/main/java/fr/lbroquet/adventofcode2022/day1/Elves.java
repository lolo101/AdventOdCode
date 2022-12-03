package fr.lbroquet.adventofcode2022.day1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

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
                """
                .formatted(calories, Collections.max(calories));
    }
}
