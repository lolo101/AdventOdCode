package fr.lbroquet.adventofcode2022.day11;

public class Operand {
    private final String operand;

    public Operand(String operand) {
        this.operand = operand;
    }

    public int old(Item item) {
        return operand.equals("old") ? item.worryLevel() : Integer.parseInt(operand);
    }

    @Override
    public String toString() {
        return operand.equals("old") ? "itself" : operand;
    }
}
