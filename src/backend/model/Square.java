package backend.model;

public class Square extends Rectangle{
    public Square(Point side) {
        super(side, new Point(side.getX()+side.getX(),side.getY()+side.getY()));//Dejamos esto por ahora as'i. Hay que cambiarlo, agregar funciones en point
    }
}
