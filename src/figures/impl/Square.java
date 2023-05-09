package figures.impl;

import figures.Figure;

public class Square extends Figure {
    private int a;

    @Override
    public double countPerimeter() {
        return 4*a;
    }

    @Override
    public double countArea() {
        return a*2;
    }

    public Square(int a) {
        this.a = a;
    }
    @Override
    public String toString() {
        return String.format("%s, Perimeter = %s, Area = %s", this.getClass().getSimpleName(), countPerimeter(),
                countArea());
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
}
