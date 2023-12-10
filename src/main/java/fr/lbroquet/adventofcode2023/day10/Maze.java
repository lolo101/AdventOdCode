package fr.lbroquet.adventofcode2023.day10;

import java.util.*;

import static java.util.Comparator.comparing;

public class Maze {
    private final char[][] mazeArray;

    public Maze(char[][] mazeArray) {
        this.mazeArray = mazeArray;
    }

    public long farthestDistanceFromStart() {
        Node startingNode = findStartingNode();
        Set<Node> visitedNodes = visitMaze(startingNode);
        return visitedNodes.stream().mapToLong(Node::distance).max().orElse(0);
    }

    private Set<Node> visitMaze(Node startingNode) {
        Deque<Node> nodesToVisit = new LinkedList<>();
        nodesToVisit.add(startingNode);
        Set<Node> visitedNodes = new TreeSet<>(comparing(Node::row).thenComparing(Node::column));

        while (!nodesToVisit.isEmpty()) {
            Node node = nodesToVisit.removeFirst();
            northNode(node)
                    .filter(northNode -> !visitedNodes.contains(northNode))
                    .ifPresent(nodesToVisit::addLast);
            eastNode(node)
                    .filter(northNode -> !visitedNodes.contains(northNode))
                    .ifPresent(nodesToVisit::addLast);
            southNode(node)
                    .filter(northNode -> !visitedNodes.contains(northNode))
                    .ifPresent(nodesToVisit::addLast);
            westNode(node)
                    .filter(northNode -> !visitedNodes.contains(northNode))
                    .ifPresent(nodesToVisit::addLast);
            visitedNodes.add(node);
        }
        return visitedNodes;
    }

    private Node findStartingNode() {
        for (int row = 0; row < mazeArray.length; row++) {
            char[] mazeRow = mazeArray[row];
            for (int column = 0; column < mazeRow.length; column++) {
                if (mazeRow[column] == 'S') {
                    return new Node(row, column, 0);
                }
            }
        }
        throw new RuntimeException("No starting node !??");
    }

    private Optional<Node> northNode(Node node) {
        if (node.row() > 0) {
            char pipe = mazeArray[node.row() - 1][node.column()];
            if (connectsSouth(pipe)) {
                return Optional.of(new Node(node.row() - 1, node.column(), node.distance() + 1));
            }
        }
        return Optional.empty();
    }

    private static boolean connectsSouth(char pipe) {
        return pipe == '|' || pipe == '7' || pipe == 'F';
    }

    private Optional<Node> eastNode(Node node) {
        char[] mazeRow = mazeArray[node.row()];
        if (node.column() < mazeRow.length - 1) {
            char pipe = mazeRow[node.column() + 1];
            if (connectsWest(pipe)) {
                return Optional.of(new Node(node.row(), node.column() + 1, node.distance() + 1));
            }
        }
        return Optional.empty();
    }

    private static boolean connectsWest(char pipe) {
        return pipe == '-' || pipe == 'J' || pipe == '7';
    }


    private Optional<Node> southNode(Node node) {
        if (node.row() < mazeArray.length - 1) {
            char pipe = mazeArray[node.row() + 1][node.column()];
            if (connectsNorth(pipe)) {
                return Optional.of(new Node(node.row() + 1, node.column(), node.distance() + 1));
            }
        }
        return Optional.empty();
    }

    private static boolean connectsNorth(char pipe) {
        return pipe == '|' || pipe == 'L' || pipe == 'J';
    }


    private Optional<Node> westNode(Node node) {
        if (node.column() > 0) {
            char pipe = mazeArray[node.row()][node.column() - 1];
            if (connectsEast(pipe)) {
                return Optional.of(new Node(node.row(), node.column() - 1, node.distance() + 1));
            }
        }
        return Optional.empty();
    }

    private static boolean connectsEast(char pipe) {
        return pipe == '-' || pipe == 'L' || pipe == 'F';
    }
}
