package figures;

import figures.impl.Circle;
import figures.impl.Rectangle;
import figures.impl.Square;
import figures.impl.Triangle;

import java.util.*;

public class FiguresCollection implements Iterable<Figure>{
    private List<Figure> figures;
    private int index = 0;
    public FiguresCollection(List<Figure> figures) {
        this.figures = figures;
    }

    @Override
    public Iterator<Figure> iterator() {

        return new Iterator<Figure>() {
            @Override
            public boolean hasNext() {
                return index < figures.size();
            }
            @Override
            public Figure next() {
                return figures.get(index++);
            }
        };
    }

    @Override
    public String toString() {
        return String.format("%s, figures: %s", this.getClass().getSimpleName(),figures);
    }

    public FiguresCollection addFigure(Figure figure){
        figures.add(figure);
        return this;
    }
//    public Foo(){
//        figures = new LinkedList<Figure>();
//    }
    public void getInfo() {
        figures.forEach(a -> System.out.println(a));
    }
    public void deleteFigure(int inputIndex){
        figures.remove(inputIndex);
    }
    public void userMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("" +
                "************** Меню **************\n" +
                "1. Вывод информации о всех периметах, площадях и длиннах окружности всех фигур \n" +
                "2. Добавить новую фигуру\n" +
                "3. Удалить фигуру по индексу\n" +
                "4. Изменить фигуру по индексу\n" +
                "5. сортировка по площади, вывод информации о всех фигурах\n" +
                "6. Выход из программы. ");
        int choice = scanner.nextInt();
        if (0 >= choice || choice > 6){
            System.out.println("Введите корректный вариант действия, согласно меню.. ");
            userMenu();
        }
        if (choice == 6){
            System.out.println("До новых встреч! ");
        }
        else menuImplementation(choice);
    }
    public void menuImplementation(int usersChoice){
        Scanner scanner = new Scanner(System.in);
        int choice;
        if (usersChoice == 1){
            getInfo();
            userMenu();
        }
        else if (usersChoice == 2){
            System.out.println("" +
                    "************** Меню **************\n" +
                    "1. Добавить окружность \n" +
                    "2. Добавить прямоугольник \n" +
                    "3. Добавить квадрат \n" +
                    "4. Добавить треугольник \n" +
                    "5. Выход из программы. ");
            choice = scanner.nextInt();
            if (choice == 1){
                System.out.println("Введите радиус новой окружности: ");
                int radius = scanner.nextInt();
                addFigure(new Circle(Math.abs(radius)));
                System.out.println("Окружность добавлена!");
                userMenu();
            }
            else if (choice == 2){
                int a, b;
                System.out.println("Введите длину нового прямоугольника: ");
                a = scanner.nextInt();
                System.out.println("Введите ширину нового прямоугольника: ");
                b = scanner.nextInt();
                addFigure(new Rectangle(Math.abs(a),Math.abs(b)));
                System.out.println("Прямоугольник добавлен!");
                userMenu();
            }
            else if (choice == 3){
                System.out.println("Введите сторону нового квадрата: ");
                int side = scanner.nextInt();
                addFigure(new Square(Math.abs(side)));
                System.out.println("Квадрат добавлен!");
                userMenu();
            }
            else if (choice == 4){
                int a, b, c;
                System.out.println("Введите первую сторону нового треугольника: ");
                a = scanner.nextInt();
                System.out.println("Введите вторую сторону нового треугольника: ");
                b = scanner.nextInt();
                System.out.println("Введите третью сторону нового треугольника: ");
                c = scanner.nextInt();
                if (a > b + c || b > a + c || c > a + b){
                    System.out.println("Одна из сторон не может быть больше суммы двух других сторон...");
                    userMenu();
                }
                addFigure(new Triangle(Math.abs(a),Math.abs(b),Math.abs(c)));
                System.out.println("Треугольник добавлен!");
                userMenu();
            }
            else if (choice == 5){
                System.out.println("До новых встреч! ");
            }
            else {
                System.out.println("Введите корректный вариант действия, согласно меню.. ");
                userMenu();
            }

        }

        else if (usersChoice == 3){
            if (figures.isEmpty()){
                System.out.println("Список фигур пуст...");
                userMenu();
            }
            System.out.println("Введите индекс: ");
            int inputIndex = scanner.nextInt();
            if (inputIndex >= figures.size()){
                System.out.println("Фигура с таким индексом не существует...");
                userMenu();
            }
            else{
                System.out.printf("%s удален(а)\n", figures.get(inputIndex).getClass().getSimpleName());
                deleteFigure(inputIndex);
                userMenu();
            }
        }
        else if (usersChoice == 4){
            if (figures.isEmpty()){
                System.out.println("Список фигур пуст...");
                userMenu();
            }
            System.out.println("Введите индекс: ");
            int inputIndex = scanner.nextInt();
            if (inputIndex >= figures.size()){
                System.out.println("Фигура с таким индексом не существует...");
                userMenu();
            }
            else{
                if (figures.get(inputIndex) instanceof Circle){
                    System.out.println("Введите радиус: ");
                    int newRadius = scanner.nextInt();
                    ((Circle) figures.get(inputIndex)).setRadius(Math.abs(newRadius));
                    System.out.println("Окружность изменена!");
                    userMenu();
                }
                else if(figures.get(inputIndex) instanceof Rectangle){
                    int a,b;
                    System.out.println("Введите длину: ");
                    a = scanner.nextInt();
                    System.out.println("Введите ширину: ");
                    b = scanner.nextInt();
                    ((Rectangle) figures.get(inputIndex)).setA(Math.abs(a));
                    ((Rectangle) figures.get(inputIndex)).setB(Math.abs(b));
                    System.out.println("Прямоугольник изменен!");
                    userMenu();
                }
                else if (figures.get(inputIndex) instanceof Square){
                    System.out.println("Введите сторону: ");
                    int side = scanner.nextInt();
                    ((Square) figures.get(inputIndex)).setA(Math.abs(side));
                    System.out.println("Квадрат изменен!");
                    userMenu();
                }
                else if(figures.get(inputIndex) instanceof Triangle){
                    int a,b,c;
                    System.out.println("Введите длину: ");
                    a = scanner.nextInt();
                    System.out.println("Введите ширину: ");
                    b = scanner.nextInt();
                    System.out.println("Введите высоту: ");
                    c = scanner.nextInt();
                    if (a > b + c || b > a + c || c > a + b){
                        System.out.println("Одна из сторон не может быть больше суммы двух других сторон...");
                        userMenu();
                    }
                    ((Triangle) figures.get(inputIndex)).setA(Math.abs(a));
                    ((Triangle) figures.get(inputIndex)).setB(Math.abs(b));
                    ((Triangle) figures.get(inputIndex)).setC(Math.abs(c));
                    System.out.println("Треугольник изменен!");
                    userMenu();
                }
            }
        }
        else if (usersChoice == 5){
            Collections.sort(figures);
            getInfo();
            userMenu();
        }
        else if (usersChoice == 6){
            System.out.println("До новых встреч! ");
        }
        else {
            System.out.println("Введите корректный вариант действия, согласно меню.. ");
            userMenu();
        }
    }
}
