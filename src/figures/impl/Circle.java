package figures.impl;

import figures.Figure;

public class Circle extends Figure {
    private int radius;

    @Override
    public double countPerimeter() {
        return 2*Math.PI*radius;
    }

    @Override
    public double countArea() {
        return Math.PI*Math.pow(radius, 2);
    }

    public Circle(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return String.format("%s, Сircumference length = %.1f, Area = %.1f", this.getClass().getSimpleName(), countPerimeter(),
                countArea());
    }
}
