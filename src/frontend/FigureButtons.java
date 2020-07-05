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
    ELLIPSE(new ToggleButton("Elipse")){
        @Override
        public Figure getFigure(Point startPoint, Point endPoint) {
            return new Ellipse(startPoint,1,1);//Falta meter el constructor del ellipse
        }
    },
    SQUARE(new ToggleButton("Cuadrado")){
        @Override
        public Figure getFigure(Point startPoint, Point endPoint) {
            return new Square(startPoint,endPoint);
        }
    };
//    LINE(new ToggleButton("Linea")){
//        @Override
//        public Figure getFigure(Point startPoint, Point endPoint) {
//            return new Rectangle(startPoint,endPoint);//Falta meter el constructor del elipse
//        }
//    }
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
