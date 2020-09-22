package task6;

import java.text.CollationKey;
import java.text.Collator;
import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.Delayed;

class Utility {
    public static <T extends Person> void sortPeople(T [] array, Comparator<? super T> comparator) {
        Arrays.sort(array,comparator);
    }
}
class StringComparator implements Comparator<String> {
         @Override
     public int compare(String s1, String s2) { return 0; }
 }
public class MyUtilsl {




}
