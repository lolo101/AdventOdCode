package fr.lbroquet.adventofcode2023.day5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeSet;

import static java.util.Comparator.comparing;

public class Mappings {

    private final Collection<Mapping> mappings = new TreeSet<>(comparing(Mapping::sourceRangeStart));

    public void add(String[] mapping) {
        long destinationRangeStart = Long.parseLong(mapping[0]);
        long sourceRangeStart = Long.parseLong(mapping[1]);
        long rangeLength = Long.parseLong(mapping[2]);
        mappings.add(new Mapping(sourceRangeStart, destinationRangeStart, rangeLength));
    }

    public Ranges map(Ranges ranges) {
        Collection<Range> mapped = ranges.components().stream().map(this::map).flatMap(Collection::stream).toList();
        return new Ranges(mapped);
    }

    private Collection<Range> map(Range range) {
        Collection<Range> mappeds = new ArrayList<>();
        Range unmapped = range;

        for (Mapping mapping : mappings) {
            if (mapping.overlap(unmapped)) {
                mappeds.add(mapping.map(unmapped));
            }
            Range under = mapping.rangeUnder(unmapped);
            if (under.length() > 0) {
                mappeds.add(under);
            }
            unmapped = mapping.rangeAbove(unmapped);
            if (unmapped.length() <= 0) {
                return mappeds;
            }
        }

        return mappeds;
    }
}
