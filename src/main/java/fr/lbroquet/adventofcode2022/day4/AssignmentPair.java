package fr.lbroquet.adventofcode2022.day4;

public record AssignmentPair(Assignment first, Assignment second) {

    public static AssignmentPair of(String line) {
        int spearatorIndex = line.indexOf(',');
        return new AssignmentPair(
                Assignment.of(line.substring(0, spearatorIndex)),
                Assignment.of(line.substring(spearatorIndex + 1))
        );
    }

    public boolean fullOverlap() {
        return first.contains(second) || second.contains(first);
    }

    public boolean overlap() {
        return first.overlap(second);
    }
}
