package fr.lbroquet.adventofcode2018.day1;

import java.util.SortedSet;
import java.util.TreeSet;

class Accumulator {

    private final Iterable<Integer> changes;

    Accumulator(Iterable<Integer> changes) {
        this.changes = changes;
    }

    public int firstDuplicate() {
        SortedSet<Integer> freqs = new TreeSet<>();
        int freq = 0;

        freqs.add(freq);
        for(int loop = 1;; ++loop) {
            System.out.println("Loop #" + loop);
            for (Integer change : changes) {
                freq += change;
                if (!freqs.add(freq)) {
                    return freq;
                }
            }
        }
    }
}
