package Netcode.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server implements Runnable{
    private int PORT = 0;
    private ServerSocket ss;
    private ArrayList<User> players = new ArrayList<User>();
    private boolean LOG = false;
    
    private void LOG(String log){
        if(LOG){
            System.out.println("SERVER LOG: " + log);
        } 
    }
    
    public Server(int port){
        this.PORT = port;
        try {
            ss = new ServerSocket(port);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Server(){
        try {
            ss = new ServerSocket(this.PORT);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void waitForPlayers(){
        LOG("Waiting for playres");
        while (players.size() < 2){
            players.add(new User(ss));
        }
    }
    
    private boolean sendPlayersWait(){
        LOG("Sending players wait"); 
        players.get(0).send("WAIT");
        players.get(1).send("WAIT");
        String p1 = players.get(0).receive();
        String p2 = players.get(1).receive();
        
        return p1.equals("READY") && p2.equals("READY");
    }
    
    private void sendPlayersEnded(){
        LOG("Sending players ENDED"); 
        players.get(0).send("ENDED");
        players.get(1).send("ENDED");
    }
    
    private void sendPlayerGo(int p){
        LOG("Sending player"+p +" GO"); 
        players.get(p).send("GO");
    }
    
    private String receivePlayer(int p){
        LOG("Receiving from  player"+p); 
        return players.get(p).receive();
    }
    
    private void sendPlayersCard(String card,int from){
        LOG("Sending players card from: " + from);
        if(from == 0){
            players.get(0).send( 1 +"" +card);
            players.get(1).send( 2 +"" +card);
        }else{
            players.get(0).send( 2 +"" +card);
            players.get(1).send( 1 +"" +card);
        }
    }
    
    private void sendPlayersLives(){
        LOG("SETTING LIVES");
        
        players.get(0).send("SETLIVES");
        players.get(0).send(players.get(1).getLifes()+"");
        
        players.get(1).send("SETLIVES");
        players.get(1).send(players.get(0).getLifes()+"");
        
    }
    
    private void sendPlayersName(){
        LOG("Sending players names"); 
        players.get(0).send(players.get(1).getName());
        players.get(1).send(players.get(0).getName());
    }
    
    private void sendPlayersCardsNo(){
        LOG("Sending players cards number"); 
        players.get(0).send("SETCARDS");
        players.get(0).send(players.get(1).getCards());
        
        players.get(1).send("SETCARDS");
        players.get(1).send(players.get(0).getCards());
    }
    
    @Override
    public void run() {
        boolean disconnected = false;
        LOG("The server has started on port " + ss.getLocalPort());
        
        waitForPlayers();
        
        sendPlayersName();

        LOG("Players connected");
        Random rand = new Random();
        int i = rand.nextInt(2);
        
        while( players.get(0).getLifes() > 0 && players.get(1).getLifes() > 0){
            
            sendPlayersLives();
    
            while ( (players.get(0).notDone() || players.get(1).notDone() ) &&
                    (players.get(0).isConnected() && players.get(1).isConnected() ) )
            {
                if(players.get(i).notDone()){
                    LOG("Player" + i);
                    if(!sendPlayersWait() ){
                        players.get(0).isDone();
                        players.get(1).isDone();
                        sendPlayersEnded();
                        disconnected = true;
                        break;
                    }
                    sendPlayersCardsNo();
                    sendPlayerGo(i);

                    String card = receivePlayer(i);

                    if(card.equals("DONE")){
                        players.get(i).isDone();
                        LOG("player" +i +" is done");
                        sendPlayersCard("DONE", i);
                    }else if(card.equals("DISCONNECTED")){
                        players.get(i).disconnected();
                        players.get(0).isDone();
                        players.get(1).isDone();
                        LOG("player" + i + " disconnected");
                        sendPlayersEnded();
                        disconnected = true;
                        break;
                    }else{
                        sendPlayersCard(card,i);
                    }
                    
                }
                i = (i+1)%2;
            }
            
            if(disconnected){
                break;
            }
            
            if(players.get(0).getPoints() > players.get(1).getPoints() ){
                players.get(0).removeLife("1");
                players.get(1).removeLife("0");
                i = 0;
            }else
            if(players.get(0).getPoints() < players.get(1).getPoints() ){
                players.get(0).removeLife("0");
                players.get(1).removeLife("1");
                i = 1;
            }else{
                players.get(0).removeLife("2");
                players.get(1).removeLife("2");
                i = (i+1)%2;
            }
            players.get(0).restart();
            players.get(1).restart();
        }
        
        if(!disconnected){
            sendPlayersCardsNo();
            sendPlayersLives();
            sendPlayersEnded();
        }
        for(User user : players){
            user = null;
        }
        try {
            ss.close();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        ss=null;
        LOG("SERVER ENDED");
    }
    
}
