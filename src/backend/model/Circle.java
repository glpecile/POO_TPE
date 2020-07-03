package backend.model;

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

}
