package fr.lbroquet.adventofcode2023.day5;

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

    public Collection<Long> map(Collection<Long> list) {
        return list.stream().map(this::map).toList();
    }

    private Long map(Long from) {
        return mappings.stream()
                .filter(mapping -> mapping.contains(from))
                .mapToLong(value -> value.map(from))
                .findFirst()
                .orElse(from);
    }
}
