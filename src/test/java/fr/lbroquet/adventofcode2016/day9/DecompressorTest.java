package fr.lbroquet.adventofcode2016.day9;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DecompressorTest {

    @Test
    void decompress_plain_string() {
        int decompressed = Decompressor.decompress("a");
        assertEquals(1, decompressed);
    }

    @Test
    void decompress_simple_compression() {
        int decompressed = Decompressor.decompress("a(2x3)bcd");
        assertEquals(1 + 3*2 + 1, decompressed);
    }

    @Test
    void decompress_recursive_compression() {
        int decompressed = Decompressor.decompress("a(9x3)b(2x2)cdef");
        assertEquals(1 + 3*9 + 1, decompressed);
    }

    @Test
    void decompress_v2_plain_string() {
        long decompressed = Decompressor.decompress_v2("a");
        assertEquals(1, decompressed);
    }

    @Test
    void decompress_v2_simple_compression() {
        long decompressed = Decompressor.decompress_v2("a(2x3)bcd");
        assertEquals(1 + 3*2 + 1, decompressed);
    }

    @Test
    void decompress_v2_recursive_compression() {
        long decompressed = Decompressor.decompress_v2("a(9x3)b(2x2)cdef");
        assertEquals(1 + 3*( 1 + 2*2 + 1) + 1, decompressed);
    }

    @Test
    void decompress_v2_multiple_recursive_compression() {
        long decompressed = Decompressor.decompress_v2("a(26x3)b(2x2)cde(10x2)fg(3x3)hijkl");
        assertEquals(1 + 3*( 1 + 2*2 + 1 + 2*(2 + 3*3) + 1) + 1, decompressed);
    }

}
