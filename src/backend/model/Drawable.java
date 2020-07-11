package backend.model;

import javafx.scene.canvas.GraphicsContext;

/**
 * Conjunto de funciones que permiten dibujar un objeto.
 */
public interface Drawable {

    /**
     * Dibuja un objeto.
     * @param gc graphicsContext donde se va a dibujar el objeto.
     */
    void draw(GraphicsContext gc);
}
