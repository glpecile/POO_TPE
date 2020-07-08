package frontend;

import backend.model.*;
import javafx.scene.control.ToggleButton;

public enum FigureButtons {
    RECTANGLE(new ToggleButton("Rectangulo")){
        @Override
        public Figure getFigure(Point startPoint, Point endPoint) {
            return new Rectangle(startPoint,endPoint);
        }
    },
    CIRCLE(new ToggleButton("Circulo")){
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
    LINE(new ToggleButton("Linea")){
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

    public static Figure fetchFigure(Point startPoint, Point endPoint){
        for (FigureButtons b : values()) {
            if(b.button.isSelected()){
                return b.getFigure(startPoint,endPoint);
            }
        }
        return null;
    }

    public abstract Figure getFigure(Point startPoint, Point endPoint);

}
