package Client;

import Cards.Card;
import Cards.Cards;
import GUI.Tronfoglalo;
import Player.HumanPlayer;
import Table.Row;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import tronfoglalo.Controller;

public class Client implements Runnable{
    private Socket s;
    private Scanner sc;
    private PrintWriter pw;
    private String name; 
    private String address;
    private int PORT;
    private Player.Player player;
    private String msg = "";
    
    public Client(String address,int PORT, String name, String type, List<Card> deck){
         this.name = name;
         this.PORT = PORT;
         this.address = address;
         if(type.equals("HUMAN")){
             this.player = new HumanPlayer(name, deck);
         }else{
             //AI players
         }
         
    }
    
    public void connect(){
        try {
            s   = new Socket(this.address, this.PORT);
            sc  = new Scanner(s.getInputStream(), "utf-8");
            pw  = new PrintWriter(s.getOutputStream());
            
            pw.println(name);
            pw.flush();
            
        }catch(Exception e ){
            System.err.println("Error at client: " + e.toString());
        }
    }

    
    public void receiveMsg(){
        
        Thread receive = new Thread( () -> {
            System.out.println("RECEIVING");
            String msg = "";
            if(sc.hasNextLine()){
                msg = sc.nextLine();
                System.out.println(this.name + " Received: " + msg);
                System.out.println("RECEIVED");
                received(msg);
            }
            synchronized(this.msg){
                this.msg = msg;
            }
        });
        
        receive.start();
       
        
    };
    
    public Row getRow(int i){
        return this.player.getRow(i);
    }
    
    public List<Card> getHand(){
        return this.player.getHand();
    }
    
    public void addToTable(Card c, int p){
        player.addToTable(c, p);
    }
    
    public void sendCard(Card card){
        if(card != null){
            pw.println(card.toString());
            pw.flush();
        }else
        {
            pw.println("DONE");
            pw.flush();
        }
        receiveMsg();
    }
    
    @Override
    public void run() {
        connect();
        
        receiveMsg();
        
        
    }
    
    private void received(String msg){
        boolean done = false;
        if (!done){
            switch(msg){
                case "WAIT" : Controller.disableHand(); receiveMsg(); break;
                
                case "GO" : {
                              Controller.enableHand();
                              System.out.println(this.name + " GOING");
                             }
                             break;
                             
                case "ENDED" : 
                                System.out.println("ENDED");
                                done = true;
                                break;
                
                default : 
                                System.out.println(this.name + " RECEIVING CARD");
                                int from = Integer.parseInt(msg.substring(0, 1));
                                int card = Integer.parseInt(msg.substring(1));
                                System.out.println(this.name + " CARD RECEIVED : " + card + " FROM :" + from);
                                Controller.addToTable(Cards.getCard(card), from);
                                for(int i = 0; i < 4; i++){
                                    Controller.refreshRow(i);
                                }
                                receiveMsg();
                                break;
            }
        }
        else{
            System.out.println(this.name + "PLAYER1 POINTS = " + player.getPlayerOnePoints() );
            System.out.println(this.name + "PLAYER2 POINTS = " + player.getPlayerTwoPoints() );
        }
    }
}
