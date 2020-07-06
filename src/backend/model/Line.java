package backend.model;

import javafx.scene.canvas.GraphicsContext;

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
        if(Double.compare (startPoint.getX(), endPoint.getX()) == 0){
            return ((p.getY()<startPoint.getY() && p.getY()>endPoint.getY()) ||
                    (p.getY()>startPoint.getY() && p.getY()<endPoint.getY())
                            && Double.compare(p.getX(),startPoint.getX())==0);
        }
        if((p.getX()<startPoint.getX() && p.getX()>endPoint.getX()) || (p.getX()>startPoint.getX() && p.getX()<endPoint.getX()) ){
            double m = (startPoint.getY()-endPoint.getY())/(startPoint.getX()-endPoint.getX());
            double b = startPoint.getY() - m * startPoint.getX();
            return Math.abs(p.getY() - m * p.getX() - b) < 5   ;
        }
        return false;
    }

    @Override
    protected List<Point> getPoints() {
        return Arrays.asList(getStartPoint(),getEndPoint());
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.strokeLine(startPoint.getX(), startPoint.getY(), endPoint.getX(), endPoint.getY());
    }

    @Override
    public String toString() {
        return String.format("Línea [ %s, %s ]", startPoint, endPoint);
    }
}
