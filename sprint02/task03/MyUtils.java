package task03;

import java.util.*;
import java.util.stream.Collectors;

class Person {
    private String name;

    public String getName() {
        return name;
    }

    public Person(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(getName(), person.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
class Student extends Person {
    private String studyPlace;
    private int studyYears;

    public String getStudyPlace() {
        return studyPlace;
    }

    public int getStudyYears() {
        return studyYears;
    }

    public Student(String name, String studyPlace, int studyYear) {
        super(name);
        this.studyPlace = studyPlace;
        this.studyYears = studyYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return getStudyYears() == student.getStudyYears() &&
                getStudyPlace().equals(student.getStudyPlace());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStudyPlace(), getStudyYears());
    }
}
class Worker extends Person {
    private String workPosition;
    private int experienceYears;

    public String getWorkPosition() {
        return workPosition;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public Worker(String name, String workPosition, int experienceYears) {
        super(name);
        this.workPosition = workPosition;
        this.experienceYears = experienceYears;
    }

}
public class MyUtils {
    public List<Person> maxDuration(List<Person> persons) {
        List<Person> res = new ArrayList<>();
        int maxStudyYear = 0;
        int maxExperienceYears = 0;
        for (Person person:persons) {
            if (person instanceof Student) {
                if (maxStudyYear < ((Student) person).getStudyYears())
                    maxStudyYear = ((Student) person).getStudyYears();
            }
            if (person instanceof Worker) {
                if (maxExperienceYears < ((Worker) person).getExperienceYears())
                    maxExperienceYears = ((Worker) person).getExperienceYears();
            }
        }
        for (Person person:persons) {
            if (person instanceof Student) {
                if (((Student) person).getStudyYears() == maxStudyYear)
                    if(!res.contains(person))
                        res.add(person);
            }
            if (person instanceof Worker) {
                if (((Worker) person).getExperienceYears() == maxExperienceYears) {
                    if(!res.contains(person))
                        res.add(person);
                }

            }
        }
        return res;
    }
}

