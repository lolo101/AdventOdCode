package fr.lbroquet.adventofcode2023.day12;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RecordRowTest {

    @Test
    void one_chunk_one_group_two_arrangements() {
        RecordRow recordRow = new RecordRow("???", new String[]{"2"});
        assertEquals(2, recordRow.arrangements());
    }

    @Test
    void one_chunk_with_damaged_one_group_one_arrangements() {
        RecordRow recordRow = new RecordRow("#??", new String[]{"2"});
        assertEquals(1, recordRow.arrangements());
    }

    @Test
    void one_chunk_two_groups_one_arrangement() {
        RecordRow recordRow = new RecordRow("???", new String[]{"1", "1"});
        assertEquals(1, recordRow.arrangements());
    }
}