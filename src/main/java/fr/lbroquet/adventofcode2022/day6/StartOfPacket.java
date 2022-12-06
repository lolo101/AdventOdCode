package fr.lbroquet.adventofcode2022.day6;

public class StartOfPacket {
    private final String stream;

    public StartOfPacket(String stream) {
        this.stream = stream;
    }

    public int index() {
        for (int index = 4; index <= stream.length(); index++) {
            var distinctChars = stream.substring(index - 4, index)
                    .chars()
                    .distinct()
                    .count();
            if (distinctChars == 4) {
                return index;
            }
        }
        return -1;
    }
}
