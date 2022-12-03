package fr.lbroquet.adventofcode2022.day3;

public class Rucksack {
    private final String line;

    public Rucksack(String line) {
        this.line = line;
    }

    public int priority() {
        int splitIndex = line.length() / 2;
        String firstCompartment = line.substring(0, splitIndex);
        String secondCompartment = line.substring(splitIndex);
        return priority(firstCompartment, secondCompartment);
    }

    private static int priority(String firstCompartment, String secondCompartment) {
        int type = firstCompartment.chars()
                .filter(c -> secondCompartment.indexOf(c) != -1)
                .findFirst()
                .orElseThrow();
        return priority(type);
    }

    private static int priority(int common) {
        return (Character.isLowerCase(common)
                ? 1 + common - 'a'
                : 27 + common - 'A');
    }
}
