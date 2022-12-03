package fr.lbroquet.adventofcode2016.day7;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

class Sequence {

    private final String sequence;

    Sequence(String sequence) {
        this.sequence = sequence;
    }

    public boolean hasAutonomousBridgeBypassAnnotation() {
        for (int i = 0; i < sequence.length() - 3; i++) {
            if (sequence.charAt(i) == sequence.charAt(i + 3)
                    && sequence.charAt(i) != sequence.charAt(i + 1)
                    && sequence.charAt(i + 1) == sequence.charAt(i + 2)) {
                return true;
            }
        }
        return false;
    }

    public Set<String> findAreaBroadcastAccessors() {
        Set<String> abas = new HashSet<>();
        for (int i = 0; i < sequence.length() - 2; i++) {
            if (sequence.charAt(i) == sequence.charAt(i + 2)
                    && sequence.charAt(i) != sequence.charAt(i + 1)) {
                abas.add(new String(sequence.toCharArray(), i, 3));
            }
        }
        return abas;
    }

    public boolean hasAnyByteAllocationBlock(Collection<String> abas) {
        return abas.stream()
                .map(Sequence::toBAB)
                .anyMatch(sequence::contains);
    }

    private static String toBAB(String aba) {
        StringBuilder builder = new StringBuilder(3);
        builder.append(aba.charAt(1)).append(aba.charAt(0)).append(aba.charAt(1));
        return builder.toString();
    }
}
