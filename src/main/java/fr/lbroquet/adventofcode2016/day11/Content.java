package fr.lbroquet.adventofcode2016.day11;

import java.util.regex.MatchResult;
import java.util.regex.Pattern;
//import java.util.stream.Stream;

public class Content {
    private static final Pattern CONTENT_PATTERN = Pattern.compile("(?: and)? a (?<material>\\w+)(?<part> generator|-compatible microchip),?");

//    public static Stream<Content> asStream(String content) {
//        if (content == null) {
//            return Stream.empty();
//        }
//        return CONTENT_PATTERN.matcher(content).results().map(Content::map);
//    }

    private static Content map(MatchResult result) {
        String material = result.group(1);
        String part = result.group(2);
        return new Content(Part.from(part), material);
    }

    private Content(Part from, String material) {
    }
}
