package fr.lbroquet.adventofcode2022.day10;

import fr.lbroquet.Input;

public class Main {
    public static void main(String[] args) {
        CPU cpu = Input.load(Main.class)
                .lines()
                .map(Instruction::of)
                .reduce(
                        new CPU(),
                        CPU::execute,
                        ((cpu1, cpu2) -> cpu1)
                );
        System.out.println(cpu.signalStrengths().stream().reduce(0, Integer::sum));
    }
}
