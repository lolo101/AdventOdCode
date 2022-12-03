package fr.lbroquet.adventofcode2016.day10;

import java.util.regex.Matcher;

class Command {

    private final CommandType type;
    private final Matcher matcher;

    private Command(CommandType type, Matcher matcher) {
        this.matcher = matcher;
        this.type = type;
    }

    public static Command map(String instruction) {
        for (CommandType type : CommandType.values()) {
            Matcher matcher = type.matcher(instruction);
            if (matcher.matches()) {
                return new Command(type, matcher);
            }
        }
        throw new IllegalArgumentException(instruction);
    }

    public void process() {
        type.process(getBot(), matcher);
    }

    private Bot getBot() {
        return (Bot) AcceptorType.bot.get(matcher.group("bot"));
    }
}
