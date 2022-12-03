package fr.lbroquet.adventofcode2016.day10;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

enum AcceptorType {
    bot(AcceptorType::bot),
    output(AcceptorType::output);

    private static final Map<String, Bot> bots = new HashMap<>();
    private final Function<String, Consumer<Integer>> function;

    private AcceptorType(Function<String, Consumer<Integer>> function) {
        this.function = function;
    }

    public Consumer<Integer> get(String id) {
        return function.apply(id);
    }

    private static Bot bot(String id) {
        Bot bot = bots.get(id);
        if (bot == null) {
            bot = new Bot(id);
            bots.put(id, bot);
        }
        return bot;
    }

    private static Consumer<Integer> output(String id) {
        return value -> System.out.println("Output " + id + " get value " + value);
    }
}
