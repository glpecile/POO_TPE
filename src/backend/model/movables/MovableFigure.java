package backend.model.movables;

import backend.model.basic.Point;

import java.util.List;

public interface MovableFigure extends Movable{
    List<MovablePoint> getPoints();

    @Override
    default void move(int moveInX, int moveInY){
        for (MovablePoint p : getPoints()) {
            p.move(moveInX, moveInY);
        }
    }

}
