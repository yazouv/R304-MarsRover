package fr.unilim.commands;

import fr.unilim.Command;
import fr.unilim.Grid;
import fr.unilim.Position;
import fr.unilim.Rover;

public record ForwardCommand(Rover rover, Grid grid) implements Command {

    @Override
    public void execute() {
        Position nextPosition = getNextPosition();
        if (grid.isValidMove(nextPosition)) {
            rover.forward();
        }
    }

    private Position getNextPosition() {
        return switch (rover.orientation()) {
            case NORTH -> rover.position().moveNorth();
            case EAST -> rover.position().moveEast();
            case SOUTH -> rover.position().moveSouth();
            case WEST -> rover.position().moveWest();
        };
    }
}
