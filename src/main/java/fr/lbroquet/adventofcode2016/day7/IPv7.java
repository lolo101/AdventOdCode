package fr.lbroquet.adventofcode2016.day7;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class IPv7 {

    private static final Pattern SUPERNET_SEQUENCE = Pattern.compile("(?:^|\\])(\\w+)(?:\\[|$)");
    private static final Pattern HYPERNET_SEQUENCE = Pattern.compile("\\[(\\w+)\\]");
    private final List<Sequence> supernetSequences;
    private final List<Sequence> hypernetSequences;

    public IPv7(String spec) {
        supernetSequences = find(SUPERNET_SEQUENCE, spec);
        hypernetSequences = find(HYPERNET_SEQUENCE, spec);
    }

    private List<Sequence> find(Pattern pattern, String spec) {
        List<Sequence> sequences = new ArrayList<>();
        for (Matcher sequenceMatcher = pattern.matcher(spec); sequenceMatcher.find();) {
            String sequence = sequenceMatcher.group(1);
            sequences.add(new Sequence(sequence));
        }
        return sequences;
    }

    public boolean doesSupportTransportLayerSnooping() {
        return !hypernetSequences.stream().anyMatch(Sequence::hasAutonomousBridgeBypassAnnotation)
                && supernetSequences.stream().anyMatch(Sequence::hasAutonomousBridgeBypassAnnotation);
    }

    public boolean doesSupportSuperSecretListening() {
        Set<String> abas = hypernetSequences.stream()
                .map(Sequence::findAreaBroadcastAccessors)
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
        return supernetSequences.stream().anyMatch(s -> s.hasAnyByteAllocationBlock(abas));
    }
}
