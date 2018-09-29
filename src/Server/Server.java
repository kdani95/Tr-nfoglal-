package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
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
    
    private void sendPlayersWait(){
        LOG("Sending players wait"); 
        players.get(0).send("WAIT");
        players.get(1).send("WAIT");
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
        LOG("Sending players card"); 
        players.get(0).send("CARD");
        players.get(1).send("CARD");
        
        players.get(0).send( (from+1) +"");
        players.get(1).send( ( ((from + 1) % 2 ) + 1) +"");
        
        players.get(0).send(card);
        players.get(1).send(card);
    }
    
    @Override
    public void run() {
        LOG("The server has started on port " + ss.getLocalPort());
        
        waitForPlayers();
        LOG("Players connected");
        int i = 0;
        int k = 0;
        while ( (players.get(0).notDone() || players.get(1).notDone() ) &&
                (players.get(0).isConnected() && players.get(1).isConnected() ) && k < 6 )
        {
            if(players.get(i).notDone()){
                
                sendPlayersWait();
                sendPlayerGo(i);

                String card = receivePlayer(i);

                try {
                    Thread.sleep((long) 1000.0);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                }

                if(card.equals("DONE")){
                    players.get(i).isDone();
                }else{
                    sendPlayersCard(card,i);
                }

                
            }
            i = (i+1)%2;
                k++;
        }
        sendPlayersEnded();
        
    }
    
}
