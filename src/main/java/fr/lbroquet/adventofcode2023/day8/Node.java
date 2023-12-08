package fr.lbroquet.adventofcode2023.day8;

public record Node(String name) {
    public boolean isDeparture() {
        return name.endsWith("A");
    }

    public boolean isArrival() {
        return name.endsWith("Z");
    }
}
