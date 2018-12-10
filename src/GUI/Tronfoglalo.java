package GUI;

import Cards.Card;
import Cards.Cards;
import Netcode.Client.Client;
import java.util.List;
import Logic.Controller;
import javax.swing.JOptionPane;

public class Tronfoglalo extends javax.swing.JFrame implements Runnable{
    private boolean started = false;
    private String name;

    public Tronfoglalo() {
        this.name = "";
        boolean noName = true;
        while(noName){
            JOptionPane login = new JOptionPane("Login");
            try{
                this.name = login.showInputDialog(this, "Player Name");
            }catch( Exception e){
                System.err.println("Error at login: " + e.toString());
                return;
            }
            if(this.name != null){
                noName = this.name.length() < 2;
            }else{
                exit();
            }
        }
        
        Cards.initPlayer(name);
        List<Card> cards = Cards.getCards(this.name,"mycards");
        List<Card> deck = Cards.getCards(this.name,"deck");
        
        Controller.addGUI(this,cards,deck,name);
        initComponents();
        table1.setMyName(name);
        //this.setSize(1080, 720);
    }
    
    public void openMap(){
        this.add(map1);
        this.map1.setSize(this.getWidth(), this.getHeight());
        this.mainMenu1.setVisible(false);
        this.map1.setVisible(true);
        this.map1.display();
    }
    
    public void closeMap() {
        this.mainMenu1.setVisible(true);
        this.map1.setVisible(false);
    }
    
    public void startGame(String mode,List<Card> deck){  
        setPoints(0, 0);
        this.add(table1);
        this.table1.resetEnemyPassed();
        this.table1.resetPassed();
        this.table1.setSize(this.getWidth(), this.getHeight());
        this.table1.clearLog();
        String addr = "localhost";
        int PORT = 12345;
        
        Controller.startServer(12345);
        
        Client client = new Client(addr, PORT, this.name , "HUMAN", deck);
        Controller.addClient(client);
        
        Thread clientThread = new Thread(client);
        //clientThread.setDaemon(true);
        clientThread.start();
        started = true;
        
        this.mainMenu1.setVisible(false);
        this.map1.setVisible(false);
        this.table1.setVisible(true);
        //Controller.refreshHandRow();
        
        this.name = name;

    }
    
    public void startAI(List<Card> deck){
            Thread c = new Thread(new Client("localhost", 12345, "BOT_Alf", "AI", deck ));
            c.start();
    }
    
    public void joinMultiPlayer(int PORT,String IP,List<Card> deck){
        setPoints(0, 0);
        this.add(table1);
        this.table1.resetEnemyPassed();
        this.table1.resetPassed();
        this.table1.setSize(this.getWidth(), this.getHeight());
        this.table1.clearLog();
        Client client = new Client(IP, PORT, this.name , "HUMAN", deck);
        
        
        Controller.addClient(client);
        
        Thread clientThread = new Thread(client);
        clientThread.setDaemon(true);
        clientThread.start();
        started = true;
        
        this.mainMenu1.setVisible(false);
        this.table1.setVisible(true);
        //Controller.refreshHandRow();
        this.name = name;
    }
    /*
    public Tronfoglalo(String name,String mode) {
        this.name = name;
        List<Card> cards = Cards.getCards("mycards");
        List<Card> deck = Cards.getCards("deck");
        Controller.addGUI(this,cards,deck,name);
        initComponents();
    }
*/
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        table1 = new GUI.Table();
        editDeck1 = new GUI.EditDeck();
        map1 = new GUI.Map();
        mainMenu1 = new GUI.MainMenu();

