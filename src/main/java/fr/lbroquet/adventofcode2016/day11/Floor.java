package fr.lbroquet.adventofcode2016.day11;

//import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Floor {

    private static final Pattern FLOOR_PATTERN = Pattern.compile("The (?<level>\\w+) floor contains(?: nothing relevant|(?<content>.*)).");

//    public static Floor map(String floor) {
//        Matcher matcher = FLOOR_PATTERN.matcher(floor);
//        if (!matcher.matches()) {
//            throw new IllegalArgumentException(floor);
//        }
//        String level = matcher.group("level");
//        Stream<Content> content = Content.asStream(matcher.group("content"));
//        return new Floor(level, content);
//    }

    public Floor(String level, Stream<Content> content) {
    }
}
