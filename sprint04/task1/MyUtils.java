package task1;

import java.util.*;

public class MyUtils {
    // Code
    public Map<String, List<String>> createNotebook(Map<String, String> phones) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (Map.Entry<String,String> entry : phones.entrySet()) {
            String oldValue = entry.getValue();
            String oldKey = entry.getKey();
            List<String> newValues = null;
            if (map.containsKey(oldValue)) {
                newValues = map.get(oldValue);
                newValues.add(oldKey);
            } else {
                newValues = new ArrayList<>();
                newValues.add(oldKey);
            }
            map.put(oldValue,newValues);
        }
        return map;
    }
}
