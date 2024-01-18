package com.nagarro.remotelearning.storygenerator;

import com.nagarro.remotelearning.sentencegenerator.SentenceGenerator;

public class ShortStoryGenerator extends SentenceGenerator {

    public ShortStoryGenerator() {
        super();
    }

    public String generateShortStory(int numSentences) {
        StringBuilder story = new StringBuilder();

        for (int i = 0; i < numSentences; i++) {
            story.append(generateSentence()).append("\n");
        }

        return story.toString().trim();
    }
}
