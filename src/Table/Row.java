
package Table;

import Cards.Card;
import java.util.ArrayList;
import java.util.List;

public class Row {
    private int points;
    private List<Card> cards = new ArrayList<Card>();
    private int powerState;
    
    public void addCard(Card card){
        this.cards.add(card);
        powerChange(card.getPower());
        pointsUpdate();
    }
    
    public void powerChange(int change){
        if(change != 0){
            this.powerState = this.powerState + change;
            for (Card card : cards) {
                card.SetPowerState(this.powerState);
            }
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
        return this.points;
    }
}
