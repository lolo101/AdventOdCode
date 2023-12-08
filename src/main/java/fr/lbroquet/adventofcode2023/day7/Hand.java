package fr.lbroquet.adventofcode2023.day7;

public class Hand implements Comparable<Hand> {
    private static final String STRENGTHS = "23456789TJQKA";
    private final String cards;
    private final long bid;
    private final Type type;

    public Hand(String cards, long bid) {
        this.cards = cards;
        this.bid = bid;
        this.type = Type.of(cards);
    }

    public long bid() {
        return bid;
    }

    @Override
    public int compareTo(Hand o) {
        int typeComparison = type.compareTo(o.type);
        return typeComparison == 0 ? compareCardByCard(o) : typeComparison;
    }

    private int compareCardByCard(Hand o) {
        for (int position = 0; position < 5; position++) {
            int myStrengh = STRENGTHS.indexOf(cards.charAt(position));
            int otherStrengh = STRENGTHS.indexOf(o.cards.charAt(position));
            if (myStrengh > otherStrengh) return 1;
            if (myStrengh < otherStrengh) return -1;
        }
        return 0;
    }
}