        table1.setEnabled(false);
        table1.setMaximumSize(new java.awt.Dimension(10000, 6000));
        table1.setName(""); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 51, 0));
        setMinimumSize(new java.awt.Dimension(1000, 600));
        setName("Trónfoglaló"); // NOI18N
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });
        getContentPane().add(mainMenu1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
      if(started){  
        //System.out.println("Height: " + this.getHeight());
        //System.out.println("Width: " + this.getWidth());
        this.table1.setSize(this.getWidth(), this.getHeight());
        this.mainMenu1.setSize(this.getWidth(), this.getHeight());
        this.editDeck1.setSize(this.getWidth(), this.getHeight());
        this.map1.setSize(this.getWidth(), this.getHeight());
        
        
        Controller.refreshHandRow();
        for(int i = 0; i < 4; i++){
            Controller.refreshRow(i);
        }
      }else{
        this.table1.setSize(this.getWidth(), this.getHeight());
        this.mainMenu1.setSize(this.getWidth(), this.getHeight());
        this.editDeck1.setSize(this.getWidth(), this.getHeight());
        this.map1.setSize(this.getWidth(), this.getHeight());
      }
    }//GEN-LAST:event_formComponentResized

    public void setMyName(String name){
        table1.setMyName(name);
    }
    
    public void setEnemyName(String name){
        table1.setEnemyName(name);
    }
    
    public void setEnemyCards(String cards){
        table1.setEnemyCards(cards);
    }
    
    public void refreshHandRow(){
        this.table1.refreshHandRow();
        
        this.revalidate();
        this.repaint();
        this.doLayout();       
    }
    
    public Table getTable(){
        return table1;
    }
    
    public void refreshRow(List<Card> cards,int row, int points){
        this.table1.refreshRow(cards,row,points);
        
        this.revalidate();
        this.repaint();
        this.doLayout();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.EditDeck editDeck1;
    private GUI.MainMenu mainMenu1;
    private GUI.Map map1;
    private GUI.Table table1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        this.setVisible(true);
    }

    public void disableHand() {
        table1.disableHand();
    }

    public void enableHand() {
        table1.enableHand();
        System.out.println(java.lang.Thread.activeCount());
    }

    public void setEnemyLifes(String lifes) {
        table1.setEnemyLifes(lifes);
    }

    public void setMyCards(String size) {
        table1.setMyCards(size);
    }

    public void setMyLifes(String string) {
        table1.setMyLifes(string);
    }

    public void setPoints(int myPoints, int enemyPoints) {
       table1.setPoints(myPoints,enemyPoints);
    }

    public void editDeck() {
        this.editDeck1.init();
        this.add(editDeck1);
        this.mainMenu1.setVisible(false);
        editDeck1.setVisible(true);
    }
    
    public void editDeckBack() {
        this.remove(editDeck1);
        this.mainMenu1.setVisible(true);
        editDeck1.setVisible(false);
    }

    public void enemyPassed() {
        table1.enemyPassed();
    }

    public void showWinner(int playerOneLives, int playerTwoLives) {
        System.out.println("p1l:" + playerOneLives);
        System.out.println("p2l:" + playerTwoLives);
        String winnerMsg = "Draw";
        if(playerOneLives > playerTwoLives){
            winnerMsg="The winner is " + table1.getMyName();
        }
        if(playerOneLives < playerTwoLives){
            winnerMsg="The winner is " + table1.getEnemyName();
        }
        JOptionPane winner = new JOptionPane("The winner is:");
        winner.showMessageDialog(this, winnerMsg);
        this.table1.setVisible(false);
        this.mainMenu1.setVisible(true);
    }

    public void resetEnemyPassed() {
        table1.resetEnemyPassed();
    }
    
    public void resetPassed(){
        table1.resetPassed();
    }
    
    public void log(String text){
        table1.log(text);
    }

    public String getEnemyName() {
       return table1.getEnemyName();
    }

    public void gameExit() {
        this.remove(table1);
        this.mainMenu1.setVisible(true);
        table1.setVisible(false);
    }

    public void exit() {
        System.exit(0);
    }

    public void showGameLost() {
        JOptionPane lost = new JOptionPane("You lost the game");
        lost.showMessageDialog(this, "You have lost the game! The card and saves will reset!");
    }
    
    public void cardNumberCheck(){
        mainMenu1.cardNumberCheck();
    }

}
