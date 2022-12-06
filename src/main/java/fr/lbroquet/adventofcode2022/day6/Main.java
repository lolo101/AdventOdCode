package fr.lbroquet.adventofcode2022.day6;

import fr.lbroquet.Input;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String stream = Input.load(Main.class).readLine();

        Protocol protocol = new Protocol(stream);

        System.out.println(protocol.startOfPacket());
    }
}
