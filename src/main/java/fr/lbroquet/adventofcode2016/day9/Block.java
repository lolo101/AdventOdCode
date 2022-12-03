package fr.lbroquet.adventofcode2016.day9;

public class Block {

    private final Marker marker;

    public Block(String compressed, int position) {
        marker = new Marker(compressed, position);
    }

    public Marker getMarker() {
        return marker;
    }

    public int getDecompressedLength() {
        return marker.getSequenceLength() * marker.getMultiplier();
    }

    public int end() {
        int sequenceStart = marker.getSequenceStart();
        int sequenceLength = marker.getSequenceLength();
        return sequenceStart + sequenceLength;
    }
}
