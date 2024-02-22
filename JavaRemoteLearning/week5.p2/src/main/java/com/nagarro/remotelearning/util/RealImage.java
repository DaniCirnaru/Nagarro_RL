package com.nagarro.remotelearning.util;

import com.nagarro.remotelearning.annotations.Logged;


public class RealImage implements Image {

    @Override
    @Logged
    public void display() {
        System.out.println("Displaying RealImage");
    }
}
