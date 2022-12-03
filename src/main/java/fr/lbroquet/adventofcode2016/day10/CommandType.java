package fr.lbroquet.adventofcode2016.day10;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

enum CommandType {
    giveValue(Pattern.compile("value (?<value>\\d+) goes to bot (?<bot>\\d+)"), CommandType::processGiveValue),
    buildGraph(Pattern.compile("bot (?<bot>\\d+) gives low to (?<lowType>bot|output) (?<low>\\d+) and high to (?<highType>bot|output) (?<high>\\d+)"), CommandType::processBuildGraph);

    private final Pattern pattern;
    private final BiConsumer<Bot, Matcher> consumer;

    private CommandType(Pattern pattern, BiConsumer<Bot, Matcher> consumer) {
        this.pattern = pattern;
        this.consumer = consumer;
    }

    public Matcher matcher(String instruction) {
        return pattern.matcher(instruction);
    }

    void process(Bot bot, Matcher matcher) {
        consumer.accept(bot, matcher);
    }

    private static void processGiveValue(Bot bot, Matcher matcher) {
        int value = Integer.parseInt(matcher.group("value"));
        bot.accept(value);
    }

    private static void processBuildGraph(Bot bot, Matcher matcher) {
        Consumer<Integer> low = AcceptorType.valueOf(matcher.group("lowType")).get(matcher.group("low"));
        Consumer<Integer> high = AcceptorType.valueOf(matcher.group("highType")).get(matcher.group("high"));
        bot.setLow(low);
        bot.setHigh(high);
    }
}
