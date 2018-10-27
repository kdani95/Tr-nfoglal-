package Logic;

import Cards.Card;
import Cards.Cards;
import Netcode.Client.Client;
import Player.HumanPlayer;
import Player.Player;
import Netcode.Server.Server;
import Logic.Row;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    private static GUI.Tronfoglalo tronfoglalo;
    private static Client client;
    public static String SYNC = "SYNC";
    private static List<Card> deck = new ArrayList<Card>();
    private static List<Card> myCards = new ArrayList<Card>();
       
    public static void addGUI(GUI.Tronfoglalo tronfoglalo, List<Card> cards, List<Card> deck){
        Controller.tronfoglalo =tronfoglalo;
        Controller.myCards = cards;
        Controller.deck = deck;
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
        tronfoglalo.refreshRow(row.getCards() , r , row.getPoints() );
    }
    
    public static void refreshHandRow(){
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
    
    public static void startServer(int PORT){
        Thread server = new Thread(new Server(PORT));
        server.start();
    }
    
    public static void startSinglePlayer(){
       tronfoglalo.startGame("SinglePlayer",Cards.getCards("deck"));
    }

    public static void startMultiPlayer() {
        tronfoglalo.startGame("MultiPlayer",Cards.getCards("deck"));
    }
    
    public static void joinMultiPlayer() {
        tronfoglalo.joinMultiPlayer(12345,"localhost",Cards.getCards("deck"));
    }

    public static void editDeck() {
        tronfoglalo.editDeck();
    }
    
    public static void editDeckBack(){
        tronfoglalo.editDeckBack();
    }

    public static void saveDeck(List<Card> cards) {
        Controller.deck = cards;
    }
    
    public static List<Card> getDeck(){
        return Controller.deck;
    }
    
    public static List<Card> getCards(){
        return Controller.myCards;
    }

    public static void addToDeck(Card selected) {
       Controller.deck.add(selected);
       Controller.myCards.remove(selected);
    }

    public static void removeFromDeck(Card selected) {
       Controller.myCards.add(selected);
       Controller.deck.remove(selected);
    }

    public static void enemyPassed() {
        client.enemyPassed();
        tronfoglalo.enemyPassed();
    }

    public static void showWinner(int playerOnePoints, int playerTwoPoints) {
        tronfoglalo.showWinner(playerOnePoints,playerTwoPoints);
    }
}
