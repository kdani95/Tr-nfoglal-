package tronfoglalo;

import Cards.Card;
import Cards.Cards;
import Netcode.Client.Client;
import Common.Types;
import GUI.Tronfoglalo;
import Player.HumanPlayer;
import Player.Player;
import Netcode.Server.Server;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Start {

    public static void main(String[] args) {
        String addr = "localhost";
        int PORT = 12345;

       // Thread c1 = new Thread(new Client(addr, PORT,"Danika","HUMAN",deck) ); 
        //Cards.init();
        
        Thread GUI = new Thread(new Tronfoglalo("DANI") );
        GUI.start();
        /*
        try {
            Thread.sleep(1000);
            GUI.start();

        } catch (Exception ex) {
            Logger.getLogger(Start.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
    }
    
}
