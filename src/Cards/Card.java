package Cards ;

import Common.Types;

public class Card {
   
    
    private String name;
    private int strength;
    private int baseStregth;
    private String pictureLoc;
    private Types.RowLoc row;
    private int power;
    private int powerState;
    
    public Card(String name, int strength, String pictureLoc, int power, Types.RowLoc row){
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
        
}
