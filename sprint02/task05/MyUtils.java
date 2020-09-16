package task05;

import java.util.ArrayList;
import java.util.List;

abstract class Shape {
    public abstract double getPerimeter();
}

class Rectang extends Shape{
    private double width;
    private double height;

    public Rectang(double width, double height) {
        this.width = width;
        this.height = height;
    }
    public double getPerimeter(){
        return 2*(width+height);
    }
}
class Square extends Shape{
    private double width;

    public Square(double width) {
        this.width = width;
    }

    @Override
    public double getPerimeter() {
        return 4*width;
    }

}
public class MyUtils {
    public double sumPerimeter(List<Shape> firures) {
        double summ=0;
        for (Shape r:firures) {
            if (r instanceof Shape)
            summ+=r.getPerimeter();
        }
        return summ;
    }
}

