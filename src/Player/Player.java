/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Player;

import Cards.Card;
import java.util.List;

/**
 *
 * @author Gumó
 */
public abstract class Player {
    private String name;
    private int frontPoits;
    private int backPoints;
    private int points;
    private List<Card> Deck;
    private List<Card> Hand;
    
    public Player(String name){
        
    }
    
    private void drawToHand(int num){
        
    }
    
    public Card getCard;
    
}
