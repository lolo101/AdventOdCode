package fr.lbroquet.adventofcode2023.day6;

import java.util.stream.LongStream;

public record Race(String time, String distance) {
    public long waysToBeat() {
        long raceTime = Long.parseLong(time);
        long distanceToBeat = Long.parseLong(distance);
        return LongStream.range(0, raceTime)
                .map(chargeTime -> (raceTime - chargeTime) * chargeTime)
                .filter(distanceWithCharge -> distanceWithCharge > distanceToBeat)
                .count();
    }
}
