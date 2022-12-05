package fr.lbroquet.adventofcode2022.day5;

import fr.lbroquet.Input;

import java.util.List;

import static java.util.stream.Collectors.joining;

public class Main {

    /* Initial stacks:
        [B]             [B] [S]
        [M]             [P] [L] [B] [J]
        [D]     [R]     [V] [D] [Q] [D]
        [T] [R] [Z]     [H] [H] [G] [C]
        [P] [W] [J] [B] [J] [F] [J] [S]
    [N] [S] [Z] [V] [M] [N] [Z] [F] [M]
    [W] [Z] [H] [D] [H] [G] [Q] [S] [W]
    [B] [L] [Q] [W] [S] [L] [J] [W] [Z]
     1   2   3   4   5   6   7   8   9
    */
    private static final List<StackOfCrates> stacks = List.of(
            new StackOfCrates("BWN"),
            new StackOfCrates("LZSPTDMB"),
            new StackOfCrates("QHZWR"),
            new StackOfCrates("WDVJZR"),
            new StackOfCrates("SHMB"),
            new StackOfCrates("LGNJHVPB"),
            new StackOfCrates("JQZFHDLS"),
            new StackOfCrates("WSFJGQB"),
            new StackOfCrates("ZWMSCDJ")
    );

    public static void main(String[] args) {
        Input.load(Main.class)
                .lines()
                .map(Instruction::of)
                .forEach(instruction -> instruction.apply(stacks));

        String topCrates = stacks.stream()
                .map(StackOfCrates::topCrate)
                .map(Crate::toString)
                .collect(joining());

        System.out.println(topCrates);
    }
}
