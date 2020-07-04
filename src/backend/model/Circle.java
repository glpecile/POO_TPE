package backend.model;

import backend.model.movables.MovablePoint;

import java.util.List;

public class Circle extends Ellipse {

//    protected final Point centerPoint;
    private final double radius;

    public Circle(Point centerPoint, double radius) {
        super(centerPoint, radius * 2, radius * 2);
        this.radius = radius;
    }

    @Override
    public String toString() {
        return String.format("Círculo [Centro: %s, Radio: %.2f]", centerPoint, radius);
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public boolean belongs(Point p) {
        return Math.sqrt(Math.pow(getCenterPoint().getX() - p.getX(), 2) +
                Math.pow(getCenterPoint().getY() - p.getY(), 2)) < getRadius();
    }
}
