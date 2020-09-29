package sprint06;
import java.util.function.BinaryOperator;
import java.util.ArrayList;
import java.util.List;
public class Appp {
    static BinaryOperator<String> greetingOperator = (par1,par2)->"Hello "+par1+" "+par2+"!!!";
    // Write your code here

    public static List<String> createGreetings(List<Person> people, BinaryOperator<String> operator){
        List<String> result = new ArrayList<>();
        for (Person person: people)
            result.add(operator.apply(person.name, person.surname));
        return result;
        // Write your code here

    }
}
