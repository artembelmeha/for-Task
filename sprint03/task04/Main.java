package task04;

enum LineType {
    SOLID, DOTTED, DASHED, DOUBLE;
}

public class Main {
    public static String drawLine(LineType lineType) {
        return String.format("The line is %s type", lineType.toString().toLowerCase());
    }
}
