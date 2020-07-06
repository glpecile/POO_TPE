package backend;

import backend.model.Figure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CanvasState {

    private final Map<Integer,Figure> figureMap = new HashMap<>();

    public void addFigure(Figure figure) {
        figureMap.put(figure.getID(),figure);
    }

    public void deleteFigure (int ID) { figureMap.remove(ID); }

    public void deleteSelectedFigures() {

    }

    public Iterable<Figure> figures() {
        return new ArrayList<>(figureMap.values());
    }

}
