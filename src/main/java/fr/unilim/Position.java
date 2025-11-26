package fr.unilim;

public record Position(int x, int y) {

    private static final int INCREMENT = 1;
    private static final int DECREMENT = -1;

    public Position moveNorth() {
        return new Position(x, y + INCREMENT);
    }

    public Position moveSouth() {
        return new Position(x, y + DECREMENT);
    }

    public Position moveEast() {
        return new Position(x + INCREMENT, y);
    }

    public Position moveWest() {
        return new Position(x + DECREMENT, y);
    }

    @Override
    public String toString() {
        return "Position(" + x + ", " + y + ")";
    }
}