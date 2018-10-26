package Player;

import Cards.Card;
import Logic.Row;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AiPlayer extends Player{
    
    public AiPlayer(String name, List<Card> deck) {
        super(name, deck);
    }
    
    public Card getCard(){
        if ( super.hand.size() == 0){
            System.out.println("OUT OF CARDS");
            return null;
        }
        /*
        try {
            Thread.sleep((long) 1000.0);
        } catch (InterruptedException ex) {
            Logger.getLogger(AiPlayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
        //Random rand = new Random();
        //int i = rand.nextInt(super.hand.size());
        
        
        
        //sorting
        for(int i = 0; i < hand.size()-1; i++){
            for(int j = i+1; j < hand.size(); j++){
                if(table.tryCard(hand.get(i)) > table.tryCard(hand.get(j)) ){
                    Card temp = hand.get(i);
                    hand.set(i,hand.get(j));
                    hand.set(j,temp);
                }
            }
            for(Card c : hand){
           
        }
        }
        
        int selected = 0;
        int selectedValue = 999;
        boolean bigger = false;
        String cards = "";
        for(int i = 0; i < super.hand.size() ; i++){
            cards = cards + ", " + hand.get(i).getName();
            if(getPlayerOnePoints() + table.tryCard(hand.get(i)) > getPlayerTwoPoints() ){
                bigger = true;
                if(hand.get(i).getValue() < selectedValue){
                    selected = i;
                    selectedValue = hand.get(selected).getValue();
                }
            }else{
                selected = i;
            }
            
        }        
        
        if(!bigger && lifes > 1){
            Random rand = new Random();
            int i = rand.nextInt(3);
            if(i == 0){
                return null;
            }
            if(i == 1){
                selected = 0;
            }
        }
        
        System.out.println(cards);
        System.out.println("selected: " + hand.get(selected).getName());
            
       if (super.enemyPassed && getPlayerOnePoints() > getPlayerTwoPoints()){
            //System.out.println("PASSSSSSSSSSSSSSSSSSSSSSSSSSSSSSIIIIIIIIIIIIINGGGGGGG");
            return null;
        }
        
        Card selectedCard = hand.get(selected);
        hand.remove(selected);
        System.out.println("Hand size: " + super.hand.size());
        System.out.println("Card name: " + selectedCard.getName());
        /*try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Logger.getLogger(AiPlayer.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        return selectedCard;
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
