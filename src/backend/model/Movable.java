package backend.model;

/**
 * Permite que un objeto modelado en un plano pueda desplazarse.
 */
@FunctionalInterface
public interface Movable {

    /**
     * Desplaza al objeto en la plano.
     * @param moveInX variación en el eje X
     * @param moveInY variación en el eje Y
     */
    void move(double moveInX, double moveInY);
}
