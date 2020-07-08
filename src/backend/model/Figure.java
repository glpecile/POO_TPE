package backend.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


import java.util.List;
import java.util.Objects;

/**
 * Modelado de una figura en 2D
 */
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

    /**
     * Determina si un punto esta dentro de una figura.
     * @param p Punto 2D.
     * @return true si el punto está contenido en la figura.
     */
    public abstract boolean contains(Point p);

    /**
     * Determina si una figura está completamente contenida en un rectángulo.
     * @param container Rectángulo donde puede estar contenida la figura.
     * @return true si la figura está completamente contenida en container.
     */
    public abstract boolean isInside(Rectangle container);

    /**
     * @return Lista con los puntos relevantes de la figura.
     */
    protected abstract List<Point> getPoints();

    /**
     * Dibuja la figura.
     * @param gc GraphicsContext donde se va a dibujar la figura.
     */
    public abstract void draw(GraphicsContext gc);

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
