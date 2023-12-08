package fr.lbroquet.adventofcode2023.day8;

import fr.lbroquet.Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
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

            List<Long> steps = NETWORK.keySet().stream().filter(Node::isDeparture).map(node -> walk(node, leftRights)).toList();
            System.out.printf("Steps: %s%n", steps);
            long stepsToSync = steps.stream().reduce(1L, Main::synchronize);
            System.out.printf("Steps needed to reach arrivals at the same time: %s%n", stepsToSync);
        }
    }

    private static long synchronize(long steps1, long steps2) {
        return (steps1 * steps2) / gcd(steps1, steps2);
    }

    /*
     * Euclidean algorithm
     * Shamelessly copy-pasted from https://stackoverflow.com/a/4009247/4296029
     */
    private static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    private static long walk(Node node, String leftRights) {
        long steps = 0;
        for (int leftRightsIndex = 0; !node.isArrival(); leftRightsIndex = (leftRightsIndex + 1) % leftRights.length()) {
            char direction = leftRights.charAt(leftRightsIndex);
            Neighborhood neighborhood = NETWORK.get(node);
            node = step(neighborhood, direction);
            steps++;
        }
        return steps;
    }

    private static Node step(Neighborhood neighborhood, char direction) {
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
