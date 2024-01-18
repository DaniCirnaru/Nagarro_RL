package com.nagarro.remotelearning.main;

import com.nagarro.remotelearning.storygenerator.ShortStoryGenerator;
import com.nagarro.remotelearning.storygenerator.StoryGenerator;

public class Main {

    public static void main(String[] args) {
        int numSentences = 20;

        StoryGenerator storyGenerator = new StoryGenerator();
        String generatedSentences = storyGenerator.generateStory(numSentences);
        System.out.println("Generated Story:\n" + generatedSentences);

        ShortStoryGenerator shortStoryGenerator = new ShortStoryGenerator();
        int numShortStorySentences = 5; // Specify the number of sentences for the short story
        String shortStory = shortStoryGenerator.generateShortStory(numShortStorySentences);
        System.out.println("\nGenerated Short Story:\n" + shortStory);
    }
}