package fr.lbroquet.adventofcode2023.day12;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class RecordRow {
    private final String conditions;
    private final String[] contiguousGroups;

    public RecordRow(String conditions, String[] contiguousGroups) {
        this.conditions = conditions;
        this.contiguousGroups = contiguousGroups;
    }

    public long arrangements() {
        List<String> chunks = new LinkedList<>(Arrays.asList(conditions.split("\\.")));
        List<Integer> groups = new LinkedList<>(Stream.of(contiguousGroups).mapToInt(Integer::parseInt).boxed().toList());

        return arrangements(chunks, groups);
    }

    private static long arrangements(List<String> chunks, List<Integer> contiguousGroups) {
        if (chunks.isEmpty()) {
            return contiguousGroups.isEmpty() ? 1 : 0;
        }
        if (contiguousGroups.isEmpty()) {
            return chunks.stream().noneMatch(chunk -> chunk.contains("#")) ? 1 : 0;
        }

        String chunk = chunks.getFirst();
        int contiguous = contiguousGroups.getFirst();

        if (chunk.length() < contiguous) {
            if (chunk.contains("#")) return 0;
            return arrangements(chunks, tail(contiguousGroups));
        }
        if (chunk.length() == contiguous) {
            return arrangements(tail(chunks), tail(contiguousGroups));
        }
        if (chunk.startsWith("?")) {
            return arrangements(replaceHead(chunk.substring(1), tail(chunks)), contiguousGroups)
                    + matchContiguousAndContinue(chunk, contiguous, tail(chunks), tail(contiguousGroups));
        }
        return matchContiguousAndContinue(chunk, contiguous, tail(chunks), tail(contiguousGroups));
    }

    private static long matchContiguousAndContinue(String chunk, int contiguous, List<String> chunksTail, List<Integer> groupsTail) {
        return chunk.charAt(contiguous) == '?'
                ? arrangements(replaceHead(chunk.substring(1 + contiguous), chunksTail), groupsTail)
                : 0;
    }

    private static <T> List<T> tail(List<T> list) {
        return list.subList(1, list.size());
    }

    private static <T> List<T> replaceHead(T head, List<T> tail) {
        List<T> list = new LinkedList<>();
        list.add(head);
        list.addAll(tail);
        return list;
    }
}
