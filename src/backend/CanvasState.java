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
    }

    public Iterable<Figure> figures() {
        return new ArrayList<>(canvasFigures);
    }

    public void moveForward(Collection<Figure> selectedFigures) {
        LinkedList<Figure> linkedFigures = new LinkedList<>(selectedFigures);
        removeSelectedFigures(selectedFigures);
        linkedFigures.descendingIterator().forEachRemaining(canvasFigures::addFirst);
    }

    public void moveBackwards(Collection<Figure> selectedFigures) {
        removeSelectedFigures(selectedFigures);
        selectedFigures.forEach(canvasFigures::addLast);
    }
}
