package Client;

import Cards.Card;
import Cards.Cards;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    protected Socket s;
    protected Scanner sc;
    protected PrintWriter pw;
    
    public Client(int PORT, String IP, String name){
        try {
            s   = new Socket(IP, PORT);
            sc  = new Scanner(s.getInputStream(), "utf-8");
            pw  = new PrintWriter(s.getOutputStream());
            
        }catch(Exception e ){
            System.err.println("Error at client: " + e.toString());
        }
    }
    
    public Card receiveMsg(){
        String msg = sc.next();
        System.out.println(msg);
        return Cards.getCard(Integer.parseInt(msg));
    };
    
    public void sendMsg(Card card){
        pw.print(card);
    };
}
