package fr.lbroquet.adventofcode2016.day7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    private static BufferedReader loadInput() {
        InputStream inputStream = Main.class.getResourceAsStream("input");
        return new BufferedReader(new InputStreamReader(inputStream));
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = loadInput()) {
            List<IPv7> ips = reader.lines().map(IPv7::new).collect(Collectors.toList());
            System.out.println("Nb of IPv7 supporting TLS: " + ips.stream()
                    .filter(IPv7::doesSupportTransportLayerSnooping)
                    .count());
            System.out.println("Nb of IPv7 supporting SSL: " + ips.stream()
                    .filter(IPv7::doesSupportSuperSecretListening)
                    .count());
        }
    }
}
