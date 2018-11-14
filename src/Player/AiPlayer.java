package Player;

import Cards.Card;
import Logic.Controller;
import Logic.Row;
import Logic.Table;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AiPlayer extends Player{
    
    private boolean playSmallCards = false;
    private int startHandSize;
    private int placedCards = 0;
    private Logic.Table handTable;
    
    public AiPlayer(String name, List<Card> deck) {
        super(name, deck);
        startHandSize = hand.size();
        handTable = new Table();
    }
    
    public void addCard(Card c){
        int i = 0;
        boolean notAdded = true;
        while( i < hand.size() && notAdded){
            if( hand.get(i).getStrength() > c.getStrength()){
                notAdded= false;
            }else{
                i++;
            }
        }
        hand.add(i, c);
        //System.out.println("AI ADDED");
    }
    
    public Card getCard(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(AiPlayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        if ( super.hand.size() == 0){
            System.out.println("OUT OF CARDS");
            return null;
        }
        
        System.out.println("ENEMY PASSED: " + enemyPassed + " --------------------------------");
        if (enemyPassed && getPlayerOnePoints() > getPlayerTwoPoints()){
            return null;
        }
        
        if(Controller.getDifficulty() > 2){
            if(lives > 1 && !playSmallCards){
                //play small cards
                Random rand = new Random();
                int i = rand.nextInt(2);
                if(i == 0){
                    playSmallCards = false;
                    System.out.println("AI NOT PLAYING SMALL CARDS");
                }
                if(i == 1){
                    playSmallCards = true;
                    System.out.println("AI PLAYING SMALL CARDS");
                }
            }
        }
        
        if(playSmallCards && lives > 1){
            Random rand = new Random();
            int i = rand.nextInt(startHandSize + 2);
            if(i >= ( startHandSize ) - placedCards){
                return null;
            }
            placedCards++;
            Card selectedCard = hand.get(0);
            hand.remove(0);
            return selectedCard;
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
                    selectedValue = handTable.tryCard(hand.get(selected));
                }
            }else{
                selected = i;
            }
            
        }        
        
        if(Controller.getDifficulty() > 1){
            if( ( (selected >= hand.size()/2) || playSmallCards ) && lives > 1){
                System.out.println("LIVES: " + lives + " playSmallCard: " + playSmallCards);
                Random rand = new Random();
                int i = rand.nextInt(2);
                if(i == 0){
                    return null;
                }
                if(i == 1){
                    selected = 0;
                }
            }
        }

        
        System.out.println("selected: " + hand.get(selected).getName());
        
        Card selectedCard = hand.get(selected);
        hand.remove(selected);
        //System.out.println("Hand size: " + super.hand.size());
        //System.out.println("Card name: " + selectedCard.getName());
        placedCards++;
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
            //System.out.println("addToTable: Card name: " + card.getName());
            super.table.addCard(card, player);
        }
        
    }
    
    private int getValue(Card card){
        handTable = new Logic.Table();
        int value = 0;
        for(Card c : hand){
            if(card.getRow() == c.getRow()){
                handTable.addCard(c,1);
            }
        }
        value = handTable.tryCard(card);
        System.out.println(card.getName() + " value:" + value);
        return value;
    }
   
}
