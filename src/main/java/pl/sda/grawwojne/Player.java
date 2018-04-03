package pl.sda.grawwojne;

public class Player {

    private String name;
    private Decks pile;

    public Player(String name) {
        this.name = name;
    }

    public Player(String name, Decks pile) {
        this.name = name;
        this.pile = pile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Decks getPile() {
        return pile;
    }

    public void setPile(Decks pile) {
        this.pile = pile;
    }

    @Override
    public String toString() {
        return pile.toString();
    }
}
