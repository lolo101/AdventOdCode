package fr.lbroquet.adventofcode2016.day2;

public abstract class Key {

    public void moveTo(char c) {
        switch (c) {
            case 'U': moveUp(); break;
            case 'D': moveDown(); break;
            case 'R': moveRight(); break;
            case 'L': moveLeft(); break;
            default: throw new IllegalArgumentException("Expected one of U, D, R, L and got : " + c);
        }
    }

    protected abstract void moveUp();
    protected abstract void moveDown();
    protected abstract void moveRight();
    protected abstract void moveLeft();
    public abstract void show();
}
