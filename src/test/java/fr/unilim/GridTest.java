package fr.unilim;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class GridTest {

    private Grid grid;

    @BeforeEach
    void setUp() {
        grid = new Grid();
    }

    @Test
    void testConstructor() {
        Grid newGrid = new Grid(5, 8);
        assertNotNull(newGrid);
    }

    @Test
    void testAddObstacleWithPosition() {
        Position obstacle = new Position(3, 4);
        grid.addObstacle(obstacle);
        assertTrue(grid.hasObstacle(obstacle));
    }

    @Test
    void testAddObstacleWithCoordinates() {
        grid.addObstacle(new Position(5, 6));
        assertTrue(grid.hasObstacle(new Position(5, 6)));
    }

    @Test
    void testHasObstacle() {
        Position obstacle = new Position(2, 2);
        assertFalse(grid.hasObstacle(obstacle));
        
        grid.addObstacle(obstacle);
        assertTrue(grid.hasObstacle(obstacle));
    }

    @Test
    void testIsValidMove() {
        Position validPosition = new Position(5, 5);
        Position obstaclePosition = new Position(3, 3);

        grid.addObstacle(obstaclePosition);
        
        assertTrue(grid.isValidMove(validPosition));
        assertFalse(grid.isValidMove(obstaclePosition));
    }

    @Test
    void testMultipleObstacles() {
        grid.addObstacle(new Position(1, 1));
        grid.addObstacle(new Position(2, 2));
        grid.addObstacle(new Position(3, 3));
        
        assertTrue(grid.hasObstacle(new Position(1, 1)));
        assertTrue(grid.hasObstacle(new Position(2, 2)));
        assertTrue(grid.hasObstacle(new Position(3, 3)));
        assertFalse(grid.hasObstacle(new Position(4, 4)));
    }
}
