package fr.lbroquet.adventofcode2016.day2;

class KeySquare extends Key {

    private int key = 5;

    @Override
    public void show() {
        System.out.println(key);
    }

    @Override
    protected void moveUp() {
        if (key > 3) {
            key -= 3;
        }
    }

    @Override
    protected void moveDown() {
        if (key < 7) {
            key += 3;
        }
    }

    @Override
    protected void moveRight() {
        if (key % 3 != 0) {
            key += 1;
        }
    }

    @Override
    protected void moveLeft() {
        if (key % 3 != 1) {
            key -= 1;
        }
    }
}
