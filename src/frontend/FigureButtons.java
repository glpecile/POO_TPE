package frontend;

import backend.model.Figure;
import javafx.scene.control.ToggleButton;

public enum FigureButtons {
    SELECCIONAR(new ToggleButton("Seleccionar")),
    RECTANGLE(new ToggleButton("Rectangulo")),
    CIRCLE(new ToggleButton("Circulo")),
    ELLIPSE(new ToggleButton("Elipse")),
    SQUARE(new ToggleButton("Cuadrado")),
    LINE(new ToggleButton("Linea"));
    private final ToggleButton button;

    FigureButtons(ToggleButton button) {
        this.button = button;
    }

}
