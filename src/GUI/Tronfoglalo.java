package GUI;

import Cards.Card;
import Cards.Cards;
import Client.Client;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tronfoglalo.Controller;

public class Tronfoglalo extends javax.swing.JFrame implements Runnable{
    private boolean started = false;
    public Tronfoglalo() {
         
        Cards.init();
        String addr = "localhost";
        int PORT = 12345;
        List<Card> deck = new ArrayList<Card>();
        deck.add(Cards.getCard(0));
        deck.add(Cards.getCard(1));
        deck.add(Cards.getCard(0));
        deck.add(Cards.getCard(1));
        deck.add(Cards.getCard(2));
        deck.add(Cards.getCard(2));
        deck.add(Cards.getCard(1));
        deck.add(Cards.getCard(2));
        deck.add(Cards.getCard(1));
        deck.add(Cards.getCard(0));
        initComponents();
        
        Client client = new Client(addr, PORT, "Danika", "HUMAN", deck);
        Controller.addClient(client);
        Controller.addGUI(this);
        
        setMyName(client.getName());

        client.run();
        started = true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        table1 = new GUI.Table();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 51, 0));
        setMinimumSize(new java.awt.Dimension(1000, 600));
        setName("Trónfoglaló"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1300, 900));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        table1.setMaximumSize(new java.awt.Dimension(10000, 6000));
        table1.setMinimumSize(new java.awt.Dimension(1000, 600));
        table1.setName(""); // NOI18N
        getContentPane().add(table1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
      if(started){  
        System.out.println("Height: " + this.getHeight());
        System.out.println("Width: " + this.getWidth());
        this.table1.setSize(this.getWidth(), this.getHeight());
        
        Controller.refreshHandRow();
        for(int i = 0; i < 4; i++){
            Controller.refreshRow(i);
        }
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


    
    
}
