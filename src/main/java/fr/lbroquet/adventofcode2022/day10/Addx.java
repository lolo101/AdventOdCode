package fr.lbroquet.adventofcode2022.day10;

import java.util.List;

public final class Addx extends Instruction {
    private final int value;

    public Addx(int value) {
        this.value = value;
    }

    @Override
    public void execute(List<Integer> registerValueAtCycle) {
        int registerCurrentValue = getRegisterCurrentValue(registerValueAtCycle);
        registerValueAtCycle.add(registerCurrentValue);
        registerValueAtCycle.add(registerCurrentValue + value);
    }
}
