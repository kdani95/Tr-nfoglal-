package Player;

import Cards.Card;
import Table.Table;
import Table.Row;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javafx.print.Collation;

public abstract class Player {
    protected String name;
    protected int frontPoits;
    protected int backPoints;
    protected int points;
    protected int lifes = 2;
    protected int enemyLifes = 2;
    protected List<Card> deck;
    protected List<Card> hand = new ArrayList<Card>();
    protected Table table;
    protected boolean enemyPassed = false;
    private int cards = 10;
    
    public Player(String name, List<Card> deck){
        this.table = new Table();
        this.name = name;
        this.deck = deck;
        Collections.shuffle(deck);
        int i = 0;
        
        for(Card c : deck){
            if(i < cards){
                this.hand.add(c);
                i++;
            }
        }
        
        for(Card c : hand){
            this.deck.remove(c);
        }
        
    }
    
    protected void drawToHand(int num){
        
    }
    
    public void enemyPassed(){
        enemyPassed = true;
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
    
    public int getLifes(){
        return this.lifes;
    }
    
    public void removeLife(){
        this.lifes--;
    }

    public void reset() {
        table.reset();
        enemyPassed = false;
    }
}
