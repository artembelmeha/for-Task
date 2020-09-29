
import java.util.ArrayList;
import java.util.List;

class Person{
    String name;

    Person(String name){
        this.name = name;
    }
    DecisionMethod goShopping = ((p,d)-> (p.equals("product1")) && (d > 10));
}

// Create DecisionMethod interface here

class Shop{
    public List<DecisionMethod> clients = new ArrayList<>();

    public int sale(String product, int percent) {
        int count =0;
        for (DecisionMethod personDeci: clients) {
            if(personDeci.decide(product,percent))
                count++;
        }
        return count;

    }
}

@FunctionalInterface
interface DecisionMethod{
    public boolean decide(String name, int discount);
}
public class Test {
}