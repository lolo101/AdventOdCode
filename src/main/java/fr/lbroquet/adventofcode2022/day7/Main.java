package fr.lbroquet.adventofcode2022.day7;

import fr.lbroquet.Input;

public class Main {
    public static void main(String[] args) {
        DirectoryHierarchy hierarchy = Input.load(Main.class).lines()
                .collect(
                        DirectoryHierarchy::new,
                        DirectoryHierarchy::run,
                        DirectoryHierarchy::merge);
        System.out.printf("Total size: %d", hierarchy.root.size());
    }
}
