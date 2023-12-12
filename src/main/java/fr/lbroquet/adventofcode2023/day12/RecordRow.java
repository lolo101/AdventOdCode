package fr.lbroquet.adventofcode2023.day12;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.SequencedCollection;

public class RecordRow {
    private final String conditions;
    private final String[] contiguousGroups;

    public RecordRow(String conditions, String[] contiguousGroups) {
        this.conditions = conditions;
        this.contiguousGroups = contiguousGroups;
    }

    public long arrangements() {
        SequencedCollection<String> chunks = new LinkedList<>(Arrays.asList(conditions.split("\\.")));
        SequencedCollection<String> groups = new LinkedList<>(Arrays.asList(contiguousGroups));

        long arrangements = 1;
        for (String group : groups) {
            arrangements *= arrangement(chunks.removeFirst(), Long.parseLong(group));
        }
        return arrangements;
    }

    private static long arrangement(String chunk, long contiguous) {
        if (chunk.length() < contiguous) {
            return 0;
        }
        if (chunk.length() == contiguous) {
            return 1;
        }
        if (chunk.startsWith("?")) {
            return 1 + arrangement(chunk.substring(1), contiguous);
        }
        return 1;
    }
}
