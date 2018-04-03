package pl.sda.grawwojne;

import java.util.*;

public class GameOfWars {


    public static void main(String[] args) {
        Decks deck = new Decks();
        deck.create();
        deck.shuffle();

        int counter = 0;

        Player patryk = new Player("Patryk");
        Player dorota = new Player("Dorota");

        deck.deal(patryk, dorota);

        //System.out.println(patryk.getPile().toString());
        // System.out.println(dorota.getPile().getDeck().toString());
        List<Card> lista = patryk.getPile().getDeck();
        List<Card> lista2 = dorota.getPile().getDeck();

        System.out.println(lista);

        Queue<Card> kupka1 = new LinkedList<>(lista);
        Queue<Card> kupka2 = new LinkedList<>(lista2);

        boolean wojna = false;
        while (!kupka1.isEmpty() && !kupka2.isEmpty()) {
            Card karta1 = kupka1.remove();
            System.out.print(karta1.getWeight()+ " XXXX ");
            Card karta2 = kupka2.remove();
            System.out.print(karta2.getWeight());
            System.out.println();
            System.out.println();
            System.out.println(kupka1.size() + " vs " + kupka2.size());
            if((kupka1.size() + kupka2.size()) != 50){
                System.out.println("AAAA!");
            }

            if (karta1.getWeight() == karta2.getWeight()) {
                //System.err.println("WOJNA!!!!!!!!");
                wojna = true;
                List<Card> list = new ArrayList<>();
                list.add(karta1);
                list.add(karta2);
                while (wojna /*&& kupka1.size() > 1 && kupka2.size() > 1*/) {
                    // Zakrycie po jednej karcie
                    if(kupka1.size() < 2){
                        System.out.println("XXX");
                        wojna = false;
                    }else if(kupka2.size() <2) {
                        System.out.println("XXX");
                        wojna = false;
                    }
                    list.add(kupka1.remove());
                    list.add(kupka2.remove());
                    // Ponowne wylozenie po jedenj karcie
                    karta1 = kupka1.remove();
                    karta2 = kupka2.remove();
                    StatiscticsSingleton.getInstance().war();
                    counter++;
                    //Ponowne porownanie
                    if (karta1.getWeight() > karta2.getWeight()) {
                        kupka1.add(karta1);
                        kupka1.add(karta2);
                        kupka1.addAll(list);
                        list.clear();
                        StatiscticsSingleton.getInstance().player1won();
                        wojna = false;

                    } else if (karta1.getWeight() < karta2.getWeight()) {
                        kupka2.add(karta1);
                        kupka2.add(karta2);
                        kupka2.addAll(list);
                        list.clear();
                        StatiscticsSingleton.getInstance().player2won();
                        wojna = false;

                    }else
                    if (karta1.getWeight() == karta2.getWeight()) {
                        list.add(karta1);
                        list.add(karta2);
                    }
                }
                if(!list.isEmpty()){
                    System.out.println("Bum!");
                }
                StatiscticsSingleton.getInstance().setBiggest(counter);
                counter = 0;
            } else if (karta1.getWeight() > karta2.getWeight()) {
                //System.out.println("Karty Patryka");
                kupka1.add(karta1);
                kupka1.add(karta2);

            } else if (karta1.getWeight() < karta2.getWeight()) {
                //System.out.println("Karty Doroty");
                kupka2.add(karta1);
                kupka2.add(karta2);

            }
        }
        if (kupka1.isEmpty()) {
            System.out.println("Wygrała Dorota");
        } else {
            System.out.println("Wygrał Patryk");
        }
        System.out.println(StatiscticsSingleton.getInstance().toString());
        System.out.println("Koniec");

    }

}



