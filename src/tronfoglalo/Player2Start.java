package tronfoglalo;

import Cards.Cards;
import GUI.Tronfoglalo;
import Server.Server;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Player2Start {
    
    public static void main(String[] args){
        String addr = "localhost";
        int PORT = 12345;

       // Thread c1 = new Thread(new Client(addr, PORT,"Danika","HUMAN",deck) ); 
        Cards.init();
        Thread GUI = new Thread(new Tronfoglalo("Nati") );
        
        try {
            Thread.sleep(1000);
            GUI.start();

        } catch (Exception ex) {
            Logger.getLogger(Start.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
