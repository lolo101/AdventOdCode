package fr.lbroquet.adventofcode2023.day2;

import java.util.Collection;
import java.util.Map;

import static java.lang.Math.max;

public record Game(long id, Collection<CubeSet> cubeSubsets) {
    public boolean isPossible(Map<String, Integer> constraints) {
        return cubeSubsets.stream().allMatch(cubeSubset -> cubeSubset.isPossible(constraints));
    }

    public CubeSet minimumCubeSet() {
        return cubeSubsets.stream().reduce(new CubeSet(0, 0, 0), Game::smallestPossibleCubeSet);
    }

    private static CubeSet smallestPossibleCubeSet(CubeSet firstSet, CubeSet secondSet) {
        return new CubeSet(
                max(firstSet.red(), secondSet.red()),
                max(firstSet.green(), secondSet.green()),
                max(firstSet.blue(), secondSet.blue())
        );
    }
}
