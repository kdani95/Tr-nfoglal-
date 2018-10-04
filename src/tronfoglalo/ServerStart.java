package tronfoglalo;

public class ServerStart {
    
    public static void main(String[] args){
        String addr = "localhost";
        int PORT = 12345;
        
        Thread server = new Thread(new Server.Server(PORT));
        server.run();
    }
}
