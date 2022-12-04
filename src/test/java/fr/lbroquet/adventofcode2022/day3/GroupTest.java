package fr.lbroquet.adventofcode2022.day3;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GroupTest {
    @Test
    void should_throw_when_no_item_type_in_common() {
        Group group = new Group(List.of(
                new Rucksack("abc"),
                new Rucksack("def"),
                new Rucksack("ghi")
        ));
        assertThrows(IllegalStateException.class, group::priority);
    }

    @Test
    void should_throw_when_many_item_types_in_common() {
        Group group = new Group(List.of(
                new Rucksack("abc"),
                new Rucksack("abd"),
                new Rucksack("abe")
        ));
        assertThrows(IllegalStateException.class, group::priority);
    }

    @Test
    void should_return_item_types_priority() {
        Group group = new Group(List.of(
                new Rucksack("abc"),
                new Rucksack("ade"),
                new Rucksack("afga")
        ));
        assertEquals(1, group.priority());
    }
}