package tronfoglalo;

import GUI.Tronfoglalo;

public class Start {

    public static void main(String[] args) {
        String name = "PLAYER_1";
        if(args.length > 0){
            name = args[0];
        }
        //InitDatabase.main(args);
        Thread GUI = new Thread(new Tronfoglalo(name) );
        GUI.start();

    }
    
}
