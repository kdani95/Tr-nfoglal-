package Player;

import Cards.Card;
import Logic.Controller;
import Logic.Row;
import Logic.Table;
import Statistics.Stat;
import Statistics.Stats;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AiPlayer extends Player{
    
    private boolean playSmallCards = false;
    private int startHandSize;
    private int placedCards = 0;
    private Logic.Table handTable;
    private int unitCard = 11;
    
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
            //System.out.println("OUT OF CARDS");
            return null;
        }

        if (enemyPassed && getPlayerOnePoints() > getPlayerTwoPoints()){
            return null;
        }
        
        if(Controller.getDifficulty() > 1){
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
            Card selectedCard = null;
            Random rand = new Random();
            int i = rand.nextInt(startHandSize + 2);
            if(i >= ( startHandSize ) - placedCards){
                return null;
            }
            placedCards++;
            int j = 0;
            boolean selected = false;
            while( ! selected && j < hand.size()){
                if(hand.get(j).getCardID() < unitCard){
                    System.out.println("cardID: " + hand.get(j).getCardID());
                    selected = true;
                    selectedCard = hand.get(j);
                    hand.remove(j);
                }
                j++;
            }
            return selectedCard;
        }
        
        if(Controller.getDifficulty() > 2){
            for(Card c : hand){
                if(c.getCardID() >= unitCard){
                    Random r = new Random();
                    Stat s = Stats.getStat(c.getName());
                    int points = table.tryCard(c, 1);
                    double chance = s.getChance(points);
                    
                    if(r.nextDouble() < chance){
                        Card selected = c;
                        hand.remove(c);
                        return selected;
                    }
                    
                }
            }
        }
        
        //base card selection
        int selected = 0;
        int selectedValue = 999;
        boolean bigger = false;
        String cards = "";
        for(int i = 0; i < super.hand.size() ; i++){
            cards = cards + ", " + hand.get(i).getName();
            if( getPlayerOnePoints() + table.tryCard(hand.get(i),1) > getPlayerTwoPoints() && hand.get(i).getCardID() < unitCard){
                System.out.println("cardID: " + hand.get(i).getCardID());
                bigger = true;
                if(getValue(hand.get(i)) < selectedValue){
                    selected = i;
                    selectedValue = hand.get(selected).getValue();
                }
            }else{
                selected = i;
            }
        }        
        
        if(!bigger && lives > 1){
            return null;
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
            if(card.getID() >= unitCard && player == 2){
                Stat s = Stats.getStat(card.getName());
                int before = this.getPlayerTwoPoints() - this.getPlayerOnePoints();
                //System.out.println("before points: " + getPlayerTwoPoints()  + " - " + getPlayerOnePoints());
                super.table.addCard(card, player);
                int after = this.getPlayerTwoPoints() - this.getPlayerOnePoints();
                //System.out.println("after points: " + getPlayerTwoPoints()  + " - " + getPlayerOnePoints());
                s.addStat(after - before);
            }else
            {
                super.table.addCard(card, player);
                /*
                for(Card c : this.hand){
                    System.out.print(" " + c.getName());
                }
                System.out.println(""); 
                Row x = table.getRow(1);
                System.out.println("--------------------");
                for(Card c : x.getCards()){
                    System.out.print(" " + c.getName());
                }
                System.out.println("");
                System.out.println("--------------------");
                x = table.getRow(0);
                for(Card c : x.getCards()){
                    System.out.print(" " + c.getName());
                }
                System.out.println("");
                System.out.println("---------------------");
                x = table.getRow(2);
                for(Card c : x.getCards()){
                    System.out.print(" " + c.getName());
                }
                System.out.println("");
                System.out.println("--------------------");
                x = table.getRow(3);
                for(Card c : x.getCards()){
                    System.out.print(" " + c.getName());
                }
                System.out.println("");
                System.out.println("--------------------");
            */
            }
        }
        System.out.println("points: " + getPlayerTwoPoints()  + " -- " + getPlayerOnePoints());
        
    }
    
    private int getValue(Card card){
        handTable = new Logic.Table();
        for(Card c : hand){
            if(card.getRow() == c.getRow() && !c.equals(card)){
                handTable.addCard(c,1);
            }
        }
        int before = handTable.getPlayerOnePoints();
        handTable.addCard(card, 1);
        int after = handTable.getPlayerOnePoints();
        int value = after - before;
        System.out.println(card.getName() + " value:" + value);
        return value;
    }
   
}
