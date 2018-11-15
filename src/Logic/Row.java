
package Logic;

import Cards.Card;
import java.util.ArrayList;
import java.util.List;

public class Row {
    private int points;
    private List<Card> cards = new ArrayList<Card>();
    private int powerState;
    
    public Row(){
        this.points = 0;
        this.powerState = 0;
    }
    
    public Row(Row that){
        for(Card c : that.getCards()){
            this.cards.add(new Card(c));
        }
        this.points = that.points;
        this.powerState = that.powerState;
    }
    
    public void addCard(Card card){
        this.cards.add(card);
        if(card.getPower() != 0){
            powerChange(card.getPower());
        }else{
            card.SetPowerState(this.powerState);
        }
        
        pointsUpdate();
    }
    
    public void removeCard(Card card){
        this.cards.remove(card);
        if(card.getPower() != 0){
            powerChange(-card.getPower());
            card.SetPowerState(0);
        }else{
            card.SetPowerState(0);
        }
        pointsUpdate();
    }
    
    public void powerChange(int change){
        this.powerState = this.powerState + change;
        for (Card card : cards) {
            card.SetPowerState(this.powerState);
        }
    }
    
    public List<Card> getCards(){
        return this.cards;
    }

    private void pointsUpdate() {
        this.points = 0;
        for (Card card : cards){
            this.points += card.getStrength();
        }
    }
    
    public int getPoints(){
        int points = 0;
        for (Card card : cards){
            points += card.getStrength();
        }
        return points;
    }

    public void reset() {
       this.cards.removeAll(cards);
       this.powerState = 0;
       this.points = 0;
    }
}
