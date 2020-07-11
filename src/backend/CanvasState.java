package backend;

import backend.model.Figure;
import java.util.*;

public class CanvasState {

    private final LinkedList<Figure> canvasFigures = new LinkedList<>();

    /**
     * Se agrega la figura al canvas.
     * @param figure la instancia Figure a agregar
     */
    public void addFigure(Figure figure) {
        canvasFigures.add(figure);
    }

    /**
     * Se remueven las figuras seleccionadas del canvas.
     * @param selectedFigures la colección de figuras a remover en el canvas.
     */
    public void removeSelectedFigures(Collection<Figure> selectedFigures) {
        selectedFigures.forEach(canvasFigures::remove);
    }

    /**
     * Devuelve la instancia del canvasFigures en Iterable, para poder iterar las figuras del mismo.
     * El usuario no puede acceder a métodos del back-end.
     * @return un Iterable de Figures.
     */
    public Iterable<Figure> figures() {
        return canvasFigures;
    }

    /**
     * Permite mover el orden de aparación de las figuras seleccionadas hacia adelante.
     * @param selectedFigures colección de figuras a mover hacia adelante.
     */
    public void moveForward(Collection<Figure> selectedFigures) {
        removeSelectedFigures(selectedFigures);
        LinkedList<Figure> aux = new LinkedList<>(selectedFigures);
        aux.descendingIterator().forEachRemaining(canvasFigures::addFirst);
    }

    /**
     * Permite mover el orden de aparación, de las figuras seleccionadas hacia el fondo.
     * @param selectedFigures colección de figuras a mover hacia atrás.
     */
    public void moveBackwards(Collection<Figure> selectedFigures) {
        removeSelectedFigures(selectedFigures);
        selectedFigures.forEach(canvasFigures::addLast);
    }
}
