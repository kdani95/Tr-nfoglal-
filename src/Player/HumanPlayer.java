package Player;

import Cards.Card;
import Logic.Row;
import java.util.List;
import java.util.Random;

public class HumanPlayer extends Player{
    
    public HumanPlayer(String name, List<Card> deck) {
        super(name, deck);
    }
    
    public void addCard(Card c){
        hand.add(c);
    }
    
    public Card getCard(){
        if ( hand.size() == 0){
            //System.out.println("OUT OF CARDS");
            return null;
        }
        Random rand = new Random();
        int i = rand.nextInt(hand.size());
        
        Card selected = super.hand.get(i);
        hand.remove(i);
        return selected;
    }
    
    public List<Card> getHand(){
        return this.hand;
    }
    
    public Row getRow(int r){
        if(r < 4){
            return this.table.getRow(r);
        }else{
            return this.table.getRow(4);
        }  
    }
    
    public void addToTable(Card card,int player){
        if(card != null){
            super.table.addCard(card, player);
        }
    }
}
