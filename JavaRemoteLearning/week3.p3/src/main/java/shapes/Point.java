package shapes;

import model.GraphicalObject;

public class Point implements GraphicalObject {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw() {
        System.out.println("Point at (" + x + ", " + y + ")");
    }
}
