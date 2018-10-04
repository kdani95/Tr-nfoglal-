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
    private boolean LOG = true;
    
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
        LOG("Sending players card from: " + from);
        if(from == 0){
            players.get(0).send( 1 +"" +card);
            players.get(1).send( 2 +"" +card);
        }else{
            players.get(0).send( 2 +"" +card);
            players.get(1).send( 1 +"" +card);
        }
        
    }
    
    @Override
    public void run() {
        LOG("The server has started on port " + ss.getLocalPort());
        
        waitForPlayers();
        LOG("Players connected");
        int i = 0;
        int k = 0;
        while ( (players.get(0).notDone() || players.get(1).notDone() ) &&
                (players.get(0).isConnected() && players.get(1).isConnected() ) )
        {
            if(players.get(i).notDone()){
                System.out.println("Player" + i);
                sendPlayersWait();
                sendPlayerGo(i);

                String card = receivePlayer(i);

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
