package fr.unilim;

public class Rover {
    private Position position;
    private Orientation orientation;

    public Rover() {
        this.position = new Position(0, 0);
        this.orientation = Orientation.NORTH;
    }

    public Rover(int x, int y) {
        this.position = new Position(x, y);
        this.orientation = Orientation.NORTH;
    }

    public Rover(int x, int y, Orientation orientation) {
        this.position = new Position(x, y);
        this.orientation = orientation;
    }

    public Rover(Position position, Orientation orientation) {
        this.position = position;
        this.orientation = orientation;
    }

    public void forward() {
        switch (orientation) {
            case NORTH -> position = position.moveNorth();
            case EAST -> position = position.moveEast();
            case SOUTH -> position = position.moveSouth();
            case WEST -> position = position.moveWest();
        }
    }

    public void backward() {
        switch (orientation) {
            case NORTH -> position = position.moveSouth();
            case EAST -> position = position.moveWest();
            case SOUTH -> position = position.moveNorth();
            case WEST -> position = position.moveEast();
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

    public Position position() {
        return position;
    }

    public Orientation orientation() {
        return orientation;
    }
}
