package fr.lbroquet.adventofcode2022.day6;

public record Marker(int index, String marker) {
    public static final Marker NotFound = new Marker(-1, "Not Found");
}
