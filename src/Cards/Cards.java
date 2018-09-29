package Cards;

import Common.Types;
import java.util.ArrayList;
import java.util.List;

public class Cards {
    
    private static List<Card> cards = new ArrayList<Card>();
    
    public static void init(){
        Cards.cards.clear();
        
        Card card1 = new Card(0,"asd1", 5, "Geralt.png", 0, 0);
        Card card2 = new Card(1,"asd2", 10, "Geralt.png", 0, 1);
        Card card3 = new Card(2,"asd3", 1, "Geralt.png", 0, 0);
        
        Cards.cards.add(card1);
        Cards.cards.add(card2);
        Cards.cards.add(card3);
    }
    
    public static void addCard(Card card){
        Cards.cards.add(new Card(card));
    }
    
    public static Card getCard(int i){
        return new Card(cards.get(i));
    }
}
