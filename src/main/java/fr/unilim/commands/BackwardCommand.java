package fr.unilim.commands;

import fr.unilim.Command;
import fr.unilim.Grid;
import fr.unilim.Position;
import fr.unilim.Rover;

public record BackwardCommand(Rover rover, Grid grid) implements Command {

    @Override
    public void execute() {
        Position nextPosition = getNextPosition();
        if (grid.isValidMove(nextPosition)) {
            rover.backward();
        }
    }

    private Position getNextPosition() {
        return switch (rover.orientation()) {
            case NORTH -> rover.position().moveSouth();
            case EAST -> rover.position().moveWest();
            case SOUTH -> rover.position().moveNorth();
            case WEST -> rover.position().moveEast();
        };
    }
}
