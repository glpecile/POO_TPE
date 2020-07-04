package backend.model.movables;


import backend.model.Movable;

import java.util.List;


public interface MovableFigure extends Movable {
    List<MovablePoint> getPoints();

    @Override
    default void move(double moveInX, double moveInY){
        for (MovablePoint p : getPoints()) {
            p.move(moveInX, moveInY);
        }
    }

}
