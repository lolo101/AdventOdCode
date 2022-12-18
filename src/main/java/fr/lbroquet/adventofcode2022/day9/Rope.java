package fr.lbroquet.adventofcode2022.day9;

import java.util.*;
import java.util.stream.Collectors;

public class Rope {
    private static final int NUMBER_OF_KNOTS = 10;
    private final Map<Integer, Stack<Position>> knots = new HashMap<>();

    public Rope() {
        for (int knotNumber = 0; knotNumber < NUMBER_OF_KNOTS; knotNumber++) {
            Stack<Position> positions = new Stack<>();
            positions.push(new Position(0, 0));
            knots.put(knotNumber, positions);
        }
    }

    public void move(Movement movement) {
        moveHead(movement);
        tailFollows();
    }

    private void moveHead(Movement movement) {
        Stack<Position> headPositions = knots.get(0);
        headPositions.push(movement.move(headPositions.peek()));
    }

    private void tailFollows() {
        Position head = knots.get(0).peek();
        Stack<Position> tailHeadPositions = knots.get(1);
        for (
                Position tailHead = tailHeadPositions.peek();
                tailHead.distance(head) > 1;
                tailHead = tailHeadPositions.peek()
        ) {
            for (int knotNumber = 1; knotNumber < knots.size(); knotNumber++) {
                Position previousKnot = knots.get(knotNumber - 1).peek();
                Stack<Position> knotPositions = knots.get(knotNumber);
                Position knotLastPosition = knotPositions.peek();
                if (knotLastPosition.distance(previousKnot) > 1)
                    knotPositions.push(knotLastPosition.oneStepToward(previousKnot));
            }
        }
    }

    public Set<Object> tailPositions() {
        return new HashSet<>(knots.get(knots.size() - 1));
    }

    public String printTailPositions() {
        Collection<Position> positions = knots.get(knots.size() - 1);
        int minRow = positions.stream().mapToInt(Position::row).min().orElseThrow();
        int maxRow = positions.stream().mapToInt(Position::row).max().orElseThrow();
        int minColumn = positions.stream().mapToInt(Position::column).min().orElseThrow();
        int maxColumn = positions.stream().mapToInt(Position::column).max().orElseThrow();
        char[][] visited = new char[maxRow - minRow + 1][];
        for (int row = 0; row < visited.length; row++) {
            visited[row] = new char[maxColumn - minColumn + 1];
            Arrays.fill(visited[row], '.');
        }

        positions.forEach(position -> visited[position.row() - minRow][position.column() - minColumn] = '#');

        return Arrays.stream(visited)
                .map(String::new)
                .collect(Collectors.joining("\n"));
    }
}
