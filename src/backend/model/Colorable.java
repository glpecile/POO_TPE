package backend.model;

import javafx.scene.paint.Color;


/**
 * Conjunto de funciones que permite definir el color de un objeto.
 */
public interface Colorable {

    /**
     * Establece las propiedades de color del objeto.
     * @param strokeColor color del borde del objeto.
     * @param fillColor color del relleno del objeto.
     * @param strokeWidth ancho del borde del objeto.
     */
    default void setColorProperties(Color strokeColor, Color fillColor, double strokeWidth) {
        setStrokeColor(strokeColor);
        setFillColor(fillColor);
        setStrokeWidth(strokeWidth);
    }

    void setStrokeColor(Color strokeColor);

    void setFillColor(Color fillColor);

    void setStrokeWidth(double strokeWidth);

    Color getStrokeColor();

    Color getFillColor();

    double getStrokeWidth();
}
