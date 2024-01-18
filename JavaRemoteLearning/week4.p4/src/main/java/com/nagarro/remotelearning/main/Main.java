package com.nagarro.remotelearning.main;

import com.nagarro.remotelearning.piglatinconverter.PigLatinConverter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PigLatinConverter converter = new PigLatinConverter();
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a sentence: ");
            String userSentence = scanner.nextLine();
            converter.convert(userSentence);
            System.out.println();
        }


    }
}