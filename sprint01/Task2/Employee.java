package Task2;


class Employee {
    public String fullName;
    public float salary;

    public static void main(String[] args) {
        Employee emp1 = new Employee();
        Employee emp2 = new Employee();
        emp1.fullName = "Serj";
        emp1.salary = 10000f;
        emp2.fullName = "Ivan";
        emp2.salary = 15000f;
        Employee [] employees = new Employee[] {emp1,emp2};
        String employeesInfo = "[";
        for (Employee employee: employees) {
            employeesInfo += String.format("{fullName: \"%s\", salary: %.1f}, ",employee.fullName,
                    employee.salary);
        }
        employeesInfo = employeesInfo.substring(0, employeesInfo.length()-2)+"]";
        System.out.println(employeesInfo);
    }
}
