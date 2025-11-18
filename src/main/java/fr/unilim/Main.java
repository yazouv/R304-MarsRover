package fr.unilim;

import fr.unilim.commands.BackwardCommand;
import fr.unilim.commands.ForwardCommand;
import fr.unilim.commands.LeftCommand;
import fr.unilim.commands.RightCommand;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        Rover rover = new Rover();
        Scanner scanner = new Scanner(System.in);

        Command forward = new ForwardCommand(rover);
        Command backward = new BackwardCommand(rover);
        Command left  = new LeftCommand(rover);
        Command right = new RightCommand(rover);

        Computer computer = new Computer();
        computer.setCommand("f", forward);
        computer.setCommand("b", backward);
        computer.setCommand("l", left);
        computer.setCommand("r", right);

        while (true) {
            System.out.println("Enter command (f=forward, b=backward, l=left, r=right): ");
            String input = scanner.nextLine();
            computer.executeCommand(input);
            rover.position();
            rover.orientation();
        }
    }
}
