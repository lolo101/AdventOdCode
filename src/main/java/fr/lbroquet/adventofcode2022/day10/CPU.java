package fr.lbroquet.adventofcode2022.day10;

import java.util.ArrayList;
import java.util.List;

public class CPU {
    private final List<Integer> registerValueAtCycle = new ArrayList<>();

    public CPU() {
        registerValueAtCycle.add(1);
    }

    public CPU execute(Instruction instruction) {
        instruction.execute(registerValueAtCycle);
        return this;
    }

    public List<Integer> signalStrengths() {
        return List.of(
                signalStrength(20),
                signalStrength(60),
                signalStrength(100),
                signalStrength(140),
                signalStrength(180),
                signalStrength(220)
        );
    }

    private int signalStrength(int index) {
        return index * registerValueAtCycle.get(index - 1);
    }
}
