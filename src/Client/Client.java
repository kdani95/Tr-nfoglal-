package Client;

import Cards.Card;
import Cards.Cards;
import Player.HumanPlayer;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

public class Client implements Runnable{
    private Socket s;
    private Scanner sc;
    private PrintWriter pw;
    private String name; 
    private String address;
    private int PORT;
    private Player.Player player;
    
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

    
    public String receiveMsg(){
        String msg = sc.next();
        //System.out.println(this.name + " Received: " + msg);
        return msg;
    };
    
    public void sendMsg(Card card){
        pw.print(card);
    };

    @Override
    public void run() {
        connect();
        boolean done = false;
        while (!done){
            String msg = receiveMsg();
            switch(msg){
                case "WAIT" : break;
                
                case "GO" : {
                              System.out.println(this.name + " GOING");
                              Card card = player.getCard();
                              if(card != null){
                                  pw.println(card.toString());
                                  pw.flush();
                              }else
                              {
                                  pw.println("DONE");
                                  pw.flush();
                              }
                              
                             }
                             break;
                             
                case "ENDED" : 
                                System.out.println("ENDED");
                                done = true;
                                break;
                
                case "CARD" : 
                                System.out.println(this.name + " RECEIVING CARD");
                                int from = Integer.parseInt(receiveMsg());
                                int card = Integer.parseInt(receiveMsg());
                                System.out.println(this.name + " CARD RECEIVED : " + card + " FROM :" + from);
                                this.player.addToTable(Cards.getCard(card), from);
            }
        }
        
        System.out.println(this.name + "PLAYER1 POINTS = " + player.getPlayerOnePoints() );
        System.out.println(this.name + "PLAYER2 POINTS = " + player.getPlayerTwoPoints() );
    }
}
