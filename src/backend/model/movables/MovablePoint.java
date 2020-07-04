package backend.model.movables;

import backend.model.basic.Point;

public class MovablePoint extends Point implements Movable {

    public MovablePoint(double x, double y) {
        super(x, y);
    }

    @Override
    public void move(double moveInX, double moveInY) {
        x += moveInX;
        y += moveInY;
    }
}
