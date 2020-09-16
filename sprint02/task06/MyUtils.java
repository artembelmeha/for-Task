package task06;



import java.util.*;
import java.util.stream.Collectors;

abstract class Shape {
    private String name;

    public Shape(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    abstract double getArea();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Shape)) return false;
        Shape shape = (Shape) o;
        return Objects.equals(getName(), shape.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
class Circle extends Shape {
    private double radius;

    public double getRadius() {
        return radius;
    }

    public Circle(String name, double radius) {
        super(name);
        this.radius = radius;
    }

    @Override
    double getArea() {
        return Math.PI*Math.pow(getRadius(),2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Circle)) return false;
        Circle circle = (Circle) o;
        return Double.compare(circle.getRadius(), getRadius()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRadius());
    }
}
class Rectangle extends Shape {
    private double height;
    private double width;

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public Rectangle(String name, double height, double width) {
        super(name);
        this.height = height;
        this.width = width;
    }


    @Override
    double getArea() {
        return getHeight()*getWidth();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rectangle)) return false;
        Rectangle rectangle = (Rectangle) o;
        return Double.compare(rectangle.getHeight(), getHeight()) == 0 &&
                Double.compare(rectangle.getWidth(), getWidth()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHeight(), getWidth());
    }
}
public class MyUtils {
    public List<Shape> maxAreas(List<Shape> shapes) {
        List<Shape> res = new ArrayList<>();
        double maxCircle = 0;
        double maxRectangle = 0;
        for (Shape shape:shapes) {
            if (shape.getName().equals("Circle")) {
                if (maxCircle < shape.getArea())
                    maxCircle = shape.getArea();
            }
            if (shape.getName().equals("Rectangle")) {
                if (maxRectangle < (shape).getArea())
                    maxRectangle = shape.getArea();
            }
        }
        for (Shape shape:shapes) {
            if (shape.getName().equals("Circle")) {
                if (shape.getArea() == maxCircle)
                    if(!res.contains(shape))
                        res.add(shape);
            }
            if (shape.getName().equals("Rectangle")) {
                if (shape.getArea() == maxRectangle) {
                    if(!res.contains(shape))
                        res.add(shape);
                }

            }
        }
        return res;
    }


}
