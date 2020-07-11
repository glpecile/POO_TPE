package backend.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


import java.util.List;
import java.util.Objects;

/**
 * Modelado de una figura en 2D.
 */
public abstract class Figure implements Movable, Colorable, Drawable{

    private static int count = 0;
    private final int ID = getNewID();
    private Color strokeColor = Color.BLACK;
    private Color fillColor = Color.BLACK;
    private double strokeWidth = 1;

    private int getNewID() {
        return count++;
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

    @Override
    public abstract void draw(GraphicsContext gc);

    /**
     * Determina si un punto está dentro de una figura.
     * @param p punto 2D.
     * @return true si el punto está contenido en la figura.
     */
    public abstract boolean contains(Point p);

    /**
     * Determina si una figura está completamente contenida en un rectángulo.
     * @param container rectángulo donde puede estar contenida la figura.
     * @return true si la figura está completamente contenida en container.
     */
    public abstract boolean isInside(Rectangle container);

    /**
     * @return Lista con los puntos relevantes de la figura.
     */
    protected abstract List<Point> getPoints();

    @Override
    public abstract String toString();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Figure)) return false;
        Figure figure = (Figure) o;
        return ID == figure.ID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }
}
