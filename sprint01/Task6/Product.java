package Task6;

public class Product {
    private String name;
    private double price;
    private static int count;

    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
        count++;
    }
    public Product() {
        count++;
    }
    public static int count() {
        return count;
    }
}
