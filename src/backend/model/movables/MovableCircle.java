package backend.model.movables;

import backend.model.Circle;

import java.util.ArrayList;
import java.util.List;

public class MovableCircle extends Circle implements MovableFigure {
    public MovableCircle(MovablePoint centerPoint, double radius) {
        super(centerPoint, radius);
    }

    @Override
    public List<MovablePoint> getPoints() {
        List<MovablePoint> movablePoints = new ArrayList<>();
        movablePoints.add((MovablePoint) centerPoint);
        return movablePoints;
    }
}
