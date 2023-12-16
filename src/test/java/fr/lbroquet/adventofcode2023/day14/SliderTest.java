package fr.lbroquet.adventofcode2023.day14;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SliderTest {
    // O..O#
    @Test
    void should_return_load() {
        Slider slider = new Slider("O..O", 4);
        assertEquals(100 + 99, slider.load());
    }

    // xxxxx#O..O#
    @Test
    void should_return_load_with_offset() {
        Slider slider = new Slider("O..O", 10);
        assertEquals(94 + 93, slider.load());
    }
}