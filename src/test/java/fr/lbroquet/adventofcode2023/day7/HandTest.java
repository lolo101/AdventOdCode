package fr.lbroquet.adventofcode2023.day7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class HandTest {

    @Test
    void rank_by_type() {
        Hand higherHand = new Hand("AAAAA", 1);
        Hand lowerHand = new Hand("AA1AA", 2);
        assertTrue(higherHand.compareTo(lowerHand) > 0);
    }

    @Test
    void rank_by_card() {
        Hand higherHand = new Hand("AAKKQ", 1);
        Hand lowerHand = new Hand("AA221", 2);
        assertTrue(higherHand.compareTo(lowerHand) > 0);
    }
}