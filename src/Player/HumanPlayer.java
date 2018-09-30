package Player;

import Cards.Card;
import Table.Row;
import java.util.List;
import java.util.Random;

public class HumanPlayer extends Player{
    
    public HumanPlayer(String name, List<Card> deck) {
        super(name, deck);
    }
    
    public Card getCard(){
        if ( super.hand.size() == 0){
            System.out.println("OUT OF CARDS");
            return null;
        }
        Random rand = new Random();
        int i = rand.nextInt(super.hand.size());
        
        Card selected = super.hand.get(i);
        super.hand.remove(i);
        System.out.println("Hand size: " + super.hand.size());
        System.out.println("Card name: " + selected.getName());
        return selected;
    }
    
    public List<Card> getHand(){
        return this.hand;
    }
    
    public Row getRow(int r){
        return this.table.getRow(r);
    }
    
    public void addToTable(Card card,int player){
        if(card != null){
            System.out.println("addToTable: Card name: " + card.getName());
            super.table.addCard(card, player);
        }
        
    }
    
   
}
