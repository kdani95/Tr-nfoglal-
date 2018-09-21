package tronfoglalo;

import Cards.Card;
import Common.Types;
import Player.Player;
import Table.Table;

public class Start {

    public static void main(String[] args) {
        Table table = new Table();
        //Player one = new Player("one");
        Card card1 = new Card("card1", 3, "asd", 0, Types.RowLoc.FRONT);
        table.addCard(card1, 1);
        System.out.println(table.getPlayerOnePoints());
        
        Card card2 = new Card("card2", 5, "asd", -1 , Types.RowLoc.FRONT);
        Card card3 = new Card("card2", 0, "asd", 3 , Types.RowLoc.FRONT);
        table.addCard(card2, 1);
        table.addCard(card3, 1);
        System.out.println(table.getPlayerOnePoints());
        
    }
    
}
