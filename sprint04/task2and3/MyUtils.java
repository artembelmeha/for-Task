package task2and3;
import java.util.*;

public class MyUtils {
    public static class Student {
        private int id;
        private String name;
        // Constructor, metthods, Code

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Student)) return false;
            Student student = (Student) o;
            return id == student.id &&
                    Objects.equals(name, student.name);
        }


        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }
    }
    public Set<Student> commonStudents(List<Student> list1, List<Student> list2) {

        HashSet<Student> setStudent = new HashSet<>();
        for (Student student1:list1) {
            for (Student student2: list2) {
                if (student1!=null && student2!=null) {
                    if (student1.equals(student2))
                        setStudent.add(student1);
                }
            }

        }
        return setStudent;
    }

    public static void main(String[] args) {

    }
}