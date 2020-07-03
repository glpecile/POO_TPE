package backend.model.basic;

public class Ellipse extends Figure {

    protected final Point centerPoint;
    protected final double mayorAxis;
    protected final double minorAxis;

    public Ellipse(Point centerPoint, double mayorAxis, double minorAxis) {
        this.centerPoint = centerPoint;
        this.mayorAxis = mayorAxis;
        this.minorAxis = minorAxis;
    }

    public Point getCenterPoint() {
        return centerPoint;
    }

    public double getMayorAxis() {
        return mayorAxis;
    }

    public double getMinorAxis() {
        return minorAxis;
    }

    @Override
    public String toString() {
        return String.format("Elipse [Centro: %s, Eje mayor: %.2f, Eje menor: %.2f]", centerPoint, mayorAxis, minorAxis);
    }
}
