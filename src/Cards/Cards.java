package Cards;

import java.util.ArrayList;
import java.util.List;

public class Cards {
    
    private static List<Card> cards = new ArrayList<Card>();
    
    public static void addCard(Card card){
        Cards.cards.add(new Card(card));
    }
    
    public static Card getCard(int i){
        return new Card(cards.get(i));
    }
}
