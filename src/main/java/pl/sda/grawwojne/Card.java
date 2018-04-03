package pl.sda.grawwojne;

public class Card {

    private Ranks rank;
    private Suits suit;
    private int weight;

    public Card(Ranks rank, Suits suit, int weight) {
        this.rank = rank;
        this.suit = suit;
        this.weight = weight;

    }

    public Ranks getRank() {
        return rank;
    }

    public void setRank(Ranks rank) {
        this.rank = rank;
    }

    public Suits getSuit() {
        return suit;
    }

    public void setSuit(Suits suit) {
        this.suit = suit;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return rank.toString() + " " + suit.toString()+ " Waga: " + weight;
    }
}
