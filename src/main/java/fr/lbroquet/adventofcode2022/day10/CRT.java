package fr.lbroquet.adventofcode2022.day10;

import java.util.Arrays;

import static java.lang.Math.abs;

public class CRT {
    private static final int HEIGHT = 6;
    private static final int WIDTH = 40;
    private final char[] screen = new char[HEIGHT * WIDTH];
    private final CPU cpu;

    public CRT(CPU cpu) {
        this.cpu = cpu;
        Arrays.fill(screen, ' ');
    }

    public String print() {
        displaySprite();
        return printScreen();
    }

    private void displaySprite() {
        for (int cycle = 0; cycle < cpu.registerValueAtCycle.size(); cycle++) {
            int spriteCenter = cpu.registerValueAtCycle.get(cycle);
            int crtColumn = cycle % WIDTH;
            if (spriteVisible(spriteCenter, crtColumn)) {
                screen[cycle] = '█';
            }
        }
    }

    private static boolean spriteVisible(int spriteCenter, int column) {
        return abs(spriteCenter - column) <= 1;
    }

    private String printScreen() {
        StringBuilder builder = new StringBuilder();
        for (int row = 0; row < HEIGHT; row++) {
            String line = new String(
                    Arrays.copyOfRange(
                            screen,
                            WIDTH * row,
                            WIDTH * (row + 1)
                    )
            );
            builder.append(line).append('\n');
        }
        return builder.toString();
    }
}
