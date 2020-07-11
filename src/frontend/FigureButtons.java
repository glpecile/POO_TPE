package frontend;

import backend.model.*;
import javafx.scene.control.ToggleButton;

public enum FigureButtons {
    RECTANGLE(new ToggleButton("Rectángulo")){
        @Override
        public Figure getFigure(Point startPoint, Point endPoint) {
            return new Rectangle(startPoint,endPoint);
        }
    },
    CIRCLE(new ToggleButton("Círculo")){
        @Override
        public Figure getFigure(Point startPoint, Point endPoint) {
            return new Circle(startPoint, startPoint.distanceTo(endPoint));
        }
    },
    SQUARE(new ToggleButton("Cuadrado")){
        @Override
        public Figure getFigure(Point startPoint, Point endPoint) {
            return new Square(startPoint,endPoint);
        }
    },
    ELLIPSE(new ToggleButton("Elipse")){
        @Override
        public Figure getFigure(Point startPoint, Point endPoint) {
            if(endPoint.getX() < startPoint.getX() || endPoint.getY() < startPoint.getY()) {
                throw new IllegalArgumentException("Formación de figura inválida");
            }
            double mayorAxis = startPoint.horizontalDistanceTo(endPoint);
            double minorAxis = startPoint.verticalDistanceTo(endPoint);
            Point centerPoint = new Point(startPoint.getX() + mayorAxis / 2,
                    startPoint.getY() + minorAxis / 2);
            return new Ellipse(centerPoint, mayorAxis, minorAxis);
        }
    },
    LINE(new ToggleButton("Línea")){
        @Override
        public Figure getFigure(Point startPoint, Point endPoint) {
            return new Line(startPoint, endPoint);
        }
    };
    private final ToggleButton button;

    FigureButtons(ToggleButton button) {
        this.button = button;
    }

    public ToggleButton getButton() {
        return button;
    }

    /**
     * Busca el botón de las figuras que está seleccionado, para poder devolver una instancia nueva de esa figura a partir de dos puntos.
     * @param startPoint instancia de Point
     * @param endPoint instancia de Point
     * @return devuelve una nueva instancia de la figura correspondiente si es que se encuentra el botón seleccionado. Sino se retorna null.
     */
    public static Figure fetchFigure(Point startPoint, Point endPoint){
        for (FigureButtons b : values()) {
            if(b.button.isSelected()){
                return b.getFigure(startPoint,endPoint);
            }
        }
        return null;
    }

    /**
     * Es un método abstracto que se debe sobreescrbir en cada instancia para devolver la instancia de la figura que corresponde.
     * @param startPoint instancia de Point
     * @param endPoint instancia de Point
     * @return devuelve una nueva instancia de la figura correspondiente.
     */
    public abstract Figure getFigure(Point startPoint, Point endPoint);

}
