import java.util.Arrays;
import java.util.function.Predicate;
public class MyUtils10 {

    public static int getCount(int [] array, Predicate<Integer> predicate ) {
        int count=0;
        for(int i:array) {
            if(predicate.test(i))
                count++;
        }
        return count;
    }
}