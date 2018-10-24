package Client;

import Cards.Card;
import Cards.Cards;
import GUI.Tronfoglalo;
import Player.AiPlayer;
import Player.HumanPlayer;
import Table.Row;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.EventListener;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.EventListenerList;
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
    private boolean AI = false;
    private EventListenerList listeners = new EventListenerList();
    
    public Client(String address,int PORT, String name, String type, List<Card> deck){
         this.name = name;
         this.PORT = PORT;
         this.address = address;
         if(type.equals("HUMAN")){
             this.player = new HumanPlayer(name, deck);
         }else{
             //System.out.println("AI PLAYER STARTED");
             this.player = new AiPlayer(name, deck);
             this.AI = true;
         }
         
    }
    
    public String getName(){
        return this.name;
    }
    
    public void connect(){
        try {
            s   = new Socket(this.address, this.PORT);
            sc  = new Scanner(s.getInputStream(), "utf-8");
            pw  = new PrintWriter(s.getOutputStream());
            
            pw.println(name);
            pw.flush();
            
            if(!AI){
                Controller.setEnemyName(sc.nextLine());
            }else{
                System.out.println("AI: " + sc.nextLine());
            }
            
            
            
        }catch(Exception e ){
            System.err.println("Error at client: " + e.toString());
        }
    }

    
    public void receiveMsg(){
        
        Thread receive = new Thread( () -> {
            String msg = "";
            if(sc.hasNextLine()){
                msg = sc.nextLine();
                //System.out.println(this.name + " Received: " + msg);
                received(msg);
            }
            /*synchronized(this.msg){
                this.msg = msg;
            }*/
        });
        
        receive.start();
        /*try {
            receive.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        received(this.msg);
       */
        
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
    
    public int getLifes(){
        return this.player.getLifes();
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
        //System.out.println("------------------------->" + Thread.currentThread());
        boolean done = false;
        if (!done){
            switch(msg){
                case "WAIT" : if(!AI) {Controller.refresh(); Controller.disableHand();} receiveMsg(); break;
                
                case "GO" : 
                                if(!AI){Controller.enableHand();}else{
                                    sendCard(player.getCard());
                                }
                                
                                //System.out.println(this.name + " GOING");
                                break;
                             
                case "ENDED" : 
                                //System.out.println("ENDED");
                                done = true;
                                break;
                                
                case "GETCARDS" :   
                                pw.println(player.getHand().size());
                                pw.flush();
                                
                                receiveMsg();
                                break;
                                
                case "SETCARDS":
                                String cards = sc.nextLine();
                                //System.out.println("SET CARDS: " + cards);
                                if(!AI){
                                    Controller.setEnemyCards(cards);
                                    Controller.setMyCards();
                                }else{
                                    
                                }
                                receiveMsg();
                                break;
                                
                case "GETLIFES":   
                                pw.println(player.getLifes());
                                pw.flush();
                                receiveMsg();
                                break;
                                
                case "SETLIFES":
                                //System.out.println("SETLIFES");
                                if(!AI){
                                    Controller.setEnemyLifes(sc.nextLine());
                                    Controller.setMyLifes();
                                }else{
                                    sc.nextLine();
                                }
                                receiveMsg();
                                break;
                                
                case "GETPOINTS":
                                pw.println(player.getPlayerOnePoints());
                                pw.flush();
                                receiveMsg();
                                break;
                                
                case "REMOVELIFE":
                                player.removeLife();
                                receiveMsg();
                                break;
                                
                case "RESET":
                                if(!AI){
                                    Controller.reset();
                                    Controller.setPoints();
                                }else{
                                    player.reset();
                                }
                                receiveMsg();
                                break;
                                
                default : 
                                //System.out.println(this.name + " RECEIVING CARD");
                                int from = Integer.parseInt(msg.substring(0, 1));
                                String rest = msg.substring(1);
                                if(rest.equals("DONE")){
                                    player.enemyPassed();
                                }else{
                                    
                                    int card = Integer.parseInt(rest);
                                    //System.out.println(this.name + " CARD RECEIVED : " + card + " FROM :" + from);
                                    if(!AI){
                                        Controller.addToTable(Cards.getCard(card), from);

                                        for(int i = 0; i < 4; i++){
                                            Controller.refreshRow(i);
                                        }
                                        Controller.setPoints();
                                    }else{
                                        player.addToTable(Cards.getCard(card), from);
                                        System.out.println("AI points: " + player.getPlayerOnePoints());
                                        System.out.println("Human points: " + player.getPlayerTwoPoints());
                                    }
                                    
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

    public void reset() {
        this.player.reset();
    }
    
    public int getMyPoints(){
        return player.getPlayerOnePoints();
    }
    
    public int getEnemyPoints(){
        return player.getPlayerTwoPoints();
    }

    public List<Card> getDeck() {
        return this.player.getDeck();
    }
}
