package fr.lbroquet.adventofcode2016.day11;

 enum Part {
    generator, microchip;

    public static Part from(String input) {
        for (Part value : values()) {
            if (input.endsWith(value.toString())) {
                return value;
            }
        }
        return null;
    }
}
