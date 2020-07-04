package backend.model;

import java.util.List;

public abstract class Figure implements Movable {

    //Funcion que determina si un punto pertence a una figura
    public abstract boolean contains(Point p);

    //Obligo a que todas las hijas posean toString implementado
    @Override
    public abstract String toString();

    protected abstract List<Point> getPoints();

    public void move(double moveInX, double moveInY){
        getPoints().forEach(p->p.move(moveInX,moveInY));
    }



    @Deprecated
    protected boolean validate(Point startPoint, Point endPoint) {
        if(startPoint == null || endPoint == null){
            return false;
        }
        return !(endPoint.getX() < startPoint.getX() || endPoint.getY() < startPoint.getY());
    }

}
