
import java.util.Map;
import java.util.function.Function;
        import java.util.stream.Collectors;
        import java.util.stream.Stream;

public class task7Test {
    public Stream<Integer> duplicateElements(Stream<Integer> stream) {
        return stream.filter(x->x!=null)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(m->m!=null && m.getValue()>1)
                .map(Map.Entry::getKey)
                .sorted();
    }
}
