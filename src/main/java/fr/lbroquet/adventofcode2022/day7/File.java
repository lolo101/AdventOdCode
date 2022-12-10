package fr.lbroquet.adventofcode2022.day7;

public final class File extends Node {
    private final int size;

    public File(NodeName name, int size) {
        super(name);
        this.size = size;
    }

    @Override
    public int size() {
        return size;
    }
}
