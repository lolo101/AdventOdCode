package fr.lbroquet.adventofcode2023.day12;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RecordRowTest {

    @Test
    void test() {
        RecordRow recordRow = new RecordRow("..???#??.??????", new String[]{"4", "3"});
        assertEquals(12, recordRow.arrangements());
    }

    @Test
    void test2() {
        RecordRow recordRow = new RecordRow("?..???????", new String[]{"1", "1", "2"});
        assertEquals(4 + 3 + 2 + 1 + 2 + 1 + 1, recordRow.arrangements());
    }

    @Test
    void zero_chunk_zero_group_one_arrangements() {
        RecordRow recordRow = new RecordRow("", new String[0]);
        assertEquals(1, recordRow.arrangements());
    }

    @Test
    void only_unknown_chunk_zero_group_one_arrangements() {
        RecordRow recordRow = new RecordRow("???", new String[0]);
        assertEquals(1, recordRow.arrangements());
    }

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
    void one_chunk_with_damaged_one_group_zero_arrangements() {
        RecordRow recordRow = new RecordRow("?#?#", new String[]{"2"});
        assertEquals(0, recordRow.arrangements());
    }

    @Test
    void one_chunk_two_groups_one_arrangement() {
        RecordRow recordRow = new RecordRow("???", new String[]{"1", "1"});
        assertEquals(1, recordRow.arrangements());
    }
}
