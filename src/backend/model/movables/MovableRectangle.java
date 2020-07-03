package backend.model.movables;

import backend.model.basic.Rectangle;

import java.util.ArrayList;
import java.util.List;

public class MovableRectangle extends Rectangle implements MovableFigure {


    public MovableRectangle(MovablePoint topLeft, MovablePoint bottomRight) {
        super(topLeft, bottomRight);
    }

    @Override
    public List<MovablePoint> getPoints() {
        List<MovablePoint> movablePoints = new ArrayList<>();
        movablePoints.add((MovablePoint)getTopLeft());
        movablePoints.add((MovablePoint)getBottomRight());
        return movablePoints;
    }
}
