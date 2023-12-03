package fr.lbroquet.adventofcode2023.day3;

import java.util.ArrayList;
import java.util.Collection;

public class Gear {
    private final int row;
    private final int column;
    private final Collection<PartNumber> parts = new ArrayList<>();

    public Gear(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int row() {
        return row;
    }

    public int column() {
        return column;
    }

    public void addPart(PartNumber part) {
        parts.add(part);
    }

    public boolean isProperlyConnected() {
        return parts.size() == 2;
    }

    public long ratio() {
        return parts.stream().mapToLong(PartNumber::value).reduce(1, Math::multiplyExact);
    }
}
