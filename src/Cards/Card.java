package Cards ;

import java.awt.Color;

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
    private String ability;
    
    public Card(Card card){
       this.id = card.id;
       this.cardID = card.cardID;
       this.name = card.name;
       this.baseStregth = card.strength;
       this.strength = card.strength;
       this.pictureLoc = card.pictureLoc;
       this.power = card.power;
       this.row = card.row;
       this.ability = card.ability;
    }
    
    public Card(int id, int cardID, String name, int strength, String pictureLoc, int power, int row,String ability){
        this.id = id;
        this.cardID = cardID;
        this.name = name;
        this.baseStregth = strength;
        this.strength = strength;
        this.pictureLoc = pictureLoc;
        this.power = power;
        this.row = row;
        this.ability = ability;
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
    
    public String getAbility(){
        return this.ability;
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
    
    public boolean equals(Card c){
        return this.cardID == c.cardID;
    }
        
}
