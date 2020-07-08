package backend.model;

import javafx.scene.canvas.GraphicsContext;

import java.util.Arrays;
import java.util.List;

public class Rectangle extends Figure {

    protected final Point topLeft, bottomRight;

    public Rectangle(Point topLeft, Point bottomRight) {
        if(topLeft == null || bottomRight == null) {
            throw new NullPointerException("Puntos inválidos");
        }
        //El eje Y de la escena aumenta hacia abajo
        if(Double.compare(bottomRight.getX(), topLeft.getX()) <= 0
            || Double.compare(bottomRight.getY(), topLeft.getY()) <= 0) {
        //if(bottomRight.getX() <= topLeft.getX() || bottomRight.getY() <= topLeft.getY()) {
            throw new IllegalArgumentException("Formación de figura inválida");
        }
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }

    public Point getTopLeft() {
        return topLeft;
    }

    public Point getBottomRight() {
        return bottomRight;
    }

    @Override
    public boolean contains(Point p) {
        return p.getX() > getTopLeft().getX() && p.getX() < getBottomRight().getX() &&
                p.getY() > getTopLeft().getY() && p.getY() < getBottomRight().getY();
    }

    @Override
    public boolean isInside(Rectangle container) {
        return container.contains(topLeft) && container.contains(bottomRight);

    }

    @Override
    protected List<Point> getPoints() {
        return Arrays.asList(bottomRight, topLeft);
    }

    @Override
    public void draw(GraphicsContext gc) {
        double width = bottomRight.horizontalDistanceTo(topLeft);
        double height = bottomRight.verticalDistanceTo(topLeft);
        gc.strokeRect(topLeft.getX(), topLeft.getY(), width, height);
        gc.fillRect(topLeft.getX(), topLeft.getY(), width, height);
    }

    @Override
    public String toString() {
        return String.format("Rectángulo [ %s , %s ]", topLeft, bottomRight);
    }

}
