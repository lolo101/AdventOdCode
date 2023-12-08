package fr.lbroquet.adventofcode2023.day7;

import fr.lbroquet.Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader input = Input.load(Main.class)) {
            List<Hand> hands = input.lines().map(Main::toHand).sorted().toList();
            long totalWinnings = 0;
            for (int rank = 1; rank <= hands.size(); rank++) {
                Hand hand = hands.get(rank - 1);
                totalWinnings += rank * hand.bid();
            }
            System.out.printf("Total winnings: %d%n", totalWinnings);
        }
    }

    private static Hand toHand(String line) {
        String[] elements = line.split(" ");
        String cards = elements[0];
        long bid = Long.parseLong(elements[1]);
        return new Hand(cards, bid);
    }
}
