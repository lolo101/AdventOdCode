package fr.lbroquet.adventofcode2022.day3;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class RucksackTest {

    @Test
    void should_return_priority() {
        Rucksack rucksack = new Rucksack("abcade");
        assertEquals(1, rucksack.priority());
    }

    @Test
    void should_throw_when_no_char_is_common() {
        Rucksack rucksack = new Rucksack("abcdef");
        assertThrows(NoSuchElementException.class, rucksack::priority);
    }

    @Test
    void uppercase_are_higher_priority() {
        Rucksack rucksack = new Rucksack("ABCADE");
        assertEquals(27, rucksack.priority());
    }

    @Test
    void should_ignore_duplicates() {
        Rucksack rucksack = new Rucksack("aabaac");
        assertEquals(1, rucksack.priority());
    }
}