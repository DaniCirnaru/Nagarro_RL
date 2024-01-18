package com.nagarro.remotelearning.storygenerator;

import com.nagarro.remotelearning.sentencegenerator.SentenceGenerator;

public class StoryGenerator extends SentenceGenerator {

    public StoryGenerator() {
        super();
    }

    public String generateStory(int numSentences) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < numSentences; i++) {
            result.append(generateSentence()).append("\n");
        }

        return result.toString();
    }
}

