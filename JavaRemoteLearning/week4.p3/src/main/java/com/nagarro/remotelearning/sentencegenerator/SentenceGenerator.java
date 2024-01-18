package com.nagarro.remotelearning.sentencegenerator;

import java.util.Random;

public class SentenceGenerator {
    private String[] articles;
    private String[] nouns;
    private String[] verbs;
    private String[] prepositions;
    private Random random;

    public SentenceGenerator() {
        this.articles = new String[]{"the", "a", "one", "some", "any"};
        this.nouns = new String[]{"boy", "girl", "dog", "town", "car"};
        this.verbs = new String[]{"drove", "jumped", "ran", "walked", "skipped"};
        this.prepositions = new String[]{"to", "from", "over", "under", "on"};
        this.random = new Random();
    }

    public String generateSentence() {
        return String.format(
                "%s %s %s %s %s %s.",
                capitalize(articles[random.nextInt(articles.length)]),
                nouns[random.nextInt(nouns.length)],
                verbs[random.nextInt(verbs.length)],
                prepositions[random.nextInt(prepositions.length)],
                articles[random.nextInt(articles.length)],
                nouns[random.nextInt(nouns.length)]
        );
    }
    private String capitalize(String s) {

        return Character.toUpperCase(s.charAt(0)) + s.substring(1);
    }
}