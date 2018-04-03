package pl.sda.grawwojne;

public class StatiscticsSingleton {
    private static final StatiscticsSingleton instance = new StatiscticsSingleton();

    public static StatiscticsSingleton getInstance() {
        return instance;
    }

    int WarCounter;
    int player1Won;
    int player2Won;
    int biggestWar;

    public void setWarCounter(int warCounter) {
        WarCounter = warCounter;
    }

    public void setPlayer1Won(int player1Won) {
        this.player1Won = player1Won;
    }

    public void setPlayer2Won(int player2Won) {
        this.player2Won = player2Won;
    }

    public void setBiggestWar(int biggestWar) {
        this.biggestWar = biggestWar;
    }

    public void war() {
        WarCounter++;
    }

    public void player1won() {
        player1Won++;
    }

    public void player2won() {
        player2Won++;
    }

    @Override
    public String toString() {
        return "Statystyki \n"
                + "Ilosc wojen: " + WarCounter
                + ", pierwszy gracz wygrał :" + player1Won
                + ", drugi gracz wygrał: " + player2Won
                + ", największa wojna: " + biggestWar;
    }

    public void setBiggest(int counter) {
        if (this.biggestWar<counter) {
            biggestWar = counter;
        }
    }
}
