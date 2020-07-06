package backend.model;

import javafx.scene.canvas.GraphicsContext;

import java.util.Arrays;
import java.util.List;

public class Rectangle extends Figure {

    protected final Point topLeft, bottomRight;

    public Rectangle(Point topLeft, Point bottomRight) {
        if(topLeft == null || bottomRight == null) {
            throw new NullPointerException();
        }
        //El eje Y de la escena aumenta hacia abajo
        if(bottomRight.getX() < topLeft.getX() || bottomRight.getY() < topLeft.getY()) {
            throw new IllegalArgumentException();
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
        System.out.println("Is inside");
        boolean value = container.contains(topLeft) && container.contains(bottomRight);
        System.out.println(value);
        return true;

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
