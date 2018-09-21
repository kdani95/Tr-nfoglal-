/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cards ;

/**
 *
 * @author Gumó
 */
public class Card {
    private enum Power{POWERUP,POWERDOWN};
    private enum Row{FRONT,BACK};
    
    private String name;
    private int strength;
    private int baseStregth;
    private String pictureLoc;
    private Row row;
    private Power power;
    private int powerState;
    
    public Card(String name, int strength, String pictureLoc, Power power, Row row){
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
    
    public Power getPower(){
        return  this.power;
    };
    
    public void SetPowerState(int powerState){
        this.powerState = powerState;
        if (this.powerState > 0){
            this.strength = this.baseStregth * 2;
        }else
        if (this.powerState < 0){
            this.strength = this.baseStregth / 2;
        }else
        {
            this.strength = this.baseStregth;
        }
    }
        
}
