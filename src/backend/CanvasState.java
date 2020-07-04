package backend;

import backend.model.basic.Figure;
import backend.model.movables.MovableFigure;

import java.util.ArrayList;
import java.util.List;

public class CanvasState {

    private final List<MovableFigure> list = new ArrayList<>();

    public void addFigure(MovableFigure figure) {
        if(figure != null) {
            list.add(figure);
        }
    }

    public Iterable<MovableFigure> figures() {
        return new ArrayList<>(list);
    }

}
