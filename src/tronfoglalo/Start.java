package tronfoglalo;

import Cards.Card;
import Cards.Cards;
import Client.Client;
import Common.Types;
import GUI.Tronfoglalo;
import Player.HumanPlayer;
import Player.Player;
import Server.Server;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Start {

    public static void main(String[] args) {
        List<Card> deck = new ArrayList<Card>();
        List<Card> deck2 = new ArrayList<Card>();
        
        Cards.init();
        
        deck.add(Cards.getCard(0));
        deck.add(Cards.getCard(1));
        deck.add(Cards.getCard(0));
        deck.add(Cards.getCard(1));
        
        deck.add(Cards.getCard(0));
        deck.add(Cards.getCard(1));
        deck.add(Cards.getCard(0));
        deck.add(Cards.getCard(1));
        deck.add(Cards.getCard(2));
        
        String addr = "localhost";
        int PORT = 12345;

       // Thread c1 = new Thread(new Client(addr, PORT,"Danika","HUMAN",deck) ); 
        
        Thread GUI = new Thread(new Tronfoglalo() );
        
       
        //Thread c2 = new Thread(new Client(addr, PORT,"Natika","HUMAN",deck2));
        
        //Thread server = new Thread(new Server(PORT));
        
        //server.start();
        
        try {
            //Thread.sleep((long) 1000.0);
            //c1.start();
            GUI.start();
            //c2.start();
        } catch (Exception ex) {
            Logger.getLogger(Start.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
