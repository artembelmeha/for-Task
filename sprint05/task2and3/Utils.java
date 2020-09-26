package task2and3;
enum Color {
    WHITE, RED, BLUE
}
enum Type {
    RARE, ORDINARY
}
class Plant {
    private String name;
    private Color color;
    private Type type;

    public Plant(String type,String color,String name) throws ColorException, TypeException{
        this.name = name;
        for(Color value: Color.values()) {
            if(value.name().equalsIgnoreCase(color))
                this.color =Color.valueOf(color.toUpperCase());
        } if (this.color == null)  throw new ColorException("Invalid value "+color+ " for field color");
        for(Type value: Type.values()) {
            if(value.name().equalsIgnoreCase(type))
                this.type = Type.valueOf(type.toUpperCase());
        } if (this.type == null) throw new TypeException("Invalid value " + type+ " for field type");
    }


    public static Plant tryCreatePlant(String type, String color, String name) {
        Plant plant;
        try {
            plant =  new Plant(type, color, name);
        } catch (ColorException e) {
            plant = tryCreatePlant(type,"RED", name);
        } catch (TypeException e) {
            plant = tryCreatePlant("ORDINARY",color, name);
        }
        return plant;

    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return  "{type: "+ type +
                ", color: " + color +
                ", name: " + name+"}";
    }
}
class ColorException extends Exception {
    public ColorException(String message) {
        super(message);
    }
}
class TypeException extends Exception {
    public TypeException(String message) {
        super(message);
    }
}

public class Utils {
    public static void main(String[] args) {
            Plant plant = Plant.tryCreatePlant("rare", "white", "New");
            System.out.println(plant.toString());



    }
}
