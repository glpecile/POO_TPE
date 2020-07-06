package backend;

import backend.model.Figure;
import java.util.*;

public class CanvasState {

    private final LinkedList<Figure> canvasFigures = new LinkedList<>();
    private final List<Figure> selectedFigures = new LinkedList<>();

    public void addFigure(Figure figure) {
        canvasFigures.add(figure);
    }

    public void removeSelectedFigures() {
        selectedFigures.forEach(canvasFigures::remove);
        selectedFigures.clear();
    }

    public Iterable<Figure> figures() {
        return new ArrayList<>(canvasFigures);
    }
    public void selectFigure(Figure figure){
        selectedFigures.add(figure);
    }
    public void clearSelectedFigures(){
        selectedFigures.clear();
    }
    public Iterable<Figure> selectedFigures() {
        return new ArrayList<>(selectedFigures);
    }
}
