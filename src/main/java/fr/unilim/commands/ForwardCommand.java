package fr.unilim.commands;

import fr.unilim.Command;
import fr.unilim.Grid;
import fr.unilim.Position;
import fr.unilim.Rover;

public record ForwardCommand(Rover rover, Grid grid) implements Command {

    @Override
    public void execute() {
        Position next = getNextPosition();

        if (!grid.isValidMove(next)) {
            System.out.println("You can't go there, there is an obstacle at " + next);
            return;
        }

        Position within = grid.isWithinBounds(next);

        if (within.equals(next)) {
            rover.forward();
        } else {
            rover.setPosition(within);
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
