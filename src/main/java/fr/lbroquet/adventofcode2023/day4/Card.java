package fr.lbroquet.adventofcode2023.day4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Card {
    private final String[] winningNumbers;
    private final String[] havingNumbers;

    public Card(String[] winningNumbers, String[] havingNumbers) {
        this.winningNumbers = winningNumbers;
        this.havingNumbers = havingNumbers;
    }

    public long points() {
        List<String> winnings = Arrays.asList(winningNumbers);
        long havingWinningNumbers = Stream.of(havingNumbers).filter(winnings::contains).count();
        return havingWinningNumbers == 0 ? 0 : (long) Math.pow(2, havingWinningNumbers - 1);
    }
}
