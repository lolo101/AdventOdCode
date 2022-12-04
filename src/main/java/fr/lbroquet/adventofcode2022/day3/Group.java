package fr.lbroquet.adventofcode2022.day3;

import java.util.Collection;
import java.util.List;
import java.util.SortedSet;

public class Group {
    private final Collection<Rucksack> rucksacks;

    public Group(Collection<Rucksack> rucksacks) {
        this.rucksacks = List.copyOf(rucksacks);
    }

    public int priority() {
        SortedSet<ItemType> itemType = rucksacks.stream()
                .map(Rucksack::itemTypesSet)
                .reduce(
                        ((itemTypes1, itemTypes2) -> {
                            itemTypes1.retainAll(itemTypes2);
                            return itemTypes1;
                        })
                )
                .orElseThrow();
        if(itemType.size() != 1) throw new IllegalStateException(itemType.toString());
        return itemType.first().priority();
    }
}
