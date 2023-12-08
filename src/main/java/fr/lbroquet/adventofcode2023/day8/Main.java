package fr.lbroquet.adventofcode2023.day8;

import fr.lbroquet.Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.Comparator.comparing;

public class Main {
    private static final Pattern NEIGHBORHOOD_PATTERN = Pattern.compile("(?<node>\\p{Upper}{3}) = \\((?<left>\\p{Upper}{3}), (?<right>\\p{Upper}{3})\\)");
    private static final SortedMap<Node, Neighborhood> NETWORK = new TreeMap<>(comparing(Node::name));

    public static void main(String[] args) throws IOException {
        try (BufferedReader input = Input.load(Main.class)) {
            String leftRights = input.readLine();
            input.readLine();
            input.lines().forEach(Main::addToNetwork);

            Node currentNode = new Node("AAA");
            Node destination = new Node("ZZZ");
            long step = 0;
            for (int leftRightsIndex = 0; !currentNode.equals(destination); leftRightsIndex = (leftRightsIndex + 1) % leftRights.length()) {
                char direction = leftRights.charAt(leftRightsIndex);
                Neighborhood neighborhood = NETWORK.get(currentNode);
                currentNode = move(direction, neighborhood);
                step++;
            }
            System.out.printf("Steps: %d%n", step);
        }
    }

    private static Node move(char direction, Neighborhood neighborhood) {
        if (direction == 'L') return neighborhood.left();
        if (direction == 'R') return neighborhood.right();
        throw new IllegalArgumentException(String.valueOf(direction));
    }

    private static void addToNetwork(String line) {
        Matcher matcher = NEIGHBORHOOD_PATTERN.matcher(line);
        if (matcher.matches()) {
            Node node = new Node(matcher.group("node"));
            Node left = new Node(matcher.group("left"));
            Node right = new Node(matcher.group("right"));
            NETWORK.put(node, new Neighborhood(left, right));
        } else {
            throw new IllegalArgumentException(line);
        }
    }
}
