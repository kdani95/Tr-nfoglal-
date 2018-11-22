package tronfoglalo;

import Logic.Save;

public class NewClass {
    
    public static void main(String[] args){
        Save.refreshSave("DANI", 0);
        System.out.println(Save.getSave("DANI"));
    }
}
