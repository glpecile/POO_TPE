package backend.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


import java.util.List;

public abstract class Figure implements Movable {

    private Color strokeColor;
    private Color fillColor;
    private double strokeWidth;

    public void move(double moveInX, double moveInY){
        getPoints().forEach(p->p.move(moveInX,moveInY));
    }

    //Funcion que determina si un punto pertence a una figura
    public abstract boolean contains(Point p);

    protected abstract List<Point> getPoints();

    public abstract void draw(GraphicsContext gc);

    //Obligo a que todas las hijas posean toString implementado
    @Override
    public abstract String toString();
}
