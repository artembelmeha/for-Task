import java.util.function.Predicate;
import java.util.function.BiFunction;
import java.util.ArrayList;
import java.util.List;

public class MyUtils{
    public static int findMaxByCondition(List<Integer> numbers, Predicate<Integer> pr) {
        int max = Integer.MIN_VALUE;
        for (Integer i:numbers) {
            if (pr.test(i) && i>max) max = i;
        }
        return max;
    }
}

class User {
    public final List<Integer> values = new ArrayList<Integer>();

    int getFilterdValue(BiFunction<List<Integer>, Predicate<Integer>, Integer>
                                getFiltered, Predicate<Integer> predicate){

        return getFiltered.apply(values,predicate);

    }

    int getMaxValueByCondition(Predicate<Integer> predicate) {

        return getFilterdValue(MyUtils::findMaxByCondition,predicate);

    }
}
