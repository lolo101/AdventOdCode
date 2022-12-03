package fr.lbroquet.adventofcode2016.day10;

import java.util.SortedSet;
import java.util.TreeSet;
import java.util.function.Consumer;

class Bot implements Consumer<Integer> {

    private final String id;

    private Consumer<Integer> high, low;

    private final SortedSet<Integer> values = new TreeSet<>();

    Bot(String id) {
        this.id = id;
    }

    @Override
    public void accept(Integer value) {
        values.add(value);
        checkRun();
    }

    public void setHigh(Consumer<Integer> high) {
        this.high = high;
        checkRun();
    }

    public void setLow(Consumer<Integer> low) {
        this.low = low;
        checkRun();
    }

    private void checkRun() {
        if (checkCondition()) {
            checkWin();
            run();
        }
    }

    private boolean checkCondition() {
        return values.size() == 2 && low != null && high != null;
    }

    private void checkWin() {
        int lower = values.first();
        int higher = values.last();
        if (lower == 17 && higher == 61) {
            System.out.println("Bot #" + id + " wins !");
        }
    }

    private void run() {
        low.accept(values.first());
        high.accept(values.last());
        values.clear();
    }
}
