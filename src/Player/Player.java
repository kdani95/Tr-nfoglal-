package Player;

import Cards.Card;
import Logic.Table;
import Logic.Row;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javafx.print.Collation;

public abstract class Player {
    protected String name;
    protected int frontPoits;
    protected int backPoints;
    protected int points;
    protected int lives = 2;
    protected int enemyLives = 2;
    protected List<Card> deck = new ArrayList<Card>();
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
                this.addCard(c);
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
        System.out.println("PLAYER PASSSSSSSSSSSSING");
        enemyPassed = true;
    }
    
    abstract public void addCard(Card c);
    
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
    
    public int getEnemyLives(){
        return this.enemyLives;
    }
    
    public int getLives(){
        return this.lives;
    }
    
    public void removeLife(String p){
        if(p.equals("0")){
            lives--;
        }
        if(p.equals("1")){
            enemyLives --;
        }
        if(p.equals("2")){
            lives--;
            enemyLives--;
        }
    }

    public void reset() {
        table.reset();
        enemyPassed = false;
    }

    public List<Card> getDeck() {
        return this.deck;
    }
}
