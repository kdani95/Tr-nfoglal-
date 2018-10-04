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

    public Tronfoglalo() {
        
        initComponents();
                
        Cards.init();
        String addr = "localhost";
        int PORT = 12345;
        List<Card> deck = new ArrayList<Card>();
        deck.add(Cards.getCard(0));
        deck.add(Cards.getCard(1));
        deck.add(Cards.getCard(0));
        deck.add(Cards.getCard(1));

        Client client = new Client(addr, PORT, "ASD", "HUMAN", deck);
        Controller.addClient(client);
        Controller.addGUI(this);
        this.refreshHandRow();
        client.run();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        table1 = new GUI.Table();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 51, 0));
        setName("Trónfoglaló"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1200, 800));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(table1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(45, 45, 45))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(table1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(62, 62, 62))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
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
    
   /* public void addCard(Card){
        
    }*/

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
}
