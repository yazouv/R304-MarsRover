package fr.unilim.commands;

import fr.unilim.Command;
import fr.unilim.Rover;

public record RightCommand(Rover rover) implements Command {
    @Override
    public void execute() {
        rover.turnRight();
    }
}
