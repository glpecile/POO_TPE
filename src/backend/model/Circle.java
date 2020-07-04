package backend.model;

public class Circle extends Ellipse {

    private final double radius;

    public Circle(Point centerPoint, double radius) {
        super(centerPoint, radius * 2, radius * 2);
        this.radius = radius;
    }

    public Circle(Point centerPoint, Point endPoint) {
        this(centerPoint,computeRadius(centerPoint,endPoint));
    }

    @Override
    public String toString() {
        return String.format("Círculo [Centro: %s, Radio: %.2f]", centerPoint, radius);
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public boolean contains(Point p) {
        return Math.sqrt(Math.pow(getCenterPoint().getX() - p.getX(), 2) +
                Math.pow(getCenterPoint().getY() - p.getY(), 2)) < getRadius();
    }
    public static double computeRadius(Point centerPoint, Point endPoint){
        if(centerPoint == null || endPoint ==null){
            return 0;
        }
        return centerPoint.distanceTo(endPoint);
    }
}
