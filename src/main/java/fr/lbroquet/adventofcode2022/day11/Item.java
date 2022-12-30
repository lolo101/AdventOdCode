package fr.lbroquet.adventofcode2022.day11;

public class Item {
    private final int worryLevel;

    public Item(int worryLevel) {
        this.worryLevel = worryLevel;
    }

    public int worryLevel() {
        return worryLevel;
    }

    public Item relief() {
        return new Item(worryLevel / 3);
    }
}
