
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class task5Test {
    public Stream<String> nameList(Map<String, Stream<String>> map) {
        if (map==null) throw new NullPointerException();

        return map.values()
                .stream()
                .flatMap(s->s)
                .filter(s -> s != null && s != "" && !s.isBlank())
                .map(s -> s.toLowerCase())
                .map(s -> s.replace(" ", ""))
                .distinct()
                .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1))
                .sorted();




    }

    public static void main(String[] args) {
        Map<String, Stream<String>> map = new HashMap<>();
//        map.put("Desktop", Stream.of(" iVan", "PeTro ", " Ira "));
//        map.put("Web", Stream.of("STepan", "ira ", " Andriy ", "an na"));
//        map.put("Spring", Stream.of("Ivan", "Anna"));
//        map.put("Spring", null);
//        map.put("Spring", null);
        map.put("Desktop", null);

    //    System.out.println(Arrays.toString(new task5Test().nameList(map).toArray()));
        List<String> expected = new ArrayList<>();
        List<String> actual = new task5Test().nameList(map).collect(Collectors.toList());
        System.out.println(expected.equals(actual));
    }
}
