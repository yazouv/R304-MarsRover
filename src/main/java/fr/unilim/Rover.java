package fr.unilim;

public class Rover {
    private int x;
    private int y;

    public Rover() {
        this.x = 0;
        this.y = 0;
    }

    public Rover(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void forward() {
        y++;
    }

    public void backward() {
        y--;
    }

    public void turnLeft() {
        x--;
    }
    public void turnRight() {
        x++;
    }

    public void position() {
        System.out.println("X: " + this.x + " Y: " + this.y);
    }
}
