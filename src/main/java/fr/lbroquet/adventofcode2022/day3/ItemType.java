package fr.lbroquet.adventofcode2022.day3;

public record ItemType(int type) implements Comparable<ItemType> {
    public int priority() {
        return (Character.isLowerCase(type)
                ? 1 + type - 'a'
                : 27 + type - 'A');
    }

    @Override
    public int compareTo(ItemType o) {
        return type - o.type;
    }
}
