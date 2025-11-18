package fr.unilim;

import fr.unilim.commands.BackwardCommand;
import fr.unilim.commands.ForwardCommand;
import fr.unilim.commands.LeftCommand;
import fr.unilim.commands.RightCommand;

import java.util.Scanner;

public class Main {
    static void main() {
        Rover rover = new Rover();
        Scanner scanner = new Scanner(System.in);
        Grid grid = new Grid();

        Command forward = new ForwardCommand(rover, grid);
        Command backward = new BackwardCommand(rover, grid);
        Command left  = new LeftCommand(rover);
        Command right = new RightCommand(rover);

        Computer computer = new Computer();
        computer.setCommand("f", forward);
        computer.setCommand("b", backward);
        computer.setCommand("l", left);
        computer.setCommand("r", right);

        grid.addObstacle(new Position(0, 99));

        while (true) {
            System.out.println("Enter command (f=forward, b=backward, l=left, r=right): ");
            String input = scanner.nextLine();
            computer.executeCommand(input);
            System.out.println(rover.toString());
        }
    }
}
