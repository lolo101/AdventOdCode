package fr.lbroquet.adventofcode2022.day11;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Operation {
    private static final Pattern OPERATION_DETAILS_PATTERN = Pattern.compile("old (?<operator>[+*]) (?<operand>old|\\d+)");
    private final Operator operator;
    private final Operand operand;

    public Operation(String operation) {
        Matcher matcher = OPERATION_DETAILS_PATTERN.matcher(operation);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(operation);
        }
        operator = Operator.of(matcher.group("operator"));
        operand = new Operand(matcher.group("operand"));
    }

    public WorryLevel operate(WorryLevel item, int divisorsProduct) {
        return operator.apply(item, operand.old(item), divisorsProduct);
    }

    @Override
    public String toString() {
        return operator + " by " + operand;
    }
}
