package fr.lbroquet.adventofcode2023.day3;

import java.util.SortedSet;

public record PartNumber(String partNumber, int row, int startColumnInclusive, int endColumnExclusive) {

    PartNumber(String partNumber, int row, int endColumnExclusive) {
        this(partNumber, row, endColumnExclusive - partNumber.length(), endColumnExclusive);
    }

    public long value() {
        return Long.parseLong(partNumber);
    }

    public boolean isAdjacentToAny(SortedSet<Symbol> symbols) {
        Symbol upperLeft = new Symbol(row - 1, startColumnInclusive - 1);
        Symbol lowerRight = new Symbol(row + 1, endColumnExclusive + 1);
        SortedSet<Symbol> subset = symbols.subSet(upperLeft, lowerRight);
        return subset.stream().anyMatch(symbol -> startColumnInclusive - 1 <= symbol.column() && symbol.column() <= endColumnExclusive);
    }

    public void attachTo(SortedSet<Gear> gears) {
        Gear upperLeft = new Gear(row - 1, startColumnInclusive - 1);
        Gear lowerRight = new Gear(row + 1, endColumnExclusive + 1);
        SortedSet<Gear> subset = gears.subSet(upperLeft, lowerRight);
        subset.stream()
                .filter(symbol -> startColumnInclusive - 1 <= symbol.column() && symbol.column() <= endColumnExclusive)
                .forEach(gear -> gear.addPart(this));
    }
}
