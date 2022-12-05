package fr.lbroquet.adventofcode2022.day5;

import java.util.Stack;

import static java.util.stream.Collectors.toCollection;

public class StackOfCrates {

    private final Stack<Crate> stack;

    public StackOfCrates(String bottomToTop) {
        stack = bottomToTop.chars()
                .mapToObj(Crate::new)
                .collect(toCollection(Stack::new));
    }

    @Override
    public String toString() {
        return stack.toString();
    }

    public Crate topCrate() {
        return stack.peek();
    }

    public void transferTo(StackOfCrates destination, int quantity) {
        for (int number = 0; number < quantity; number++) {
            destination.stack.push(stack.pop());
        }
    }
}
