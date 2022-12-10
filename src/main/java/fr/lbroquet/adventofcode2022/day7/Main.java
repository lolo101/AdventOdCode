package fr.lbroquet.adventofcode2022.day7;

import fr.lbroquet.Input;

public class Main {
    public static void main(String[] args) {
        DirectoryHierarchy hierarchy = Input.load(Main.class).lines()
                .collect(
                        DirectoryHierarchy::new,
                        DirectoryHierarchy::run,
                        DirectoryHierarchy::merge);
        int sum = hierarchy.root.scanDirectoriesDepthFirst()
                .mapToInt(Directory::size)
                .filter(size -> size <= 100_000)
                .sum();

        System.out.printf("Total size: %d%n", hierarchy.root.size());
        System.out.printf("Sum of size of directories of size lte 100 000: %d%n", sum);
    }
}
