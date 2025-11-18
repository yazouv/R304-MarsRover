package fr.unilim.commands;

import fr.unilim.Command;
import fr.unilim.Grid;
import fr.unilim.Position;
import fr.unilim.Rover;

public record BackwardCommand(Rover rover, Grid grid) implements Command {

    @Override
    public void execute() {
        Position next = getNextPosition();

        if (!grid.isValidMove(next)) {
            System.out.println("You can't go there, there is an obstacle at " + next);
            return;
        }

        Position within = grid.isWithinBounds(next);

        if (within.equals(next)) {
            rover.backward();
        } else {
            rover.setPosition(within);
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
