package com.nagarro.remotelearning.week3p1;
import child.Frog;
import parent.Amphibian;

public class Main
{
    public static void main( String[] args )
    {

        Amphibian amphibian = new Frog();
        amphibian.swim();
        amphibian.jump();
        //amphibian.speak();
    }
}
