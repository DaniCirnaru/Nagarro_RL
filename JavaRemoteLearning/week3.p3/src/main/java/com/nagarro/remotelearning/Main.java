package com.nagarro.remotelearning;

import shapes.Circle;
import shapes.Line;
import shapes.Point;
import shapes.Rectangle;

public class Main {
    public static void main(String[] args) {

        Point p1 = new Point(10, 20);
        Point p2 = new Point(30, 40);
        Line line = new Line(p1, p2);

        Point topLeft = new Point(5, 5);
        Point topRight = new Point(15, 5);
        Point bottomLeft = new Point(5, 15);
        Point bottomRight = new Point(15, 15);
        Rectangle rectangle = new Rectangle(topLeft, topRight, bottomLeft, bottomRight);

        Canvas canvas = new Canvas();
        canvas.add(line);
        canvas.add(rectangle);

        Canvas nestedCanvas = new Canvas();
        nestedCanvas.add(new Circle(new Point(50, 50), 10));
        canvas.add(nestedCanvas);

        canvas.draw();
    }
}
