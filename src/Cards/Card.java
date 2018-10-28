package Cards ;

import Common.Types;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Card{
   
    
    private String name;
    private int strength;
    private int id;
    private int baseStregth;
    private String pictureLoc;
    private int row;
    private int power;
    private int powerState;
    private int cardID;
    
    public Card(Card card){
       this.id = card.id;
       this.cardID = card.cardID;
       this.name = card.name;
       this.baseStregth = card.strength;
       this.strength = card.strength;
       this.pictureLoc = card.pictureLoc;
       this.power = card.power;
       this.row = card.row;
    }
    
    public Card(int id, int cardID, String name, int strength, String pictureLoc, int power, int row){
        this.id = id;
        this.cardID = cardID;
        this.name = name;
        this.baseStregth = strength;
        this.strength = strength;
        this.pictureLoc = pictureLoc;
        this.power = power;
        this.row = row;
    }  
        
    public String getName(){
        return this.name;
    }
    
    public int getCardID(){
        return this.cardID;
    }
    
    public int getID(){
        return this.id;
    }
    
    public int getStrength(){
        return this.strength;
    };
    
    public String getPictureLoc(){
        return this.pictureLoc;
    };
    
    public int getPower(){
        return  this.power;
    };
    
    public void SetPowerState(int power){
        this.strength = this.baseStregth + power - this.power;
    }
    
    public int getRow(){
        return this.row;
    }
    
    public String toString(){
        return (this.cardID + "");
    }

    public Color getColor() {
        if (strength < baseStregth){
            return Color.RED;
        }
        if(strength > baseStregth){
            return Color.GREEN;
        }
        return new Color(245,222,179,255);
    }

    public int getValue() {
        return this.baseStregth + this.power;
    }
        
}
