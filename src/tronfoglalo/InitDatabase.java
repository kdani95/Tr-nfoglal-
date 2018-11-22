package tronfoglalo;

import Cards.Cards;
import Logic.Save;

public class InitDatabase {
    
    public static void main(String[] args){
        Cards.init();
        Save.init();
    }
    
    public static void resetCardsAndSaves(String name){
        Cards.init();
        Save.reset(name);
    }
}
