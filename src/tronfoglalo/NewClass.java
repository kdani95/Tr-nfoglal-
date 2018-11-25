package tronfoglalo;

import Logic.Save;

public class NewClass {
    
    public static void main(String[] args){
        InitDatabase.resetCardsAndSaves("Daniel");
        System.out.println(Save.getSave("Daniel"));
    }
}
