package fr.lbroquet.adventofcode2016.day3;

public class Triangle {

    private final int longestSide;
    private final int sumOfTwoOtherSides;

    public Triangle(String desc) {
        this(desc.trim().split("\\s+"));
    }

    Triangle(String[] sideString) throws NumberFormatException {
        int[] side = new int[3];
        side[0] = Integer.parseInt(sideString[0]);
        side[1] = Integer.parseInt(sideString[1]);
        side[2] = Integer.parseInt(sideString[2]);
        int longestSideIndex = side[0] > side[1] ? (side[0] > side[2] ? 0 : 2) : (side[1] > side [2] ? 1 : 2);
        longestSide = side[longestSideIndex];
        sumOfTwoOtherSides = sumTwoOtherSide(longestSideIndex, side);
    }

    public boolean isPossible() {
        return longestSide < sumOfTwoOtherSides;
    }

    private int sumTwoOtherSide(int longestSideIndex, int[] side) {
        switch (longestSideIndex) {
            case 0: return side[1] + side[2];
            case 1: return side[0] + side[2];
            case 2: return side[0] + side[1];
            default: throw new IllegalArgumentException("Invalid side number: " + longestSideIndex);
        }
    }
}
