package backend.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


import java.util.List;
import java.util.Objects;

public abstract class Figure implements Movable, Colorable{

    private static int count=0;
    private final int ID=getNewID();
    private Color strokeColor;
    private Color fillColor;
    private double strokeWidth;

    public int getNewID() {
        return count++;
    }
    //Si no se usa hay que borrarlo
    public int getID() {
        return ID;
    }

    @Override
    public void move(double moveInX, double moveInY){
        getPoints().forEach(p->p.move(moveInX,moveInY));
    }

    @Override
    public void setStrokeColor(Color strokeColor) {
        this.strokeColor = strokeColor;
    }

    @Override
    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }

    @Override
    public void setStrokeWidth(double strokeWidth) {
        this.strokeWidth = strokeWidth;
    }

    @Override
    public Color getStrokeColor() {
        return strokeColor;
    }

    @Override
    public Color getFillColor() {
        return fillColor;
    }

    @Override
    public double getStrokeWidth() {
        return strokeWidth;
    }

    //Funcion que determina si un punto pertence a una figura
    public abstract boolean contains(Point p);

    protected abstract List<Point> getPoints();

    public abstract void draw(GraphicsContext gc);

    //Obligo a que todas las hijas posean toString implementado
    @Override
    public abstract String toString();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Figure figure = (Figure) o;
        return ID == figure.ID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }
}
