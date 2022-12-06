package fr.lbroquet.adventofcode2022.day6;

public class Protocol {
    private final String stream;

    public Protocol(String stream) {
        this.stream = stream;
    }

    public StartOfPacket startOfPacket() {
        for (int index = 4; index <= stream.length(); index++) {
            String candidate = stream.substring(index - 4, index);
            var distinctChars = candidate
                    .chars()
                    .distinct()
                    .count();
            if (distinctChars == 4) return new StartOfPacket(index, candidate);
        }
        return StartOfPacket.NotFound;
    }

    public StartOfMessage startOfMessage() {
        for (int index = 14; index <= stream.length(); index++) {
            String candidate = stream.substring(index - 14, index);
            var distinctChars = candidate
                    .chars()
                    .distinct()
                    .count();
            if (distinctChars == 14) return new StartOfMessage(index, candidate);
        }
        return StartOfMessage.NotFound;
    }
}
