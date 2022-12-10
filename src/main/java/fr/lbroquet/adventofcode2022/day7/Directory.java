package fr.lbroquet.adventofcode2022.day7;

import java.util.HashMap;
import java.util.Map;

public final class Directory extends Node {

    private static final NodeName PARENT_NAME = new NodeName("..");
    private final Map<NodeName, Node> nodes = new HashMap<>();

    public Directory(NodeName name, Directory parent) {
        super(name);
        nodes.put(PARENT_NAME, parent);
    }

    public void add(String listing) {
        Node node = node(listing);
        nodes.put(node.name(), node);
    }

    public Directory changeTo(NodeName targetName) {
        return (Directory) nodes.getOrDefault(targetName, this);
    }

    @Override
    public int size() {
        return nodes.entrySet().stream()
                .filter(e -> !e.getKey().equals(PARENT_NAME))
                .map(Map.Entry::getValue)
                .mapToInt(Node::size)
                .sum();
    }

    private Node node(String listing) {
        if (listing.startsWith("dir")) {
            String dirName = listing.substring(4);
            return new Directory(new NodeName(dirName), this);
        }
        String[] sizeAndName = listing.split(" ");
        return new File(
                new NodeName(sizeAndName[1]),
                Integer.parseInt(sizeAndName[0])
        );
    }
}
