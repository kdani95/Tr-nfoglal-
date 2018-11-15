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
    private static List<Card> deck = new ArrayList<Card>();
    private static List<Card> myCards = new ArrayList<Card>();
    private static boolean enemyPassed = false;
    private static int difficulty = 3;
    
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
        for(int i = 0; i < 5; i++){
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
    
    public static String getEnemyName(){
        return tronfoglalo.getEnemyName();
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
        enemyPassed = false;
        client.reset();
        tronfoglalo.resetEnemyPassed();
        tronfoglalo.resetPassed();
        refresh();
    }
    
    public static void setPoints(){
        tronfoglalo.setPoints(client.getMyPoints(),client.getEnemyPoints());
    }
    
    public static void startServer(int PORT){
        Thread server = new Thread(new Server(PORT));
        server.start();
    }
    
    public static void openMap(){
        tronfoglalo.openMap();
    };
    
    public static void startSinglePlayer(/*List<Card> deckAI*/){
        List<Card> deckAI = new ArrayList<Card>();
            deckAI.add(Cards.getCard(1));
            deckAI.add(Cards.getCard(1));
            deckAI.add(Cards.getCard(2));
            deckAI.add(Cards.getCard(2));   
            deckAI.add(Cards.getCard(3));
            deckAI.add(Cards.getCard(4));
            deckAI.add(Cards.getCard(5));
            deckAI.add(Cards.getCard(5)); 
            deckAI.add(Cards.getCard(6));
            deckAI.add(Cards.getCard(6));
            deckAI.add(Cards.getCard(7));
            deckAI.add(Cards.getCard(8));
            deckAI.add(Cards.getCard(8));
            deckAI.add(Cards.getCard(9));
            deckAI.add(Cards.getCard(9));
            deckAI.add(Cards.getCard(10));
            deckAI.add(Cards.getCard(11));
            deckAI.add(Cards.getCard(12));
            deckAI.add(Cards.getCard(13));
        
       tronfoglalo.startGame("SinglePlayer",Cards.getCards("deck"));
       tronfoglalo.startAI(deckAI);
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

    public static void showWinner(int playerOneLives, int playerTwoLives) {
        tronfoglalo.showWinner(playerOneLives,playerTwoLives);
    }

    public static void passed(int from) {
        if(from == 2){
            enemyPassed=true;
            tronfoglalo.enemyPassed();
        }
    }

    public static boolean getEnemyPassed() {
        return Controller.enemyPassed;
    }
    
    public static void log(String text){
        tronfoglalo.log(text);
    }
    
    public static int getDifficulty(){
        return Controller.difficulty;
    }
    
    public static void setDifficulty(int d){
        Controller.difficulty = d;
    }

    public static void exitGame() {
        client.sendExit();
        tronfoglalo.gameExit();
    }

    public static void exit() {
        tronfoglalo.exit();
    }
}

    