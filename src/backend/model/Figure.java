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

    public void setColorProperties(Color strokeColor, Color fillColor, double strokeWidth) {
        setStrokeColor(strokeColor);
        setFillColor(fillColor);
        setStrokeWidth(strokeWidth);
    }

    public void setStrokeColor(Color strokeColor) {
        this.strokeColor = strokeColor;
    }

    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }

    public void setStrokeWidth(double strokeWidth) {
        this.strokeWidth = strokeWidth;
    }

    public Color getStrokeColor() {
        return strokeColor;
    }

    public Color getFillColor() {
        return fillColor;
    }

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
}
