package Server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class User {
    private String name;
    private Socket s;
    private Scanner sc;
    private PrintWriter pw;
    
    public User(ServerSocket ss){
    try {
            this.s = ss.accept();
            this.sc = new Scanner(s.getInputStream());
            this.pw = new PrintWriter(s.getOutputStream());
            
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
                System.err.println("Error at sending statusChange: " + e.toString());
            }  
        }
    }
     
     public String receive(){
        if(!s.isClosed()){
            try {
                String answer = sc.nextLine();
                System.out.println(" --> answer : " + answer);
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
}
