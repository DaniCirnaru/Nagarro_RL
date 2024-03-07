package com.nagarro.remotelearning;

import org.junit.Test;

import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.List;


public class DeckTest {
    @Test
    public void testShuffle() {

        Deck deck = new Deck();
        List<Card> originalDeck = new ArrayList<>(deck.getCards());

        deck.shuffleCards();

        List<Card> shuffledDeck = deck.getCards();

        assertNotEquals(originalDeck, shuffledDeck);
    }

}

