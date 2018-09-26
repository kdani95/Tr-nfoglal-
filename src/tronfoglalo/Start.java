package tronfoglalo;

import Cards.Card;
import Cards.Cards;
import Common.Types;
import Player.HumanPlayer;
import Player.Player;
import java.util.ArrayList;
import java.util.List;

public class Start {

    public static void main(String[] args) {
        List<Card> deck = new ArrayList<Card>();
        List<Card> deck2 = new ArrayList<Card>();
        
        Card card1 = new Card(1,"asd1", 5, "pic1", 0, Types.RowLoc.FRONT);
        Card card2 = new Card(2,"asd2", 10, "pic1", 0, Types.RowLoc.BACK);
        Card card3 = new Card(3,"asd3", 1, "pic1", 0, Types.RowLoc.FRONT);
        Cards.addCard(card1);
        Cards.addCard(card2);
        Cards.addCard(card3);
        
        deck.add(Cards.getCard(0));
        deck.add(Cards.getCard(1));
        deck.add(Cards.getCard(2));
        
        deck2.add(Cards.getCard(0));
        deck2.add(Cards.getCard(1));
        deck2.add(Cards.getCard(2));
        
        Player player = new HumanPlayer("p1",deck);
        Player player2 = new HumanPlayer("p2",deck2);
        
        player.addToTable(player.getCard(), 1);
        player.addToTable(player.getCard(), 1);
        
        player.addToTable(player2.getCard(), 2);
        player.addToTable(player2.getCard(), 2);
        
        System.out.println(player.getPlayerOnePoints());
        System.out.println(player.getPlayerTwoPoints());
    }
    
}
