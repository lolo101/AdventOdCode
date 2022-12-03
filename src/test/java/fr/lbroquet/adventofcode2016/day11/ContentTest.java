package fr.lbroquet.adventofcode2016.day11;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ContentTest {

    @Test
    void should_return_empty_stream_on_null_input() {
        Content[] aContent = Content.asStream(null).toArray(Content[]::new);
        assertEquals(0, aContent.length);
    }

    @Test
    void nominal() {
        String content = " a thulium generator, a thulium-compatible microchip, a plutonium generator, and a strontium generator";
        Content[] aContent = Content.asStream(content).toArray(Content[]::new);
        assertEquals(4, aContent.length);
    }

}
