package Netcode.Client;

import Cards.Card;
import Cards.Cards;
import Player.AiPlayer;
import Player.HumanPlayer;
import Logic.Row;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;
import Logic.Controller;

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
            String msg = sc.nextLine();
            received(msg);
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
    
    public int getLifes(){
        return this.player.getLives();
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
                case "WAIT" :   if(!AI) {Controller.refresh(); Controller.disableHand();}
                                pw.println("READY");
                                pw.flush();
                                receiveMsg(); 
                                break;
                
                case "GO" : 
                                if(!AI){
                                    Controller.enableHand();
                                }else{
                                    sendCard(player.getCard());
                                }
                                break;
                             
                case "ENDED" : 
                                if(!AI){
                                    Controller.showWinner(player.getLives(),player.getEnemyLives());
                                }
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
                                
                case "GETLIVES":   
                                pw.println(player.getLives());
                                pw.flush();
                                receiveMsg();
                                break;
                                
                case "SETLIVES":
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
                                String p = sc.nextLine();
                                player.removeLife(p);
                                if(!AI){
                                    String name = "";
                                    if(p.equals("0")){
                                        name = this.name;
                                    }
                                    if(p.equals("1")){
                                        name = Controller.getEnemyName();
                                    }
                                    if(p.equals("2")){
                                        name = "Both player";
                                    }
                                    Controller.log(name + " lost a life");
                                }
                                receiveMsg();
                                break;
                                
                case "RESET":
                                if(!AI){
                                    Controller.log("Round ended");
                                    Controller.reset();
                                    Controller.setPoints();
                                }else{
                                    player.reset();
                                }
                                receiveMsg();
                                break;
                                
                default : 
                                //System.out.println(this.name + " RECEIVING CARD");
                                //System.out.println(msg);
                                int from = Integer.parseInt(msg.substring(0, 1));
                                String rest = msg.substring(1);
                                if(rest.equals("DONE")){
                                    if(!AI){
                                        Controller.passed(from);
                                        String name = "NONAME";
                                        if(from == 1){
                                            name = this.name;
                                        }else{
                                            name = Controller.getEnemyName();
                                        }
                                        Controller.log(name + " passed ");
                                    }else{
                                        //System.out.println("ASDASDASDASDASDASDASDASDASDASDASDASD"); 
                                       if(from == 2){
                                            player.enemyPassed();
                                        }
                                    }
                                }else{
                                    
                                    int card = Integer.parseInt(rest);
                                    //System.out.println(this.name + " CARD RECEIVED : " + card + " FROM :" + from);
                                    if(!AI){
                                        Card cardReceived = Cards.getCard(card);
                                        String name = "NONAME";
                                        if(from == 1){
                                            name = this.name;
                                        }else{
                                            name = Controller.getEnemyName();
                                        }
                                        Controller.log(name + " placed " + cardReceived.getName());
                                        Controller.addToTable(cardReceived, from);
                                        if(card > 7){
                                            for(int i = 0; i < 4; i++){
                                                Controller.refreshRow(i);
                                            }
                                        }
                                        Controller.refreshRow(from + cardReceived.getRow());
                                        Controller.setPoints();
                                    }else{
                                        player.addToTable(Cards.getCard(card), from);
                                    }
                                    
                                }
                                receiveMsg();
                                break;
            }
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

    public void sendExit() {
        pw.println("DISCONNECTED");
        pw.flush();
        pw.close();
        sc.close();
        try{
            s.close();
        }catch(Exception ex){
            System.err.println("Error at closing socket: " + ex.toString());
        }
    }
}
