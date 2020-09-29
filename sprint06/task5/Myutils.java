import java.util.function.Predicate;
import java.util.Set;


public class Myutils {
    static Predicate getPredicateFromSet(Set<Predicate<Integer>> set) {
        return set.stream().reduce((x,y)->x.and(y)).get();
    }
}
