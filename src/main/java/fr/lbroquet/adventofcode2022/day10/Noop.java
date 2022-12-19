package fr.lbroquet.adventofcode2022.day10;

import java.util.List;

public final class Noop extends Instruction {
    @Override
    public void execute(List<Integer> registerValueAtCycle) {
        int registerCurrentValue = getRegisterCurrentValue(registerValueAtCycle);
        registerValueAtCycle.add(registerCurrentValue);
    }
}
