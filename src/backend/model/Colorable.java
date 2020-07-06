package backend.model;

import javafx.scene.paint.Color;

public interface Colorable {

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
