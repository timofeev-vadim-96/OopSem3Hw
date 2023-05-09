import figures.Foo;
import figures.impl.Circle;
import figures.impl.Rectangle;
import figures.impl.Square;
import figures.impl.Triangle;

public class Main {
    public static void main(String[] args) {
        Foo foo = new Foo();
        foo
                .addFigure(new Circle(10))
                .addFigure(new Rectangle(4,6))
                .addFigure(new Square(5))
                .addFigure(new Triangle(3,4,5));
        foo.userMenu();
    }
}