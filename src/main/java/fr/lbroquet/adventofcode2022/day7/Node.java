package fr.lbroquet.adventofcode2022.day7;

public sealed abstract class Node permits File, Directory {
    protected final NodeName name;

    public Node(NodeName name) {
        this.name = name;
    }

    public NodeName name() {
        return name;
    }

    public abstract int size();
}
