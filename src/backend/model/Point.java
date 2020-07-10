package backend.model;

import java.util.Objects;

/**
 * modelado 2D de un punto
 */

public class Point implements Movable{

    private double x, y;

    /**
     * Constructor del punto.
     * @param x valor de la posición en el eje x.
     * @param y valor de la posición en el eje y.
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public void move(double moveInX, double moveInY) {
        x += moveInX;
        y += moveInY;
    }

    /**
     * Cálculo de la distancia entre dos puntos.
     * @param p instancia de Point.
     * @return se retorna la distancia entre los dos puntos como una instancia de double.
     */
    public double distanceTo(Point p){
        return Math.sqrt(Math.pow(p.getX() - x, 2) + Math.pow(p.getY() - y, 2));
    }

    /**
     * Cálculo de la distancia horizontal entre dos puntos.
     * @param p instancia de Point.
     * @return se retorna la distancia horizontal entre dos puntos como una instancia de double.
     */
    public double horizontalDistanceTo(Point p) {
        return Math.abs(p.getX() - x);
    }
    /**
     * Cálculo de la distancia vertical entre dos puntos.
     * @param p instancia de Point.
     * @return se retorna la distancia horizontal entre dos puntos como una instancia de double.
     */
    public double verticalDistanceTo(Point p) {
        return Math.abs(p.getY() - y);
    }


    @Override
    public String toString() {
        return String.format("{%.2f , %.2f}", x, y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Double.compare(point.x, x) == 0 &&
                Double.compare(point.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
