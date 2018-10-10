package Cards;

import Common.Types;
import java.util.ArrayList;
import java.util.List;

public class Cards {
    
    private static List<Card> cards = new ArrayList<Card>();
    
    public static void init(){
        Cards.cards.clear();
        
        Card card1 = new Card(0,"Triss", 7, "Triss.png", 2, 1);
        Card card2 = new Card(1,"Geralt", 10, "Geralt.png", 0, 0);
        Card card3 = new Card(2,"Vesemir", 6, "Vesemir.png", 0, 1);
        
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
