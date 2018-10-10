package tronfoglalo;

import Cards.Card;
import Cards.Cards;
import Client.Client;
import Player.HumanPlayer;
import Player.Player;
import Table.Row;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    private static GUI.Tronfoglalo tronfoglalo;
    private static Client client;
    public static String SYNC = "SYNC";
       
    public static void addGUI(GUI.Tronfoglalo tronfoglalo){
        Controller.tronfoglalo =tronfoglalo;
    }
    
    public static void addClient(Client client){
        Controller.client= client;
    }
    
    public static void refresh(){
        refreshHandRow();
        for(int i = 0; i < 4; i++){
            refreshRow(i);
        }
    }
    
    public static void refreshRow(int r){
        Row row = client.getRow(r);
        System.out.println("Row points = " + row.getPoints());
        
        tronfoglalo.refreshRow(row.getCards() , r , row.getPoints() );
    }
    
    public static void refreshHandRow(){
        System.out.println("Refresh hand row");
        //System.out.println("player.getHand = " + player.getHand().size());
        tronfoglalo.refreshHandRow();
    }
    
    public static void sendCard(Card card){
        client.sendCard(card);
    }
 
    public static List<Card> getHand(){
        return client.getHand();
    }
    
    public static Row getRow(int i){
        return client.getRow(i);
    }
    
    public static void removeCard(Card card){
        client.getHand().remove(card);
    }

    public static void disableHand() {
        tronfoglalo.disableHand();
    }

    public static void enableHand() {
        tronfoglalo.enableHand();
    }

    public static void addToTable(Card c, int p) {
        client.addToTable(c, p);
    }

    public static void setEnemyName(String name) {
        tronfoglalo.setEnemyName(name);
    }

    public static void setEnemyCards(String cards) {
        tronfoglalo.setEnemyCards(cards);
    }
    
    public static void setEnemyLifes(String lifes){
        tronfoglalo.setEnemyLifes(lifes);
    }

    public static void setMyCards() {
        tronfoglalo.setMyCards(Controller.getHand().size() + "");
    }

    public static void setMyLifes() {
        tronfoglalo.setMyLifes(client.getLifes() + "");
    }

    public static void reset() {
        client.reset();
        refresh();
    }
    
    public static void setPoints(){
        tronfoglalo.setPoints(client.getMyPoints(),client.getEnemyPoints());
    }
    
}
