package fr.unilim;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RoverTest {

    private Rover rover;

    @BeforeEach
    void setUp() {
        rover = new Rover();
    }

    @Test
    void testDefaultConstructor() {
        assertEquals(0, rover.position().x());
        assertEquals(0, rover.position().y());
        assertEquals(Orientation.NORTH, rover.orientation());
    }

    @Test
    void testConstructorWithCoordinates() {
        Rover customRover = new Rover(5, 10);
        assertEquals(5, customRover.position().x());
        assertEquals(10, customRover.position().y());
        assertEquals(Orientation.NORTH, customRover.orientation());
    }

    @Test
    void testConstructorWithOrientation() {
        Rover customRover = new Rover(3, 7, Orientation.EAST);
        assertEquals(3, customRover.position().x());
        assertEquals(7, customRover.position().y());
        assertEquals(Orientation.EAST, customRover.orientation());
    }

    @Test
    void testConstructorWithPosition() {
        Position pos = new Position(2, 4);
        Rover customRover = new Rover(pos, Orientation.WEST);
        assertEquals(2, customRover.position().x());
        assertEquals(4, customRover.position().y());
        assertEquals(Orientation.WEST, customRover.orientation());
    }

    @Test
    void testForwardNorth() {
        rover.forward();
        assertEquals(0, rover.position().x());
        assertEquals(1, rover.position().y());
    }

    @Test
    void testForwardEast() {
        Rover eastRover = new Rover(0, 0, Orientation.EAST);
        eastRover.forward();
        assertEquals(1, eastRover.position().x());
        assertEquals(0, eastRover.position().y());
    }

    @Test
    void testForwardSouth() {
        Rover southRover = new Rover(0, 5, Orientation.SOUTH);
        southRover.forward();
        assertEquals(0, southRover.position().x());
        assertEquals(4, southRover.position().y());
    }

    @Test
    void testForwardWest() {
        Rover westRover = new Rover(5, 0, Orientation.WEST);
        westRover.forward();
        assertEquals(4, westRover.position().x());
        assertEquals(0, westRover.position().y());
    }

    @Test
    void testBackwardNorth() {
        Rover northRover = new Rover(0, 5, Orientation.NORTH);
        northRover.backward();
        assertEquals(0, northRover.position().x());
        assertEquals(4, northRover.position().y());
    }

    @Test
    void testBackwardEast() {
        Rover eastRover = new Rover(5, 0, Orientation.EAST);
        eastRover.backward();
        assertEquals(4, eastRover.position().x());
        assertEquals(0, eastRover.position().y());
    }

    @Test
    void testTurnLeft() {
        assertEquals(Orientation.NORTH, rover.orientation());
        rover.turnLeft();
        assertEquals(Orientation.WEST, rover.orientation());
        rover.turnLeft();
        assertEquals(Orientation.SOUTH, rover.orientation());
        rover.turnLeft();
        assertEquals(Orientation.EAST, rover.orientation());
        rover.turnLeft();
        assertEquals(Orientation.NORTH, rover.orientation());
    }

    @Test
    void testTurnRight() {
        assertEquals(Orientation.NORTH, rover.orientation());
        rover.turnRight();
        assertEquals(Orientation.EAST, rover.orientation());
        rover.turnRight();
        assertEquals(Orientation.SOUTH, rover.orientation());
        rover.turnRight();
        assertEquals(Orientation.WEST, rover.orientation());
        rover.turnRight();
        assertEquals(Orientation.NORTH, rover.orientation());
    }

    @Test
    void testGetPosition() {
        Position position = rover.position();
        assertEquals(0, position.x());
        assertEquals(0, position.y());
    }

    @Test
    void testComplexMovement() {
        rover.forward();
        rover.turnRight();
        rover.forward();
        rover.forward();
        rover.turnLeft();
        rover.backward();
        
        assertEquals(2, rover.position().x());
        assertEquals(0, rover.position().y());
        assertEquals(Orientation.NORTH, rover.orientation());
    }
}
