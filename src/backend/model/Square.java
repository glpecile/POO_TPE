package backend.model;

public class Square extends Rectangle {
    public Square(Point side) {
        super(side, new Point(side.getX()+side.getX(),side.getY()+side.getY()));
    }
}
