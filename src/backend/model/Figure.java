package backend.model;

import backend.model.movables.MovablePoint;

import java.util.List;

public abstract class Figure {
    //Funcion que determina si un punto pertence a una figura
    public abstract boolean belongs(Point p);
    //Obligo a que todas las hijas posean toString implementado
    @Override
    public abstract String toString();

    public abstract List<Point> getPoints();

    public void move(double moveInX, double moveInY){
        getPoints().forEach(p->p.move(moveInX,moveInY));
    }

}
