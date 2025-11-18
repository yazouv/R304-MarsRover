package fr.unilim;

import java.util.HashSet;
import java.util.Set;

public class Grid {
    private final int width;
    private final int height;
    private final Set<Position> obstacles;

    public Grid() {
        this.width = 100;
        this.height = 100;
        this.obstacles = new HashSet<>();
    }

    public Grid(int width, int height) {
        this.width = width;
        this.height = height;
        this.obstacles = new HashSet<>();
    }

    public void addObstacle(Position position) {
        obstacles.add(position);
    }

    public boolean hasObstacle(Position position) {
        return obstacles.contains(position);
    }

    public Position isWithinBounds(Position position) {
        int newX = (position.x() + width) % width;
        int newY = (position.y() + height) % height;
        return new Position(newX, newY);
    }

    public boolean isValidMove(Position position) {
        Position within = isWithinBounds(position);
        boolean result = within.equals(position) && !hasObstacle(position);

        if (!result) {
            System.out.println("Invalid move to position: " + within);
        }

        return result;
    }
}
