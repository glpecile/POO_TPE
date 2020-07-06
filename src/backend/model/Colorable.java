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

    public Color getStrokeColor();

    public Color getFillColor();

    public double getStrokeWidth();
}
