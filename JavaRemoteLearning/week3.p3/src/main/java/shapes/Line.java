package shapes;

import model.GraphicalObject;

public class Line implements GraphicalObject {
    private Point start;
    private Point end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public void draw() {
        System.out.print("Line from ");
        start.draw();
        System.out.print(" to ");
        end.draw();
    }
}
