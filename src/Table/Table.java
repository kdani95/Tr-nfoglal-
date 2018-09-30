package Table;

import Cards.Card;
import Common.Types;


public class Table {
    private Row[] rows = new Row[4];
    
    public Table(){
        for(int i = 0; i < 4; ++i){
            rows[i] = new Row();
        }
    }
    
    public int getPlayerOnePoints(){
        return rows[0].getPoints() + rows[1].getPoints();
    }
    
    public int getPlayerTwoPoints(){
        return rows[2].getPoints() + rows[3].getPoints();
    }
    
    public void addCard(Card card, int player){
        if(player == 1){
            if(card.getRow() == 0){
                rows[0].addCard(card);
            }else
            {
                rows[1].addCard(card);
            }
        }else
        if(player == 2){
            if(card.getRow() == 0){
                rows[2].addCard(card);
            }else
            {
                rows[3].addCard(card);
            }
        }
    }
    
    public Row getRow(int r){
        return this.rows[r];
    }
}
