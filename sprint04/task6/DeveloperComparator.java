package task6;

import java.util.Comparator;

public class DeveloperComparator implements Comparator<Developer> {
    @Override
    public int compare(Developer o1, Developer o2) {
        Comparator comparator = new EmployeeComparator();
        if (comparator.compare(o1,o2) !=0 ) {
            return comparator.compare(o1,o2);
        } else return Integer.compare(o1.getLevel().ordinal(),o2.getLevel().ordinal());
    }
}
