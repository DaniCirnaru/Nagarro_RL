package com.nagarro.remotelearning.titlelizerapp;

import com.nagarro.util.Titlelizer;

import java.util.ArrayList;
import java.util.Arrays;

public class TitlelizeApp implements Titlelizer {
    final String[] wordsList = {"the", "a", "to", "in", "of"};
    final ArrayList<String> ignoreWords = new ArrayList<String>(Arrays.asList(wordsList));
    final String regex=" ";
    private String title;

    public TitlelizeApp(String title) {
        this.title = title;
    }

    public String titlelize(String word) {

        if (!ignoreWords.contains(word))
            word = word.substring(0, 1).toUpperCase() + word.substring(1);

        return word;
    }

    public String titlelizeString() {
        String[] words = title.split(regex);

        StringBuilder resultBuilder = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            words[i] = titlelize(words[i]);
            resultBuilder.append(words[i]);
            if (i < words.length - 1) {
                resultBuilder.append(" ");
            }
        }

        return resultBuilder.toString();
    }

}
