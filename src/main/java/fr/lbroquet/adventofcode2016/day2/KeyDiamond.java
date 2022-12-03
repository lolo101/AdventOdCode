package fr.lbroquet.adventofcode2016.day2;

class KeyDiamond extends Key {

    private final char[] KEYS = {
        ' ', ' ', '1', ' ', ' ',
        ' ', '2', '3', '4', ' ',
        '5', '6', '7', '8', '9',
        ' ', 'A', 'B', 'C', ' ',
        ' ', ' ', 'D', ' ', ' '
    };

    private int index = 10;

    @Override
    public void show() {
        System.out.println(KEYS[index]);
    }

    @Override
    protected void moveUp() {
        tryNextIndex(index - 5);
    }

    @Override
    protected void moveDown() {
        tryNextIndex(index + 5);
    }

    @Override
    protected void moveRight() {
        if (index % 5 != 4) {
            tryNextIndex(index + 1);
        }
    }

    @Override
    protected void moveLeft() {
        if (index % 5 != 0) {
            tryNextIndex(index - 1);
        }
    }

    private void tryNextIndex(int nextIndex) {
        if (nextIndex >= 0 && nextIndex < KEYS.length && KEYS[nextIndex] != ' ') {
            index = nextIndex;
        }
    }
}
