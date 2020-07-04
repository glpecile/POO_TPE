package backend;

import backend.model.Figure;

import java.util.ArrayList;
import java.util.List;

public class CanvasState {

    private final List<Figure> list = new ArrayList<>();

    public void addFigure(Figure figure) {
        if(figure != null) {
            list.add(figure);
        }
    }

    public Iterable<Figure> figures() {
        return new ArrayList<>(list);
    }

}
