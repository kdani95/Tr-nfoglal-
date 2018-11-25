package Logic;

import Cards.Card;
import Cards.Cards;
import Netcode.Client.Client;
import Netcode.Server.Server;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import tronfoglalo.InitDatabase;

public class Controller {
    private static GUI.Tronfoglalo tronfoglalo;
    private static Client client;
    private static List<Card> deck = new ArrayList<Card>();
    private static List<Card> myCards = new ArrayList<Card>();
    private static boolean enemyPassed = false;
    private static int difficulty = 3;
    private static int map = -1;
    private static int[][] prize = { {4,6},{3,1},{7,3}};
    private static String name;
    private static int[][] decks = { {5,5,5,2,2,2,1,1,3,4,7,8,8,9,9,10,10,11,12,13},
                                     //{1,1,2,2,3,4,5,5,6,6,7,9,9,11,12,13},
                                     {1,1,1,2,2,2,3,3,5,5,5,9,9,9,10,10,10,11,12,13},
                                     {1,1,1,2,2,2,3,3,4,5,5,6,6,6,7,9,9,11,12,13}}; 
  
    public static void addGUI(GUI.Tronfoglalo tronfoglalo, List<Card> cards, List<Card> deck,String name){
        Controller.tronfoglalo =tronfoglalo;
        Controller.myCards = cards;
        Controller.deck = deck;
        Controller.name = name;
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
    
    public static void closeMap(){
        tronfoglalo.closeMap();
        tronfoglalo.cardNumberCheck();
    };
    
    public static void startSinglePlayer(){
        List<Card> deckAI = new ArrayList<>();
        map = Save.getSave(name);
        for(int i : decks[map]){
            deckAI.add(Cards.getCard(i));
        }
        
        tronfoglalo.startGame("SinglePlayer",Cards.getCards(name,"deck"));
        tronfoglalo.startAI(deckAI);
    }

    public static void startMultiPlayer() {
        tronfoglalo.startGame("MultiPlayer",Cards.getCards(name,"deck"));
    }
    
    public static void joinMultiPlayer() {
        tronfoglalo.joinMultiPlayer(12345,"localhost",Cards.getCards(name,"deck"));
    }

    public static void editDeck() {
        myCards = Cards.getCards(name,"mycards");
        deck = Cards.getCards(name,"deck");
        tronfoglalo.editDeck();
    }
    
    public static void editDeckBack(){
        tronfoglalo.editDeckBack();
        tronfoglalo.cardNumberCheck();
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
        if(playerOneLives > playerTwoLives && map > -1){
            for(int i: prize[map]){
                Cards.insertIntoMyCards(name,i);
            }
            if(Save.getSave(name)+1 >= prize.length){
                Save.refreshSave(name, 0);
            }else{
                Save.refreshSave(name, Save.getSave(name)+1);
            }
        }
        if(playerOneLives < playerTwoLives && map > -1){
            Random r = new Random();
            if(myCards.size() > 0){
                int i = r.nextInt(myCards.size());
                Cards.deleteFromMycards(name,myCards.get(i).getID());
            }else if(deck.size() > 0){
                int i = r.nextInt(deck.size());
                Cards.deleteFromDeck(name,deck.get(i).getID());
            }
        }
        tronfoglalo.showWinner(playerOneLives,playerTwoLives);
        deck = Cards.getCards(name, "deck");
        myCards = Cards.getCards(name, "myCards");
        if(deck.size() + myCards.size() < 20){
            System.out.println("LOST");
            InitDatabase.resetCardsAndSaves(name);
            
            myCards = Cards.getCards(name,"mycards");
            deck = Cards.getCards(name,"deck");
            
            tronfoglalo.cardNumberCheck();
            
            tronfoglalo.showGameLost();
        }
        if(playerOneLives == playerTwoLives){
            if(map > -1){
                startSinglePlayer();
            }
        }else{
            map = -1;
        }
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

    public static String getName() {
        return name;
    }
}

    