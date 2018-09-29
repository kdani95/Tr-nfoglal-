package Server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class User {
    private static int playerNo = 0;
    private String name;
    private Socket s;
    private Scanner sc;
    private PrintWriter pw;
    private boolean notDone = true;
    private boolean LOG = true;
    
    private void LOG(String log){
        if(LOG){
            System.out.println("SERVER LOG: " + log);
        } 
    }
    
    public User(ServerSocket ss){
    try {
            LOG("Accepting client");
            this.s = ss.accept();
            this.sc = new Scanner(s.getInputStream());
            this.pw = new PrintWriter(s.getOutputStream());
            
            if(sc.hasNextLine()){
                this.name = sc.nextLine();
            }
            else{
                ++playerNo;
                this.name = "User"+playerNo;
            }
            
            LOG(this.name + " has connected");
            
        } catch (IOException ex) {
            System.err.println("Error at client connecting: " + ex.toString());
        }
    }
    
     public void send(String msg){ 
        if(!s.isClosed()){
            try {
                pw.println(msg);
                pw.flush();
            } catch (Exception e) {
                System.err.println("Error at sending: " + e.toString());
            }  
        }
    }
     
     public String receive(){
        if(!s.isClosed()){
            try {
                String answer = sc.nextLine();
                //LOG(" --> answer : " + answer);
                return answer;
            } catch (Exception e) {
                try {
                    s.close();
                } catch (IOException ex) {
                    System.err.println("Error at closing socket: " + ex.toString());
                }
                return "";
            }
        }
        return "";
    }

    boolean notDone() {
        return notDone;
    }

    boolean isConnected() {
        return s.isConnected();
    }

    void isDone() {
        this.notDone = false;
    }

}
