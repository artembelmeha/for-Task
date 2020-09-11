package Task5;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int [] getXYPair() {
        int [] XYpair = new int[]{x,y};
        return XYpair;
    }
    public double distance (int x, int y) {
        return Math.sqrt((Math.pow((x - this.x), 2) + (Math.pow((y - this.y),2))));
    }
    public double distance (Point t) {
        return distance(t.x, t.y);
    }
    public double distance () {
        return distance(0,0);
    }
}
