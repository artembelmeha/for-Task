package task04;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;


class Employee {
    private String name;
    private int experience;
    private BigDecimal basePayment;

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }

    public BigDecimal getPayment() {
        return basePayment;
    }

    public Employee(String name, int experience, BigDecimal basePayment) {
        this.name = name;
        this.experience = experience;
        this.basePayment = basePayment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return getExperience() == employee.getExperience() &&
                Objects.equals(getName(), employee.getName()) &&
                Objects.equals(basePayment, employee.basePayment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getExperience(), basePayment);
    }
}
class Manager extends Employee {
    private double coefficient;

    @Override
    public BigDecimal getPayment() {
        return super.getPayment().multiply(BigDecimal.valueOf(coefficient));
    }

    @Override
    public int getExperience() {
        return super.getExperience();
    }

    public double getCoefficient() {
        return coefficient;
    }

    public Manager(String name, int experience, BigDecimal basePayment, double coefficient) {
        super(name, experience, basePayment);
        this.coefficient = coefficient;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Manager)) return false;
        if (!super.equals(o)) return false;
        Manager manager = (Manager) o;
        return Double.compare(manager.getCoefficient(), getCoefficient()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getCoefficient());
    }
}
public class MyUtils {
     public List<Employee> largestEmployees(List<Employee> workers) {

        ArrayList<Employee> arr = new ArrayList<>();
        if (workers == null)
            return null;

        int maxExpEm = 0;
        int maxExpMa = 0;
        BigDecimal maxPaymaEm = BigDecimal.valueOf(0);
        BigDecimal maxPaymaMa = BigDecimal.valueOf(0);
        for (Employee emp:workers) {
            if (emp.getClass().equals(Manager.class)) {
                if (maxExpMa<emp.getExperience())
                    maxExpMa = emp.getExperience();
                maxPaymaMa = maxPaymaMa.max(emp.getPayment());
            }
            if (emp.getClass().equals(Employee.class)) {
                if (maxExpEm<emp.getExperience())
                    maxExpEm = emp.getExperience();
                maxPaymaEm = maxPaymaEm.max(emp.getPayment());
            }

        }
        for (Employee emp:workers) {
            if (emp.getClass().equals(Employee.class)) {
                if(emp.getExperience() == maxExpEm) {
                    if(!arr.contains(emp))
                        arr.add(emp);
                }
                if(emp.getPayment()==maxPaymaEm) {
                    if(!arr.contains(emp))
                        arr.add(emp);
                }
            }
            if (emp.getClass().equals(Manager.class)) {
                if(emp.getExperience() == maxExpMa) {
                    if(!arr.contains(emp))
                        arr.add(emp);
                }
                if(emp.getPayment()==maxPaymaMa) {
                    if(!arr.contains(emp))
                        arr.add(emp);
                }
            }
        }


         return arr;

    }



}



