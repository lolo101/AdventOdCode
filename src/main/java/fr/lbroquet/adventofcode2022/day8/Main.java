package fr.lbroquet.adventofcode2022.day8;

import fr.lbroquet.Input;

public class Main {
    public static void main(String[] args) {
        Forest forest = Input.load(Main.class)
                .lines()
                .map(Main::toTrees)
                .collect(
                        Forest::new,
                        Forest::add,
                        Forest::merge);

        System.out.println(forest.countVisibleTrees());
        System.out.println(forest.highestScenicScore());
        System.out.println(forest.printVisibleTrees());
    }

    private static Tree[] toTrees(String line) {
        return line.chars()
                .map(ch -> ch - '0')
                .mapToObj(Tree::new)
                .toArray(Tree[]::new);
    }
}
