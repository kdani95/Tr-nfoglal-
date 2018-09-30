package tronfoglalo;

import Cards.Card;
import Cards.Cards;
import Client.Client;
import Player.HumanPlayer;
import Player.Player;
import Table.Row;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    static GUI.Tronfoglalo  tronfoglalo;
    static List<Card> deck = new ArrayList<Card>();
    static Player player;
       
    public static void start(){
        Cards.init();
        Controller.tronfoglalo = new GUI.Tronfoglalo();
        
        tronfoglalo.run();
        
        deck.add(Cards.getCard(0));
        deck.add(Cards.getCard(1));
        deck.add(Cards.getCard(0));
        deck.add(Cards.getCard(1));
        deck.add(Cards.getCard(2));
        
        player = new HumanPlayer("ASDASD", deck);
        
        tronfoglalo.refreshHandRow();
    }
    
    public static void refreshRow(int r){
        Row row = player.getRow(r);
        System.out.println("Row points = " + row.getPoints());
        tronfoglalo.refreshRow(row.getCards() , r , row.getPoints() );
    }
    
    public static void refreshHandRow(){
        //System.out.println("Refresh hand row");
        //System.out.println("player.getHand = " + player.getHand().size());
        tronfoglalo.refreshHandRow();
    }
    
    public static void addCard(Card card, int p){
        player.addToTable(card, p);
        for(int i = 0; i < 4; i++){
            refreshRow(i);
        }
    }
    
    public static List<Card> getHand(){
        return player.getHand();
    }
    
    public static Row getRow(int i){
        return player.getRow(i);
    }
    
    public static void removeCard(Card card){
        player.getHand().remove(card);
    }
    
    
}
