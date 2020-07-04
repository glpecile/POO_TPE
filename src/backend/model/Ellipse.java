package backend.model;

import java.util.ArrayList;
import java.util.List;

public class Ellipse extends Figure {

    protected final Point centerPoint;
    protected final double mayorAxis;
    protected final double minorAxis;

    public Ellipse(Point centerPoint, double mayorAxis, double minorAxis) {
        if(centerPoint==null || mayorAxis==0 || minorAxis==0){
            throw new IllegalArgumentException();
        }
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
    public boolean contains(Point p) {
        return false;
    }

    @Override
    public String toString() {
        return String.format("Elipse [Centro: %s, Eje mayor: %.2f, Eje menor: %.2f]", centerPoint, mayorAxis, minorAxis);
    }

    @Override
    protected List<Point> getPoints() {
        List<Point> movablePoints = new ArrayList<>();
        movablePoints.add(getCenterPoint());
        return movablePoints;
    }

}
