package fr.lbroquet.adventofcode2022.day3;

import java.util.ArrayList;
import java.util.Collection;

public class Groups {
    private final Collection<Group> groups = new ArrayList<>();
    private final Collection<Rucksack> currentGroup = new ArrayList<>(3);

    public void add(Rucksack rucksack) {
        currentGroup.add(rucksack);
        if (currentGroup.size() == 3) {
            groups.add(new Group(currentGroup));
            currentGroup.clear();
        }
    }

    public int priority() {
        return groups.stream()
                .mapToInt(Group::priority)
                .sum();
    }
}
