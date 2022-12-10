package fr.lbroquet.adventofcode2022.day7;

import fr.lbroquet.Input;

public class Main {
    private static final int DISK_SPACE = 70_000_000;
    private static final int REQUIRED_SPACE = 30_000_000;

    public static void main(String[] args) {
        DirectoryHierarchy hierarchy = Input.load(Main.class).lines()
                .collect(
                        DirectoryHierarchy::new,
                        DirectoryHierarchy::run,
                        DirectoryHierarchy::merge);
        int sizeToReclaim = REQUIRED_SPACE - DISK_SPACE + hierarchy.root.size();
        int sizeOfDirectoryToDelete = hierarchy.root.scanDirectoriesDepthFirst()
                .mapToInt(Directory::size)
                .filter(size -> size >= sizeToReclaim)
                .min()
                .orElseThrow();

        System.out.printf("Total size: %d%n", hierarchy.root.size());
        System.out.printf("Size to recover: %d%n", sizeToReclaim);
        System.out.printf("Size of smallest directory to delete: %d%n", sizeOfDirectoryToDelete);
    }
}
