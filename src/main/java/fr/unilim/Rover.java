package fr.unilim;

public class Rover {
    private int x;
    private int y;
    private Orientation orientation;

    public Rover() {
        this.x = 0;
        this.y = 0;
        this.orientation = Orientation.NORTH;
    }

    public Rover(int x, int y) {
        this.x = x;
        this.y = y;
        this.orientation = Orientation.NORTH;
    }

    public Rover(int x, int y, Orientation orientation) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }

    public void forward() {
        switch (orientation) {
            case NORTH -> y++;
            case EAST -> x++;
            case SOUTH -> y--;
            case WEST -> x--;
        }
    }

    public void backward() {
        switch (orientation) {
            case NORTH -> y--;
            case EAST -> x--;
            case SOUTH -> y++;
            case WEST -> x++;
        }
    }

    public void turnLeft() {
        switch (orientation) {
            case NORTH -> this.orientation = Orientation.WEST;
            case EAST -> this.orientation = Orientation.NORTH;
            case SOUTH -> this.orientation = Orientation.EAST;
            case WEST -> this.orientation = Orientation.SOUTH;
        }
    }
    public void turnRight() {
        switch (orientation) {
            case NORTH -> this.orientation = Orientation.EAST;
            case EAST -> this.orientation = Orientation.SOUTH;
            case SOUTH -> this.orientation = Orientation.WEST;
            case WEST -> this.orientation = Orientation.NORTH;
        }
    }

    public void position() {
        System.out.println("X: " + this.x + " Y: " + this.y);
    }

    public void orientation() {
        System.out.println("Orientation: " + this.orientation);
    }
}
