package backend.model;

/**
 * Modelado de una cuadrado 2D
 */
public class Square extends Rectangle {

    /**
     * Crea una nueva instancia de un cuadrado.
     * @param topLeft Punto superior izquierdo.
     * @param bottomRight Determina el lado del cuadrado mediante la coordenada x.
     */
    public Square(Point topLeft, Point bottomRight) {
        super(topLeft, new Point(bottomRight.getX(), topLeft.getY() + bottomRight.getX() - topLeft.getX()));
    }

    @Override
    public String toString() {
        return String.format("Cuadrado [ %s , %s ]", topLeft, bottomRight);
    }
}
