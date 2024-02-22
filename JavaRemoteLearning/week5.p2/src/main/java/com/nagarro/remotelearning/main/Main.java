package com.nagarro.remotelearning.main;

import com.nagarro.remotelearning.proxy.ProxyFactory;
import com.nagarro.remotelearning.util.Image;
import com.nagarro.remotelearning.util.RealImage;


public class Main {
    public static void main(String[] args) {
        RealImage realImage = new RealImage();

        Image proxy = ProxyFactory.createProxy(Image.class, realImage);

        proxy.display();
    }
}


