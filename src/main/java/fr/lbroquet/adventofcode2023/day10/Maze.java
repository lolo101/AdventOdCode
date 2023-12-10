package fr.lbroquet.adventofcode2023.day10;

import java.util.*;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;

public class Maze {
    private final char[][] mazeArray;
    private final Set<Node> visitedNodes = new TreeSet<>(comparing(Node::row).thenComparing(Node::column));

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
        visitedNodes.clear();

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
        if (node.row() > 0 && connectsNorth(mazeArray[node.row()][node.column()])) {
            char pipe = mazeArray[node.row() - 1][node.column()];
            if (connectsSouth(pipe)) {
                return Optional.of(new Node(node.row() - 1, node.column(), node.distance() + 1));
            }
        }
        return Optional.empty();
    }

    private static boolean connectsSouth(char pipe) {
        return pipe == '|' || pipe == '7' || pipe == 'F' || pipe == 'S';
    }

    private Optional<Node> eastNode(Node node) {
        char[] mazeRow = mazeArray[node.row()];
        if (node.column() < mazeRow.length - 1 && connectsEast(mazeArray[node.row()][node.column()])) {
            char pipe = mazeRow[node.column() + 1];
            if (connectsWest(pipe)) {
                return Optional.of(new Node(node.row(), node.column() + 1, node.distance() + 1));
            }
        }
        return Optional.empty();
    }

    private static boolean connectsWest(char pipe) {
        return pipe == '-' || pipe == 'J' || pipe == '7' || pipe == 'S';
    }

    private Optional<Node> southNode(Node node) {
        if (node.row() < mazeArray.length - 1 && connectsSouth(mazeArray[node.row()][node.column()])) {
            char pipe = mazeArray[node.row() + 1][node.column()];
            if (connectsNorth(pipe)) {
                return Optional.of(new Node(node.row() + 1, node.column(), node.distance() + 1));
            }
        }
        return Optional.empty();
    }

    private static boolean connectsNorth(char pipe) {
        return pipe == '|' || pipe == 'L' || pipe == 'J' || pipe == 'S';
    }

    private Optional<Node> westNode(Node node) {
        if (node.column() > 0 && connectsWest(mazeArray[node.row()][node.column()])) {
            char pipe = mazeArray[node.row()][node.column() - 1];
            if (connectsEast(pipe)) {
                return Optional.of(new Node(node.row(), node.column() - 1, node.distance() + 1));
            }
        }
        return Optional.empty();
    }

    private static boolean connectsEast(char pipe) {
        return pipe == '-' || pipe == 'L' || pipe == 'F' || pipe == 'S';
    }

    public String loopMap() {
        Map<Integer, Map<Integer, Long>> distanceByRowAndColumn = visitedNodes.stream().collect(groupingBy(Node::row, toMap(Node::column, Node::distance)));

        StringBuilder distanceMap = new StringBuilder();
        for (int row = 0; row < mazeArray.length; row++) {
            char[] mazeRow = mazeArray[row];
            for (int column = 0; column < mazeRow.length; column++) {
                char pipe = mazeRow[column];
                String nodeString = visitedNode(distanceByRowAndColumn, row, column)
                        .map(distance -> STR."\{(char) 27}[31m\{asciiArt(pipe)}\{(char) 27}[39m")
                        .orElse(asciiArt(pipe));
                distanceMap.append(nodeString);
            }
            distanceMap.append('\n');
        }
        return distanceMap.toString();
    }

    public String partitionMap() {
        replaceStartingNodeChar();
        Map<Integer, Map<Integer, Long>> distanceByRowAndColumn = visitedNodes.stream().collect(groupingBy(Node::row, toMap(Node::column, Node::distance)));
        StringBuilder partitionMap = new StringBuilder();
        int crossingValue = 0;
        for (int row = 0; row < mazeArray.length; row++) {
            char[] mazeRow = mazeArray[row];
            for (int column = 0; column < mazeRow.length; column++) {
                char pipe = mazeRow[column];
                boolean walkingOnLoop = visitedNode(distanceByRowAndColumn, row, column).isPresent();
                if (walkingOnLoop) crossingValue += loopCrossingValue(pipe);
                partitionMap.append(partitionArt(walkingOnLoop, crossingValue / 2, pipe));
            }
            partitionMap.append('\n');
        }
        return partitionMap.toString();
    }

    private void replaceStartingNodeChar() {
        Node startingNode = findStartingNode();
        mazeArray[startingNode.row()][startingNode.column()] = nodeChar(startingNode);
    }

    private char nodeChar(Node startingNode) {
        boolean connectsNorth = connectsSouth(mazeArray[startingNode.row() - 1][startingNode.column()]);
        boolean connectsEast = connectsWest(mazeArray[startingNode.row()][startingNode.column() + 1]);
        boolean connectsSouth = connectsNorth(mazeArray[startingNode.row() + 1][startingNode.column()]);
        boolean connectsWest = connectsEast(mazeArray[startingNode.row()][startingNode.column() - 1]);
        if (connectsNorth && connectsSouth) return '|';
        if (connectsEast && connectsWest) return '-';
        if (connectsNorth && connectsEast) return 'L';
        if (connectsNorth && connectsWest) return 'J';
        if (connectsSouth && connectsWest) return '7';
        if (connectsSouth && connectsEast) return 'F';
        return '?';
    }

    private static Optional<Long> visitedNode(Map<Integer, Map<Integer, Long>> distanceByRowAndColumn, int row, int column) {
        Map<Integer, Long> distanceByColumn = distanceByRowAndColumn.get(row);
        if (distanceByColumn != null) {
            Long distance = distanceByColumn.get(column);
            if (distance != null) {
                return Optional.of(distance);
            }
        }
        return Optional.empty();
    }

    private static int loopCrossingValue(char pipe) {
        return switch (pipe) {
            case '|' -> 2;
            case 'F', 'J' -> 1;
            case 'L', '7' -> -1;
            default -> 0;
        };
    }

    private static String partitionArt(boolean walkingOnLoop, int crossed, char pipe) {
        if (walkingOnLoop) {
            return STR."\{(char) 27}[37m\{asciiArt(pipe)}\{(char) 27}[39m";
        }
        return crossed % 2 == 0
                ? STR."\{(char) 27}[32mO\{(char) 27}[39m"
                : STR."\{(char) 27}[31mI\{(char) 27}[39m";
    }

    private static String asciiArt(char pipe) {
        return switch (pipe) {
            case '|' -> "┃";
            case '-' -> "━";
            case 'L' -> "┗";
            case 'J' -> "┛";
            case '7' -> "┓";
            case 'F' -> "┏";
            case 'S' -> "S";
            default -> " ";
        };
    }
}
