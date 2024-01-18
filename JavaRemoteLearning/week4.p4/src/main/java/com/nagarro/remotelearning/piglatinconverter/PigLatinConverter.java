package com.nagarro.remotelearning.piglatinconverter;

import java.util.StringTokenizer;

public class PigLatinConverter {
    public void convert(String phrase) {
        StringTokenizer tokenizer = new StringTokenizer(phrase);

        while (tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken();
            printLatinWord(word);
        }
    }

    private void printLatinWord(String word) {
        if (word.length() > 1) {
            char firstLetter = Character.toLowerCase(word.charAt(0));
            String restOfWord = word.substring(1);
            String convertedWord = restOfWord + firstLetter;
            System.out.print(convertedWord + "ay ");
        } else {
            System.out.print(word + " ");
        }
    }
}
