package com.nagarro.main;

import com.nagarro.remotelearning.titlelizerapp.TitlelizeApp;

public class Main {
    public static void main(String[] args) {
        String inputString = "now is the time to act!";
        TitlelizeApp titlelizer = new TitlelizeApp(inputString);
        String result = titlelizer.titlelizeString();
        System.out.println(result);
    }
}

