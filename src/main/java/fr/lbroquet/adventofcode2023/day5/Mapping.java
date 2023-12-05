package fr.lbroquet.adventofcode2023.day5;

public record Mapping(long sourceRangeStart, long destinationRangeStart, long rangeLength) {
    public boolean contains(Long from) {
        return sourceRangeStart <= from && sourceRangeStart + rangeLength - 1 >= from;
    }

    public long map(Long from) {
        long offset = from - sourceRangeStart;
        return destinationRangeStart + offset;
    }
}
