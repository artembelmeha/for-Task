package task6;

import java.util.Comparator;

public class EmployeeComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        if (new PersonComparator().compare(o1,o2) !=0 ) {
            return new PersonComparator().compare(o1,o2);
        } else return Double.compare(o1.getSalary(),o2.getSalary());
    }
}
