package fr.lbroquet.adventofcode2022.day3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RucksackTest {

    @Test
    void should_return_priority_sum() {
        Rucksack rucksack = new Rucksack("abcabc");
        assertEquals(1 + 2 + 3, rucksack.priority());
    }
    @Test
    void should_return_zero_when_no_char_is_common() {
        Rucksack rucksack = new Rucksack("abcdef");
        assertEquals(0, rucksack.priority());
    }

    @Test
    void uppercase_are_higher_priority() {
        Rucksack rucksack = new Rucksack("ABCABC");
        assertEquals(27 + 28 + 29, rucksack.priority());
    }
    @Test
    void should_ignore_duplicates() {
        Rucksack rucksack = new Rucksack("aabaac");
        assertEquals(1, rucksack.priority());
    }
}