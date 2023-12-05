package fr.lbroquet.adventofcode2023.day4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Card {
    private final String[] winningNumbers;
    private final String[] havingNumbers;
    private long copies = 1;

    public Card(String[] winningNumbers, String[] havingNumbers) {
        this.winningNumbers = winningNumbers;
        this.havingNumbers = havingNumbers;
    }

    public long points() {
        long havingWinningNumbers = wins();
        return havingWinningNumbers == 0 ? 0 : (long) Math.pow(2, havingWinningNumbers - 1);
    }

    public long copies() {
        return copies;
    }

    public void copy(long times) {
        copies += times;
    }

    public long wins() {
        List<String> winnings = Arrays.asList(winningNumbers);
        return Stream.of(havingNumbers).filter(winnings::contains).count();
    }
}
