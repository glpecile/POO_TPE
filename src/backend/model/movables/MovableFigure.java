package backend.model.movables;

public interface MovableFigure extends Movable{
    MovablePoint[] getPoints();

    @Override
    default void move(int moveInX, int moveInY){
        for (MovablePoint p: getPoints()) {
            p.move(moveInX,moveInY);
        }
    }

}
