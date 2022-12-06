package fr.lbroquet.adventofcode2022.day6;

public record StartOfMessage(int index, String marker) {
    public static final StartOfMessage NotFound = new StartOfMessage(-1, "Not Found");
}
