package fr.lbroquet.adventofcode2022.day11;

public class Operand {
    private final String operand;

    public Operand(String operand) {
        this.operand = operand;
    }

    public WorryLevel old(WorryLevel item) {
        return operand.equals("old") ? item : new WorryLevel(operand);
    }

    @Override
    public String toString() {
        return operand.equals("old") ? "itself" : operand;
    }
}
