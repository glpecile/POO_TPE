package backend.model.basic;

public abstract class Figure {
    //Funcion que determina si un punto pertence a una figura
    public abstract boolean belongs(Point p);
    //Obligo a que todas las hijas posean toString implementado
    @Override
    public abstract String toString();

}
