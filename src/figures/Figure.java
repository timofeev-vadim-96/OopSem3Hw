package figures;

public abstract class Figure implements Comparable<Figure> {
    public abstract double countPerimeter();
    public abstract double countArea();

    @Override
    public int compareTo(Figure o) {
        return Double.compare(this.countArea(), o.countArea());
    }
}

