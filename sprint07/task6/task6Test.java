import static java.lang.System.out;


import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class task6Test {
    public static void main(String[] args) {
          List<Stream<String>> list = new ArrayList<>();
          list.add(Stream.of("093"));
          list.add(Stream.of("067-21-436-57"));
//          list.add(Stream.of("(093)-11-22-334", "044 435-62-18", "721-73-45"));

          Map<String, Stream<String>> result = new task6Test().phoneNumbers(list);
            customToString(result);
    }


 public Map<String, Stream<String>> phoneNumbers(List<Stream<String>> list) {
        if(list==null) {
            throw new NullPointerException("invalid parameters");
        }
         return list.stream()
                 .flatMap(s -> s)
                 .filter(s -> s != null && s.trim().length() > 0)
                 .map(s -> s.replaceAll("[^0-9]", ""))
                 .map(s -> s.length() == 10 ? s : (s.length() == 7 ? s = "loc" + s : "err" + s))
                 .distinct()
                 .collect(Collectors.toMap(s -> s.substring(0, 3),
                         s -> Stream.of(s.substring(3)), Stream::concat));
 }


 private static void customToString(Map<String, Stream<String>> result) {
    result.forEach((key, value) -> out.println(key + "=" + Arrays.toString(value.toArray())));
 }

}