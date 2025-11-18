package fr.unilim.commands;

import fr.unilim.Command;
import fr.unilim.Rover;

public record ForwardCommand(Rover rover) implements Command {

    @Override
    public void execute() {
        rover.forward();
    }
}
