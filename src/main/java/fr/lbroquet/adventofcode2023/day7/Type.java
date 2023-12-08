package fr.lbroquet.adventofcode2023.day7;

import java.util.*;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.*;

public enum Type {
    HighCard,
    OnePair,
    TwoPairs,
    ThreeOfAKind,
    FullHouse,
    FourOfAKind,
    FiveOfAKind;

    public static Type of(String cards) {
        Map<Integer, Long> countByCard = cards.chars().boxed()
                .collect(groupingBy(identity(), HashMap::new, counting()));
        Long jokerCount = countByCard.remove(Integer.valueOf('J'));
        SequencedCollection<Long> sortedCardCount = countByCard
                .values()
                .stream()
                .sorted()
                .collect(toCollection(ArrayList::new));
        if (jokerCount != null) {
            Long highestCount = sortedCardCount.isEmpty() ? 0L : sortedCardCount.removeLast();
            sortedCardCount.addLast(highestCount + jokerCount);
        }
        if (sortedCardCount.equals(List.of(5L))) return FiveOfAKind;
        if (sortedCardCount.equals(List.of(1L, 4L))) return FourOfAKind;
        if (sortedCardCount.equals(List.of(2L, 3L))) return FullHouse;
        if (sortedCardCount.equals(List.of(1L, 1L, 3L))) return ThreeOfAKind;
        if (sortedCardCount.equals(List.of(1L, 2L, 2L))) return TwoPairs;
        if (sortedCardCount.equals(List.of(1L, 1L, 1L, 2L))) return OnePair;
        return HighCard;
    }
}
