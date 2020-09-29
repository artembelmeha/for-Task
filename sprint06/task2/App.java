
import java.util.function.Consumer;
public class App {
    private static Consumer<double[]> cons =  (array)-> {
        for (int i = 0; i < array.length; i++) {
            if (array[i]>2)  {
                array[i]*=0.8;
            } else array[i]*=0.9;
        }
    };
    public static double[] getChanged(double[] initialArray, Consumer<double[]> consumer) {
        double[] array = initialArray.clone();
        consumer.accept(array);
        return array;
    }
}