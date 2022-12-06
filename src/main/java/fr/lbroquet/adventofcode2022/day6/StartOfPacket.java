package fr.lbroquet.adventofcode2022.day6;

public record StartOfPacket(int index, String marker) {
    public static final StartOfPacket NotFound = new StartOfPacket(-1, "Not Found");
}
