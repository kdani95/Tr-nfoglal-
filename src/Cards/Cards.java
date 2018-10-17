package Cards;

import Common.Types;
import java.util.ArrayList;
import java.util.List;

public class Cards {
    
    private static List<Card> cards = new ArrayList<Card>();
    
    public static void init(){
        Cards.cards.clear();
        
        //LOVAG
        Card card1 = new Card(0,"Knight", 9, "knight.png", 0, 0);
        //
        Card card2 = new Card(1,"Archer", 5, "archer.png", 0, 1);
        //
        Card card3 = new Card(2,"Peasant", 2, "peasant.png", 0, 0);
        //
        Card card4 = new Card(3,"King", 10, "king.png", 4, 0);
        
        Card card5 = new Card(4,"Catapult", 7, "catapult.png", 0, 1);
        
        Card card6 = new Card(5,"Sorcerer", 7, "sorcerer.png", 2, 1);
        
        Card card7 = new Card(6,"Rider", 8, "rider.png", -2, 0);
        
        
        Cards.cards.add(card1);
        Cards.cards.add(card2);
        Cards.cards.add(card3);
        Cards.cards.add(card4);
        Cards.cards.add(card5);
        Cards.cards.add(card6);
        Cards.cards.add(card7);

    }
    
    public static void addCard(Card card){
        Cards.cards.add(new Card(card));
    }
    
    public static Card getCard(int i){
        return new Card(cards.get(i));
    }
}
