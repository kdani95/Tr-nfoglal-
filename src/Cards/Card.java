package Cards ;

import Common.Types;

public class Card {
   
    
    private String name;
    private int strength;
    private int id;
    private int baseStregth;
    private String pictureLoc;
    private Types.RowLoc row;
    private int power;
    private int powerState;
    
    public Card(Card card){
       this.id = card.id;
       this.name = card.name;
       this.baseStregth = card.strength;
       this.strength = card.strength;
       this.pictureLoc = card.pictureLoc;
       this.power = card.power;
       this.row = card.row;
    }
    
    public Card(int id ,String name, int strength, String pictureLoc, int power, Types.RowLoc row){
        this.id = id;
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
    
    public Types.RowLoc getRow(){
        return this.row;
    }
    
    public String toString(){
        return (this.id + "");
    }
        
}
