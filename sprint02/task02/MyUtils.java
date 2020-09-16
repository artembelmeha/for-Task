package task02;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

interface DrinkReceipt {
    public String getName();
    public DrinkReceipt addComponent(String componentName, int componentCount);
}
interface DrinkPreparation {
    public Map<String, Integer> makeDrink();
}
interface Rating {
    public int getRating();
}
class Caffee implements DrinkReceipt, DrinkPreparation, Rating {
    private String name;
    private int rating;
    private Map<String, Integer> ingredients =new HashMap<>();

    public Caffee(String name, int rating) {
        this.name = name;
        this.rating = rating;
    }
    public Map<String, Integer> getIngredients() {
        return ingredients;
    }

    @Override
    public int getRating() {
        return rating;
    }

    @Override
    public String getName() {
        return name;
    }




    @Override
    public Map<String, Integer> makeDrink() {
       addComponent("Water", 100);
       addComponent("Arabica", 20);
       return getIngredients();
    }

    @Override
    public DrinkReceipt addComponent(String componentName, int componentCount) {
        ingredients.put(componentName,componentCount);
        return this;
    }
}
class Espresso extends Caffee {
    public Espresso(String name, int rating) {
        super(name, rating);
    }

    @Override
    public Map<String, Integer> makeDrink() {
        addComponent("Water", 50);
        addComponent("Arabica", 20);
        return getIngredients();
    }
}
class Cappuccino extends Caffee {
    public Cappuccino(String name, int rating) {
        super(name, rating);
    }

    @Override
    public Map<String, Integer> makeDrink() {
        addComponent("Water", 100);
        addComponent("Arabica", 20);
        addComponent("Milk", 50);
        return getIngredients();
    }
    // Code
}
public class MyUtils {
    public Map<String, Double> averageRating(List<Caffee> coffees) {
        return coffees.stream()
                .collect(Collectors.groupingBy(Caffee::getName,
                        Collectors.averagingDouble(Caffee::getRating)));

    }


}

