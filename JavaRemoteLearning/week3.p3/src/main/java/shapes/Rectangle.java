package shapes;

import model.GraphicalObject;


import java.util.ArrayList;
import java.util.List;

public class Rectangle implements GraphicalObject {
    private List<Line> lines;

    public Rectangle(Point topLeft, Point topRight, Point bottomLeft, Point bottomRight) {
        lines = new ArrayList<Line>();
        lines.add(new Line(topLeft, topRight));
        lines.add(new Line(topRight, bottomRight));
        lines.add(new Line(bottomRight, bottomLeft));
        lines.add(new Line(bottomLeft, topLeft));
    }

    @Override
    public void draw() {
        System.out.println("Drawing Rectangle:");
        for (Line line : lines) {
            line.draw();
        }
    }
}
