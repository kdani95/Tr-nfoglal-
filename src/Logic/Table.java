package Logic;

import Cards.Card;
import Common.Types;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class Table {
    private Row[] rows = new Row[5];
    
    public Table(){
        for(int i = 0; i < 5; ++i){
            rows[i] = new Row();
        }
    }
    
    public int getPlayerOnePoints(){
        return rows[0].getPoints() + rows[1].getPoints();
    }
    
    public int getPlayerTwoPoints(){
        return rows[2].getPoints() + rows[3].getPoints();
    }
    
    public int tryCard(Card card){
        int beforePoints = getPlayerOnePoints();
        
        addCard(card, 1);
        
        int afterPoint = getPlayerOnePoints();
        
        removeCard(card);
        
        return afterPoint - beforePoints;
    }
    
    public void addCard(Card card, int player){
        if(card.getAbility() != null){
            switch(card.getAbility()){
                case "plague": deleteWeakest(); break;
                case "frost": applyFrost(); break;
                case "fog": applyFog(); break;
            }
        }
        if(player == 1){
            if(card.getRow() == 0){
                rows[0].addCard(card);
            }else if(card.getRow() == 1)
            {
                rows[1].addCard(card);
            }else{
                rows[4].addCard(card);
            }
        }else
        if(player == 2){
            if(card.getRow() == 0){
                rows[2].addCard(card);
            }else if(card.getRow() == 1)
            {
                rows[3].addCard(card);
            }else{
                rows[4].addCard(card);
            }
        }
    }
    
    public void removeCard(Card card){
        if(card.getRow() == 0){
                rows[0].removeCard(card);
            }else
            {
                rows[1].removeCard(card);
            }
    }
    
    public Row getRow(int r){
        return this.rows[r];
    }

    public void reset() {
       for(int i = 0; i < 5; i++){
           rows[i].reset();
       }
    }
    
    private void deleteWeakest(){
        int weakest = 999;
        for(int i = 0; i < 4; i++){
            for(Card c : rows[i].getCards()){
                if(c.getStrength() < weakest){
                    weakest = c.getStrength();
                }
            }
        }   
        for(int i = 0; i < 4; i++){
            Iterator it = rows[i].getCards().iterator();
            while(it.hasNext()){
                Card c = (Card)it.next();
                if(c.getStrength() == weakest){
                    it.remove();
                }
            }
        }
    }
    
    private void applyFrost(){
        rows[3].powerChange(-2);
        rows[0].powerChange(-2);
    }
    
    private void applyFog(){
        rows[1].powerChange(-2);
        rows[2].powerChange(-2);
    }
}
