package fr.lbroquet.adventofcode2016.day9;

public class Marker {

    private final int seqStart;
    private final int seqLen;
    private final int seqMult;

    Marker(String compressed, int position) {
        int separatorIndex = compressed.indexOf('x', position);
        int endIndex = compressed.indexOf(')', position);
        seqStart = endIndex + 1;
        seqLen = Integer.parseInt(compressed.substring(position + 1, separatorIndex));
        seqMult = Integer.parseInt(compressed.substring(separatorIndex + 1, endIndex));
    }

    public int getSequenceStart() {
        return seqStart;
    }

    public int getSequenceLength() {
        return seqLen;
    }

    public int getMultiplier() {
        return seqMult;
    }
}
