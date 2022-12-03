package fr.lbroquet.adventofcode2016.day9;

public class Decompressor {

    private Decompressor() {
        throw new UnsupportedOperationException();
    }

    public static int decompress(String compressed) {
        for (int i = 0, count = 0;;) {
            int nextMarkerIndex = compressed.indexOf('(', i);
            if (nextMarkerIndex == -1) {
                return count + compressed.length() - i;
            } else {
                count += nextMarkerIndex - i;
                Block block = new Block(compressed, nextMarkerIndex);
                count += block.getDecompressedLength();
                i = block.end();
            }
        }
    }

    public static long decompress_v2(String compressed) {
        return decompress_v2(compressed, 0, compressed.length());
    }

    private static long decompress_v2(String compressed, int start, int end) {
        long count = 0;
        for (int i = start;;) {
            int nextMarkerIndex = compressed.indexOf('(', i);
            if (nextMarkerIndex >= 0 && nextMarkerIndex < end) {
                count += nextMarkerIndex - i;
                Block block = new Block(compressed, nextMarkerIndex);
                Marker marker = block.getMarker();
                count += marker.getMultiplier() * decompress_v2(compressed, marker.getSequenceStart(), block.end());
                i = block.end();
            } else {
                return count + end - i;
            }
        }
    }
}
