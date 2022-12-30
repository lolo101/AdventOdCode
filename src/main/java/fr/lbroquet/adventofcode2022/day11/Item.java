package fr.lbroquet.adventofcode2022.day11;

public record Item(int worryLevel) {

    public Item relief() {
        return new Item(worryLevel / 3);
    }
}
