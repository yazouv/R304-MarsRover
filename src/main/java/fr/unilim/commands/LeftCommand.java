package fr.unilim.commands;

import fr.unilim.Command;
import fr.unilim.Rover;

public record LeftCommand(Rover rover) implements Command {

    @Override
    public void execute() {
        rover.turnLeft();
    }
}
