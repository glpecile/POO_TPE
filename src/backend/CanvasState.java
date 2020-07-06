package backend;

import backend.model.Figure;
import java.util.*;

public class CanvasState {

    private final LinkedList<Figure> canvasFigures = new LinkedList<>();

    public void addFigure(Figure figure) {
        canvasFigures.add(figure);
    }

    public void removeSelectedFigures(Collection<Figure> selectedFigures) {
        selectedFigures.forEach(canvasFigures::remove);
//        selectedFigures.clear();
    }

    public Iterable<Figure> figures() {
        return new ArrayList<>(canvasFigures);
    }

    public void moveForward(Collection<Figure> selectedFigures) {
        removeSelectedFigures(selectedFigures);
        selectedFigures.forEach(canvasFigures::addFirst);
    }

    public void moveBackwards(Collection<Figure> selectedFigures) {
        removeSelectedFigures(selectedFigures);
        selectedFigures.forEach(canvasFigures::addLast);
    }
//
//    public void selectFigure(Figure figure){
//        selectedFigures.add(figure);
//    }
//
//    public void clearSelectedFigures(){
//        selectedFigures.clear();
//    }
//
//    public Iterable<Figure> selectedFigures() {
//        return selectedFigures;
//    }
//
//    public boolean isSelected() { return selectedFigures.isEmpty(); }
}
