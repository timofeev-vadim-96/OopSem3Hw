package figures.impl;

import figures.Figure;

public class Triangle extends Figure {
    private int a;
    private int b;
    private int c;

    public Triangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double countPerimeter() {
        return a + b + c;
    }

    @Override
    public double countArea() {
        double area = Math.sqrt(countPerimeter()*(countPerimeter()-a)*(countPerimeter()-b)*(countPerimeter()-c));
        return area;
    }

    @Override
    public String toString() {
        return String.format("%s, Perimeter = %s, Area = %.1f", this.getClass().getSimpleName(), countPerimeter(),
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

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }
}
