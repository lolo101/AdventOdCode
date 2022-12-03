package fr.lbroquet.adventofcode2016.day3;

public class TriTriangle {

    private final Triangle triangle1;
    private final Triangle triangle2;
    private final Triangle triangle3;

    public TriTriangle(String spec) {
        String[] specs = spec.trim().split("\\s+");
        triangle1 = new Triangle(new String[] {specs[0], specs[3], specs[6]});
        triangle2 = new Triangle(new String[] {specs[1], specs[4], specs[7]});
        triangle3 = new Triangle(new String[] {specs[2], specs[5], specs[8]});
    }

    public int countPossibles() {
        int count = 0;
        count = incIfPossible(count, triangle1);
        count = incIfPossible(count, triangle2);
        count = incIfPossible(count, triangle3);
        return count;
    }

    private int incIfPossible(int count, Triangle triangle) {
        return triangle.isPossible() ? count + 1 : count;
    }
}
