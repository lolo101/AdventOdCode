package fr.lbroquet.adventofcode2023.day9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sequence {
    private final long[] values;

    public Sequence(long[] values) {
        this.values = values;
    }

    public long extrapolateForward() {
        long extrapolation = 0;
        for (long[] toto : derivationOrders().reversed()) {
            extrapolation = toto[toto.length - 1] + extrapolation;
        }
        return extrapolation;
    }

    public long extrapolateBackward() {
        long extrapolation = 0;
        for (long[] toto : derivationOrders().reversed()) {
            extrapolation = toto[0] - extrapolation;
        }
        return extrapolation;
    }

    private List<long[]> derivationOrders() {
        List<long[]> derivationOrders = new ArrayList<>();
        for (long[] derivate = values; Arrays.stream(derivate).anyMatch(value -> value != 0); derivate = derive(derivate)) {
            derivationOrders.add(derivate);
        }
        return derivationOrders;
    }

    private static long[] derive(long[] values) {
        long[] dervate = new long[values.length - 1];
        for (int valueIndex = 1; valueIndex < values.length; valueIndex++) {
            dervate[valueIndex - 1] = values[valueIndex] - values[valueIndex - 1];
        }
        return dervate;
    }
}
