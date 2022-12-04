package fr.lbroquet.adventofcode2022.day3;

import java.util.Collection;
import java.util.TreeSet;

public record Rucksack(String itemsTypes) {

    public int priority() {
        int splitIndex = itemsTypes.length() / 2;
        String firstCompartment = itemsTypes.substring(0, splitIndex);
        String secondCompartment = itemsTypes.substring(splitIndex);
        return priority(firstCompartment, secondCompartment);
    }

    private static int priority(String firstCompartment, String secondCompartment) {
        Collection<ItemType> firstTypes = firstCompartment.chars()
                .mapToObj(ItemType::new)
                .collect(TreeSet::new, TreeSet::add, TreeSet::addAll);
        Collection<ItemType> secondTypes = secondCompartment.chars()
                .mapToObj(ItemType::new)
                .collect(TreeSet::new, TreeSet::add, TreeSet::addAll);

        firstTypes.retainAll(secondTypes);
        return firstTypes.iterator().next().priority();
    }
}
