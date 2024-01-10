package shapes;

import model.GraphicalObject;

public class Circle implements GraphicalObject {
    private Point center;
    private int radius;

    public Circle(Point center, int radius) {
        this.center = center;
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Drawing Circle:");
        System.out.println("Center at " );
        center.draw();
        System.out.println("Radius: " + radius);
    }
}
