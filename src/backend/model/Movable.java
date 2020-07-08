package backend.model;

/**
 * Permite que un objeto modelado en un plano pueda desplazarse.
 */
@FunctionalInterface
public interface Movable {

    /**
     * Desplaza al objeto en la plano.
     * @param moveInX variación
     * @param moveInY
     */
    void move(double moveInX, double moveInY);
}
