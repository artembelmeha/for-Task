package task5;

import javax.swing.text.html.parser.Parser;

class Array<T> {
    private T[] array;

    public Array(T[] array) {
        this.array = array;
    }

    public T get(int index) {
        return array[index];
    }
    public int length() {
        return array.length;
    }
}
class ArrayUtil {

    public static <T extends Number>  double averageValue(Array<T> numbers) {
        double sum = Double.valueOf(0);
        for (int i = 0; i <numbers.length() ; i++) {
            sum =Double.sum(sum , numbers.get(i).doubleValue());
        }
        return sum/numbers.length();
    }

}
public class MyUtils {


    public static void main(String[] args) {
        Integer i =1;
        Double d = Double.valueOf(i);
        Array<Integer> set1 = new Array<>(new Integer[] {1,2,3,4,5});
        System.out.println(ArrayUtil.averageValue(set1));
    }
}
