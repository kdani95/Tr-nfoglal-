package Player;

import Cards.Card;
import Table.Table;
import Table.Row;
import java.util.List;

public abstract class Player {
    protected String name;
    protected int frontPoits;
    protected int backPoints;
    protected int points;
    protected List<Card> deck;
    protected List<Card> hand;
    protected Table table;
    
    public Player(String name, List<Card> deck){
        this.table = new Table();
        this.name = name;
        this.deck = deck;
        this.hand = deck;
    }
    
    protected void drawToHand(int num){
        
    }
    
    abstract public Card getCard();
    
    abstract public List<Card> getHand();
    
    abstract public Row getRow(int r);
    
    abstract public void addToTable(Card card,int player);
    
    public int getPlayerOnePoints(){
        return this.table.getPlayerOnePoints();
    }
    
     public int getPlayerTwoPoints(){
        return this.table.getPlayerTwoPoints();
    }
}
