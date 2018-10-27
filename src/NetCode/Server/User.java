package Netcode.Server;

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
    private boolean LOG = false;
    private void LOG(String log){
        if(LOG){
            System.out.println("SERVER LOG: " + log);
        } 
    }
    
    public String getName(){
        return this.name;
    }
    
    public String getCards(){
        send("GETCARDS");
        return sc.nextLine();
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
    
    public int getLifes(){
        int lifes = 0;
        if(!s.isClosed()){
            try {
                pw.println("GETLIFES");
                pw.flush();
              
                lifes = Integer.parseInt(sc.nextLine());
                System.out.println("LIFES: " + lifes);
            } catch (Exception e) {
                System.err.println("Error at sending: " + e.toString());
            }  
        }
        return lifes;
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
        return !s.isClosed();
    }

    void isDone() {
        this.notDone = false;
    }

    int getPoints() {
        send("GETPOINTS");
        return Integer.parseInt(sc.nextLine());
    }

    void removeLife() {
       send("REMOVELIFE");
    }

    void restart() {
        this.notDone = true;
        send("RESET");
    }
}
