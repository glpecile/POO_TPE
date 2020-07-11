package backend.model;

/**
 * Modelado de un círculo 2D.
 */
public class Circle extends Ellipse {

    private final double radius;

    /**
     * Crea una nueva instancia de un círculo.
     * @param centerPoint punto 2D donde está el centro del círculo.
     * @param radius radio del círculo.
     */
    public Circle(Point centerPoint, double radius) {
        super(centerPoint, radius * 2, radius * 2);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public boolean contains(Point p) {
        return centerPoint.distanceTo(p) < getRadius();
    }

    @Override
    public String toString() {
        return String.format("Círculo [Centro: %s, Radio: %.2f]", centerPoint, radius);
    }
}
