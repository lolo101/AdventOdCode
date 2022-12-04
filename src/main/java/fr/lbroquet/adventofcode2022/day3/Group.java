package fr.lbroquet.adventofcode2022.day3;

import java.util.Collection;
import java.util.List;

public class Group {
    private final Collection<Rucksack> rucksacks;

    public Group(Collection<Rucksack> rucksacks) {
        this.rucksacks = List.copyOf(rucksacks);
    }

    public int priority() {
        // TODO Find common item type in rucksacks and return its priority
        return 0;
    }
}
