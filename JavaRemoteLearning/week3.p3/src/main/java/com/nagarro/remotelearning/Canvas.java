package com.nagarro.remotelearning;

import model.GraphicalObject;

import java.util.ArrayList;
import java.util.List;

public class Canvas implements GraphicalObject {
    private List<GraphicalObject> objects;

    public Canvas() {
        objects = new ArrayList<>();
    }

    public void add(GraphicalObject object) {
        objects.add(object);
    }

    @Override
    public void draw() {
        for (GraphicalObject object : objects) {
            object.draw();
        }
    }
}
