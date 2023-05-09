import figures.Figure;
import figures.FiguresCollection;
import figures.impl.Circle;
import figures.impl.Rectangle;
import figures.impl.Square;
import figures.impl.Triangle;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Figure> figureList = new LinkedList<>();
        figureList.add(new Circle(10));
        figureList.add(new Rectangle(4,6));
        figureList.add(new Square(5));
        figureList.add(new Triangle(3,4,5));
        FiguresCollection figuresCollection = new FiguresCollection(figureList);
        figuresCollection.userMenu();
    }
}