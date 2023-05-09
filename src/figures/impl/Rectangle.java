package figures.impl;

import figures.Figure;

public class Rectangle extends Figure {
    private int a;
    private int b;

    public Rectangle(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double countPerimeter() {
        return 2*(a+b);
    }

    @Override
    public double countArea() {
        return a*b;
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

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
}
