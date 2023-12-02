package fr.lbroquet.adventofcode2023.day2;

import java.util.Collection;
import java.util.Map;

public record Game(long id, Collection<CubesSubset> cubesSubsets) {
    public boolean isPossible(Map<String, Integer> constraints) {
        return cubesSubsets.stream().allMatch(cubesSubset -> cubesSubset.isPossible(constraints));
    }
}
