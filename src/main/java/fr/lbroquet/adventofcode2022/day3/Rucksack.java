package fr.lbroquet.adventofcode2022.day3;

import java.util.Collection;
import java.util.SortedSet;
import java.util.TreeSet;

public record Rucksack(String itemTypes) {

    public int priority() {
        int splitIndex = itemTypes.length() / 2;
        String firstCompartment = itemTypes.substring(0, splitIndex);
        String secondCompartment = itemTypes.substring(splitIndex);
        return priority(firstCompartment, secondCompartment);
    }

    public SortedSet<ItemType> itemTypesSet() {
        return toItemTypes(itemTypes);
    }

    private static int priority(String firstCompartment, String secondCompartment) {
        Collection<ItemType> firstTypes = toItemTypes(firstCompartment);
        Collection<ItemType> secondTypes = toItemTypes(secondCompartment);

        firstTypes.retainAll(secondTypes);
        return firstTypes.iterator().next().priority();
    }

    private static SortedSet<ItemType> toItemTypes(String itemTypes) {
        return itemTypes.chars()
                .mapToObj(ItemType::new)
                .collect(TreeSet::new, TreeSet::add, TreeSet::addAll);
    }
}
