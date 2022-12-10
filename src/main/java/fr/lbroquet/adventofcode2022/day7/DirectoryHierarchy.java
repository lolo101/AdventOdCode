package fr.lbroquet.adventofcode2022.day7;

public class DirectoryHierarchy {
    public final Directory root = new Directory(new NodeName("/"), null);
    private Directory workingDirectory = root;

    public void run(String listing) {
        if (listing.startsWith("$ ls")) return;
        if (listing.startsWith("$ cd")) {
            String dirName = listing.substring(5);
            workingDirectory = workingDirectory.changeTo(new NodeName(dirName));
        } else
            workingDirectory.add(listing);
    }

    public void merge(DirectoryHierarchy ignored) {}
}
