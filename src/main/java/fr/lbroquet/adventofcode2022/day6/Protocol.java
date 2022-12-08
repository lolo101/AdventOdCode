package fr.lbroquet.adventofcode2022.day6;

public class Protocol {
    private final String stream;

    public Protocol(String stream) {
        this.stream = stream;
    }

    public Marker startOfPacket() {
        return findMarkerOfSize(4);
    }

    public Marker startOfMessage() {
        return findMarkerOfSize(14);
    }

    private Marker findMarkerOfSize(int size) {
        for (int index = size; index <= stream.length(); index++) {
            String candidate = stream.substring(index - size, index);
            var distinctChars = candidate
                .chars()
                .distinct()
                .count();
            if (distinctChars == size) return new Marker(index, candidate);
        }
        return Marker.NotFound;
    }
}
