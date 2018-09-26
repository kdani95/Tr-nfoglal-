package Server;

import java.net.ServerSocket;
import java.util.ArrayList;

public class Server implements Runnable{
    private int PORT = 0;
    private ServerSocket ss;
    private ArrayList<User> players = new ArrayList<User>();
    
    @Override
    public void run() {
        
    }
    
}
