package fr.lbroquet.adventofcode2023.day2;

import java.util.Map;

public record CubesSubset(int red, int green, int blue) {
    public boolean isPossible(Map<String, Integer> constraints) {
        return constraints.get("red") >= red &&
                constraints.get("green") >= green &&
                constraints.get("blue") >= blue;
    }
}
