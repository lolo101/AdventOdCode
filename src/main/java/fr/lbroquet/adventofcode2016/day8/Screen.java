package fr.lbroquet.adventofcode2016.day8;

class Screen {

    private static final int WIDTH = 50;
    private static final int HEIGHT = 6;
    private static final String ROTATE_COLUMN_PREFIX = "column x=";
    private static final String ROTATE_ROW_PREFIX = "row y=";
    private static final String ROTATE_SEPARATOR = " by ";

    private final boolean[] screen = new boolean[WIDTH * HEIGHT];

    public void addInstr(String instr) {
        int argsIndex = instr.indexOf(' ');
        String command = instr.substring(0, argsIndex);
        switch (command) {
            case "rect":
                handleRect(instr.substring(argsIndex + 1));
                break;
            case "rotate":
                handleRotate(instr.substring(argsIndex + 1));
                break;
        }
    }

    public int countPixelsOn() {
        int count = 0;
        for (boolean p : screen) {
            if (p) {
                ++count;
            }
        }
        return count;
    }

    public String display() {
        StringBuilder builder = new StringBuilder((WIDTH + 1) * HEIGHT);
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                builder.append(screen[WIDTH * y + x] ? '\u2588' : '.');
            }
            builder.append('\n');
        }
        return builder.toString();
    }

    private void handleRect(String args) {
        int xIndex = args.indexOf('x');
        int x = Integer.parseInt(args.substring(0, xIndex));
        int y = Integer.parseInt(args.substring(xIndex + 1));
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                screen[j * WIDTH + i] = true;
            }
        }
    }

    private void handleRotate(String args) {
        int sepIndex = args.indexOf(ROTATE_SEPARATOR);
        int n = Integer.parseInt(args.substring(sepIndex + ROTATE_SEPARATOR.length()));
        boolean[] buffer = new boolean[n];
        if (args.startsWith(ROTATE_COLUMN_PREFIX)) {
            int column = Integer.parseInt(args.substring(ROTATE_COLUMN_PREFIX.length(), sepIndex));
            for (int r = HEIGHT - n, j = 0; r < HEIGHT; r++, j++) {
                buffer[j] = screen[r * WIDTH + column];
            }
            for (int i = 0; i < HEIGHT; i++) {
                boolean cache = screen[i * WIDTH + column];
                screen[i * WIDTH + column] = buffer[i % n];
                buffer[i % n] = cache;
            }
        }
        if (args.startsWith(ROTATE_ROW_PREFIX)) {
            int row = Integer.parseInt(args.substring(ROTATE_ROW_PREFIX.length(), sepIndex));
            int offset = WIDTH * row;
            System.arraycopy(screen, offset + WIDTH - n, buffer, 0, n);
            System.arraycopy(screen, offset, screen, offset + n, WIDTH - n);
            System.arraycopy(buffer, 0, screen, offset, n);
        }
    }
}
