package fr.lbroquet.adventofcode2023.day5;

import static java.lang.Math.max;
import static java.lang.Math.min;

public record Mapping(long sourceRangeStart, long destinationRangeStart, long rangeLength) {
    public boolean contains(Long from) {
        return sourceRangeStart <= from && from < sourceRangeStart + rangeLength;
    }

    public long map(Long from) {
        long offset = from - sourceRangeStart;
        return destinationRangeStart + offset;
    }

    public boolean overlap(Range range) {
        return sourceRangeStart < range.start() + range.length() && range.start() < sourceRangeStart + rangeLength;
    }

    public Range map(Range range) {
        long start = max(sourceRangeStart, range.start());
        long end = min(sourceRangeStart + rangeLength, range.start() + range.length());
        long offset = start - sourceRangeStart;
        return new Range(destinationRangeStart + offset, end - start);
    }

    public Range rangeUnder(Range range) {
        long length = min(range.length(), sourceRangeStart - range.start());
        return new Range(range.start(), length);
    }

    public Range rangeAbove(Range range) {
        long mappingEnd = sourceRangeStart + rangeLength;
        long rangeEnd = range.start() + range.length();
        long length = min(range.length(), rangeEnd - mappingEnd);
        return new Range(max(range.start(), mappingEnd), length);
    }
}
