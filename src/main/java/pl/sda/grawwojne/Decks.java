package pl.sda.grawwojne;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Decks {

    private List<Card> deck = new LinkedList<>();

    public Decks() {
    }

    public Decks(List<Card> deck) {
        this.deck = deck;
    }

    public List<Card> getDeck() {
        return deck;
    }

    public void setDeck(List<Card> deck) {
        this.deck = deck;
    }

    public void shuffle() {
        Collections.shuffle(deck);
    }

    public void create() {
        for (Suits s : Suits.values()) {
            int weight = 2;
            for (Ranks r : Ranks.values()) {
                Card c = new Card(r, s, weight);
                deck.add(c);
                weight++;
            }
        }
    }

    public void deal(Player player1, Player player2) {
        List<Card> pile1 = new LinkedList<>();
        List<Card> pile2 = new LinkedList<>();
        for (int i = 0; i < deck.size(); i += 2) {
            pile1.add(deck.get(i));
        }
        Decks deck1 = new Decks(pile1);
        player1.setPile(deck1);

        for (int i = 1; i < deck.size(); i += 2) {
            pile2.add(deck.get(i));
        }

        Decks deck2 = new Decks(pile2);
        player2.setPile(deck2);
    }

    @Override
    public String toString() {
        return deck.toString();
    }
}