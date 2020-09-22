package task3;

import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
public class MyUtils {
    // Code
    public boolean listMapCompare(List<String> list, Map<String, String> map) {
        for (String string:list) {
            if (!map.containsValue(string)) {
                return false;
            }
        }
        for (Map.Entry<String,String> com: map.entrySet()) {
           if(!list.contains(com.getValue()))
               return false;
        }
        return true;
    }
}
