package fr.lbroquet.adventofcode2022.day5;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

public record Instruction(int source, int destination, int quantity) {
    private static final Pattern INSTRUCTION_PATTERN = Pattern.compile("move (?<quantity>\\d+) from (?<source>\\d+) to (?<destination>\\d+)");

    public static Instruction of(String line) {
        Matcher matcher = INSTRUCTION_PATTERN.matcher(line);
        matcher.matches();
        String source = matcher.group("source");
        String destination = matcher.group("destination");
        String quantity = matcher.group("quantity");
        return new Instruction(
                parseInt(source),
                parseInt(destination),
                parseInt(quantity)
        );
    }

    public void apply(List<StackOfCrates> stacks) {
        StackOfCrates source = stacks.get(this.source - 1);
        StackOfCrates destination = stacks.get(this.destination - 1);
        source.transferTo(destination, quantity);
    }
}
