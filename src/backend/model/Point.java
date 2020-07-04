package backend.model;

public class Point implements Movable{

    private double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return String.format("{%.2f , %.2f}", x, y);
    }

    @Override
    public void move(double moveInX, double moveInY) {
        x += moveInX;
        y += moveInY;
    }
    public double distanceTo(Point p){
        return Math.sqrt(Math.pow(p.getX() - x, 2) + Math.pow(p.getY() - y, 2));
    }
}
