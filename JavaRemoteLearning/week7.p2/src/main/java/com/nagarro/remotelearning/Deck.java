package com.nagarro.remotelearning;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Deck {
    private List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        for (String suit : suits) {
            for (int i = 1; i <= 13; i++) {
                cards.add(new Card(i,suit));
            }
        }
    }

    public void shuffleCards() {
        Collections.shuffle(cards);
    }

    public List<Card> getCards() {
        return cards;
    }
}

