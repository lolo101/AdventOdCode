package fr.lbroquet.adventofcode2023.day5;

import java.util.Collection;
import java.util.SequencedCollection;
import java.util.TreeSet;

import static java.util.Comparator.comparing;

public class Ranges {
    private final SequencedCollection<Range> ranges = new TreeSet<>(comparing(Range::start));

    public Ranges(Collection<Range> ranges) {
        this.ranges.addAll(ranges);
    }

    public Collection<Range> components() {
        return ranges;
    }

    public long lowestBoundary() {
        return ranges.getFirst().start();
    }
}
