package backend.model;

import backend.model.movables.MovablePoint;

import java.util.ArrayList;
import java.util.List;

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
    public boolean belongs(Point p) {
        return false;
    }

    @Override
    public String toString() {
        return String.format("Elipse [Centro: %s, Eje mayor: %.2f, Eje menor: %.2f]", centerPoint, mayorAxis, minorAxis);
    }

    @Override
    public List<Point> getPoints() {
        List<Point> movablePoints = new ArrayList<>();
        movablePoints.add(getCenterPoint());
        return movablePoints;
    }

}
