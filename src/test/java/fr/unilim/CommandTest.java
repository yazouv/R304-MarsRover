package fr.unilim;

import fr.unilim.commands.BackwardCommand;
import fr.unilim.commands.ForwardCommand;
import fr.unilim.commands.LeftCommand;
import fr.unilim.commands.RightCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CommandTest {

    private Rover rover;
    private Grid grid;

    @BeforeEach
    void setUp() {
        grid = new Grid();
        rover = new Rover(5, 5, Orientation.NORTH);
    }

    @Test
    void testForwardCommandExecute() {
        ForwardCommand command = new ForwardCommand(rover, grid);
        command.execute();
        
        assertEquals(5, rover.position().x());
        assertEquals(6, rover.position().y());
    }

    @Test
    void testForwardCommandBlockedByObstacle() {
        grid.addObstacle(new Position(5, 6));
        ForwardCommand command = new ForwardCommand(rover, grid);
        command.execute();
        
        assertEquals(5, rover.position().x());
        assertEquals(5, rover.position().y());
    }

    @Test
    void testBackwardCommandExecute() {
        BackwardCommand command = new BackwardCommand(rover, grid);
        command.execute();
        
        assertEquals(5, rover.position().x());
        assertEquals(4, rover.position().y());
    }

    @Test
    void testBackwardCommandBlockedByObstacle() {
        grid.addObstacle(new Position(5, 4));
        BackwardCommand command = new BackwardCommand(rover, grid);
        command.execute();
        
        assertEquals(5, rover.position().x());
        assertEquals(5, rover.position().y());
    }

    @Test
    void testLeftCommandExecute() {
        LeftCommand command = new LeftCommand(rover);
        command.execute();
        
        assertEquals(Orientation.WEST, rover.orientation());
        assertEquals(5, rover.position().x());
        assertEquals(5, rover.position().y());
    }

    @Test
    void testRightCommandExecute() {
        RightCommand command = new RightCommand(rover);
        command.execute();
        
        assertEquals(Orientation.EAST, rover.orientation());
        assertEquals(5, rover.position().x());
        assertEquals(5, rover.position().y());
    }

    @Test
    void testForwardCommandWrapsAround() {
        Rover edgeRover = new Rover(5, 99, Orientation.NORTH);
        ForwardCommand command = new ForwardCommand(edgeRover, grid);
        command.execute();
        
        assertEquals(5, edgeRover.position().x());
        assertEquals(0, edgeRover.position().y());
    }

    @Test
    void testBackwardCommandWrapsAround() {
        Rover edgeRover = new Rover(5, 0, Orientation.NORTH);
        BackwardCommand command = new BackwardCommand(edgeRover, grid);
        command.execute();
        
        assertEquals(5, edgeRover.position().x());
        assertEquals(99, edgeRover.position().y());
    }

    @Test
    void testSequenceOfCommands() {
        ForwardCommand forward = new ForwardCommand(rover, grid);
        RightCommand right = new RightCommand(rover);
        BackwardCommand backward = new BackwardCommand(rover, grid);
        
        forward.execute();
        right.execute();
        forward.execute();
        backward.execute();
        
        assertEquals(5, rover.position().x());
        assertEquals(6, rover.position().y());
        assertEquals(Orientation.EAST, rover.orientation());
    }

    @Test
    void testCommandsWithMultipleObstacles() {
        grid.addObstacle(new Position(5, 6));
        grid.addObstacle(new Position(6, 5));
        grid.addObstacle(new Position(4, 5));
        
        ForwardCommand forward = new ForwardCommand(rover, grid);
        RightCommand right = new RightCommand(rover);
        LeftCommand left = new LeftCommand(rover);
        
        forward.execute();
        assertEquals(5, rover.position().x());
        assertEquals(5, rover.position().y());
        
        right.execute();
        forward.execute();
        assertEquals(5, rover.position().x());
        assertEquals(5, rover.position().y());
        
        left.execute();
        left.execute();
        forward.execute();
        assertEquals(5, rover.position().x());
        assertEquals(5, rover.position().y());
    }
}
