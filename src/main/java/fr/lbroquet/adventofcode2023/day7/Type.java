package fr.lbroquet.adventofcode2023.day7;

import java.util.List;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public enum Type {
    HighCard,
    OnePair,
    TwoPairs,
    ThreeOfAKind,
    FullHouse,
    FourOfAKind,
    FiveOfAKind;

    public static Type of(String cards) {
        List<Long> sortedCardCount = cards.chars().boxed()
                .collect(groupingBy(identity(), counting()))
                .values()
                .stream()
                .sorted()
                .toList();
        if (sortedCardCount.equals(List.of(5L))) return FiveOfAKind;
        if (sortedCardCount.equals(List.of(1L, 4L))) return FourOfAKind;
        if (sortedCardCount.equals(List.of(2L, 3L))) return FullHouse;
        if (sortedCardCount.equals(List.of(1L, 1L, 3L))) return ThreeOfAKind;
        if (sortedCardCount.equals(List.of(1L, 2L, 2L))) return TwoPairs;
        if (sortedCardCount.equals(List.of(1L, 1L, 1L, 2L))) return OnePair;
        return HighCard;
    }
}
