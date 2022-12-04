package fr.lbroquet.adventofcode2022.day4;

import static java.lang.Integer.parseInt;

public record Assignment(int start, int end) {

    public static Assignment of(String range) {
        int spearatorIndex = range.indexOf('-');
        return new Assignment(
                parseInt(range.substring(0, spearatorIndex)),
                parseInt(range.substring(spearatorIndex + 1))
        );
    }

    public boolean contains(Assignment other) {
        return start <= other.start && other.end <= end;
    }

    public boolean overlap(Assignment other) {
        return other.start <= end && start <= other.end;
    }
}
