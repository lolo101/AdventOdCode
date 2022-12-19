package fr.lbroquet.adventofcode2022.day10;

import java.util.List;

public sealed abstract class Instruction permits Noop, Addx {

    public static Instruction of(String line) {
        if (line.equals("noop")) return new Noop();
        return new Addx(Integer.parseInt(line.substring(5)));
    }

    protected static int getRegisterCurrentValue(List<Integer> registerValueAtCycle) {
        return registerValueAtCycle.get(registerValueAtCycle.size() - 1);
    }

    public abstract void execute(List<Integer> registerValueAtCycle);
}
