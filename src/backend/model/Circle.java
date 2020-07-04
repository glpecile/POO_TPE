package backend.model;

public class Circle extends Ellipse {

    private final double radius;

    public Circle(Point centerPoint, double radius) {
        super(centerPoint, radius * 2, radius * 2);
        this.radius = radius;
    }

//    public Circle(Point centerPoint, Point endPoint) {
//        this(centerPoint,centerPoint.distanceTo(endPoint));
//    }

    @Override
    public String toString() {
        return String.format("Círculo [Centro: %s, Radio: %.2f]", centerPoint, radius);
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public boolean contains(Point p) {
        return centerPoint.distanceTo(p) < getRadius();
    }
}
