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
        Collection<Integer> firstTypes = firstCompartment.chars()
                .collect(TreeSet::new, TreeSet::add, TreeSet::addAll);
        Collection<Integer> secondTypes = secondCompartment.chars()
                .collect(TreeSet::new, TreeSet::add, TreeSet::addAll);

        firstTypes.retainAll(secondTypes);
        return priority(firstTypes.iterator().next());
    }

    private static int priority(int common) {
        return (Character.isLowerCase(common)
                ? 1 + common - 'a'
                : 27 + common - 'A');
    }
}
