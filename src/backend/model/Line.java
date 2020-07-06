package backend.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Line extends Figure{
   private final Point startPoint;
   private final Point endPoint;

    public Line(Point startPoint, Point endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public Point getStartPoint() {
        return startPoint;
    }

    @Override
    public boolean contains(Point p) {
        Point aux = startPoint.substract(endPoint);
        if(Double.compare (aux.getX(), 0) == 0){
            return (p.getY()<startPoint.getY() && p.getY()>endPoint.getY()) || (p.getY()>startPoint.getY() && p.getY()<endPoint.getY());
        }
        if((p.getX()<startPoint.getX() && p.getX()>endPoint.getX()) || (p.getX()>startPoint.getX() && p.getX()<endPoint.getX()) ){
            double m = aux.getY()/aux.getX();
            return Double.compare(p.getY(), m*p.getX()) == 0;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("Línea [Comienzo: %.2f, Fin: %.2f]", startPoint, endPoint);
    }

    @Override
    protected List<Point> getPoints() {
        return Arrays.asList(getStartPoint(),getEndPoint());
    }
}
