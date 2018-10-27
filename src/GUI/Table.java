package GUI;

import Cards.Card;
import Cards.Cards;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Logic.Controller;
import javax.swing.BorderFactory;


public class Table extends javax.swing.JPanel {
    private int p = 0;
    public boolean enabled = false;

    public Table() {
        initComponents();
        
        revalidate();
        repaint();
        doLayout();
    }

    public void setMyName(String name){
        this.myName.setText(name);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        enemyBackRow = new GUI.RowGui();
        enemyFrontRow = new GUI.RowGui();
        myFrontRow = new GUI.RowGui();
        myBackRow = new GUI.RowGui();
        myBackPoint = new javax.swing.JLabel();
        enemyFrontPoint = new javax.swing.JLabel();
        myFrontPoint = new javax.swing.JLabel();
        enemyBackPoint = new javax.swing.JLabel();
        passButton = new javax.swing.JButton();
        placeButton = new javax.swing.JButton();
        playerOnePanel = new javax.swing.JPanel();
        myName = new javax.swing.JLabel();
        myPoints = new javax.swing.JLabel();
        PlayerCards = new javax.swing.JLabel();
        playerPoints = new javax.swing.JLabel();
        playerName = new javax.swing.JLabel();
        playerLifes = new javax.swing.JLabel();
        myCards = new javax.swing.JLabel();
        myLifes = new javax.swing.JLabel();
        playerTwoPanel = new javax.swing.JPanel();
        enemyName = new javax.swing.JLabel();
        enemyPoints = new javax.swing.JLabel();
        PlayerCards1 = new javax.swing.JLabel();
        playerPoints1 = new javax.swing.JLabel();
        playerName1 = new javax.swing.JLabel();
        playerLifes1 = new javax.swing.JLabel();
        enemyCards = new javax.swing.JLabel();
        enemyLifes = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        handRow = new GUI.RowGui(placeButton);

        setBackground(new java.awt.Color(221, 188, 169));
        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setMinimumSize(new java.awt.Dimension(1000, 600));
        setPreferredSize(new java.awt.Dimension(1300, 900));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });
        setLayout(new java.awt.GridBagLayout());

        enemyBackRow.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 51, 0), 4, true));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 908;
        gridBagConstraints.ipady = 122;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.9;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        add(enemyBackRow, gridBagConstraints);

        enemyFrontRow.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 51, 0), 4, true));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 908;
        gridBagConstraints.ipady = 122;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.9;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        add(enemyFrontRow, gridBagConstraints);

        myFrontRow.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 51, 0), 4, true));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 908;
        gridBagConstraints.ipady = 122;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.9;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        add(myFrontRow, gridBagConstraints);

        myBackRow.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 51, 0), 4, true));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 907;
        gridBagConstraints.ipady = 122;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.9;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        add(myBackRow, gridBagConstraints);

        myBackPoint.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        myBackPoint.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        myBackPoint.setText("0");
        myBackPoint.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 5, true));
        myBackPoint.setMinimumSize(new java.awt.Dimension(40, 32));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 19;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 1, 0, 1);
        add(myBackPoint, gridBagConstraints);

        enemyFrontPoint.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        enemyFrontPoint.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        enemyFrontPoint.setText("0");
        enemyFrontPoint.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 5, true));
        enemyFrontPoint.setMinimumSize(new java.awt.Dimension(40, 32));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 19;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 1, 0, 1);
        add(enemyFrontPoint, gridBagConstraints);

        myFrontPoint.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        myFrontPoint.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        myFrontPoint.setText("0");
        myFrontPoint.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 5, true));
        myFrontPoint.setMinimumSize(new java.awt.Dimension(40, 32));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 19;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 1, 0, 1);
        add(myFrontPoint, gridBagConstraints);

        enemyBackPoint.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        enemyBackPoint.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        enemyBackPoint.setText("0");
        enemyBackPoint.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 5, true));
        enemyBackPoint.setMinimumSize(new java.awt.Dimension(40, 32));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 19;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 1, 0, 1);
        add(enemyBackPoint, gridBagConstraints);

        passButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        passButton.setText("Pass");
        passButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 51, 0), 8, true));
        passButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 40;
        gridBagConstraints.ipady = 99;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(13, 3, 13, 3);
        add(passButton, gridBagConstraints);

        placeButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        placeButton.setText("Place");
        placeButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 51, 0), 8, true));
        placeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                placeButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 36;
        gridBagConstraints.ipady = 99;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(13, 3, 13, 3);
        add(placeButton, gridBagConstraints);

        playerOnePanel.setBackground(new java.awt.Color(255, 217, 179));
        playerOnePanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 51, 0), 4, true));
        playerOnePanel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        java.awt.GridBagLayout playerOnePanelLayout = new java.awt.GridBagLayout();
        playerOnePanelLayout.columnWidths = new int[] {0, 5, 0};
        playerOnePanelLayout.rowHeights = new int[] {0, 5, 0, 5, 0, 5, 0};
        playerOnePanel.setLayout(playerOnePanelLayout);

        myName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        myName.setText("PLAYERONE");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        playerOnePanel.add(myName, gridBagConstraints);

        myPoints.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        myPoints.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.5;
        playerOnePanel.add(myPoints, gridBagConstraints);

        PlayerCards.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        PlayerCards.setText("Cards:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        playerOnePanel.add(PlayerCards, gridBagConstraints);

        playerPoints.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        playerPoints.setText("Points:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        playerOnePanel.add(playerPoints, gridBagConstraints);

        playerName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        playerName.setText("Name:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        playerOnePanel.add(playerName, gridBagConstraints);

        playerLifes.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        playerLifes.setText("Lifes:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        playerOnePanel.add(playerLifes, gridBagConstraints);

        myCards.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        myCards.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        playerOnePanel.add(myCards, gridBagConstraints);

        myLifes.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        myLifes.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        playerOnePanel.add(myLifes, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        add(playerOnePanel, gridBagConstraints);

        playerTwoPanel.setBackground(new java.awt.Color(255, 217, 179));
        playerTwoPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 51, 0), 4, true));
        playerTwoPanel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        playerTwoPanel.setLayout(new java.awt.GridBagLayout());

        enemyName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        enemyName.setText("PLAYERTWO");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        playerTwoPanel.add(enemyName, gridBagConstraints);

        enemyPoints.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        enemyPoints.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.5;
        playerTwoPanel.add(enemyPoints, gridBagConstraints);

        PlayerCards1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        PlayerCards1.setText("Cards:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        playerTwoPanel.add(PlayerCards1, gridBagConstraints);

        playerPoints1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        playerPoints1.setText("Points:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        playerTwoPanel.add(playerPoints1, gridBagConstraints);

        playerName1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        playerName1.setText("Name:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        playerTwoPanel.add(playerName1, gridBagConstraints);

        playerLifes1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        playerLifes1.setText("Lifes:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        playerTwoPanel.add(playerLifes1, gridBagConstraints);

        enemyCards.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        enemyCards.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        playerTwoPanel.add(enemyCards, gridBagConstraints);

        enemyLifes.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        enemyLifes.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        playerTwoPanel.add(enemyLifes, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        add(playerTwoPanel, gridBagConstraints);

        handRow.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 51, 0), 4, true));
        handRow.setPreferredSize(null);
        handRow.setLayout(new FlowLayout());
        jScrollPane1.setViewportView(handRow);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jScrollPane1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void placeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_placeButtonActionPerformed
        Card card = handRow.getSelected();
        Controller.sendCard(card);
        Controller.removeCard(card);
        refreshHandRow();
    }//GEN-LAST:event_placeButtonActionPerformed

    private void passButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passButtonActionPerformed
        Controller.sendCard(null);
    }//GEN-LAST:event_passButtonActionPerformed

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
       int width = this.getWidth();
       int height = (int) Math.round( (this.getHeight() * 0.9) / 5 );
       handRow.setMaximumSize(new Dimension(width, height));
       handRow.setMinimumSize(new Dimension(0, height));
       
       myFrontRow.setMaximumSize(new Dimension(width, height));
       myFrontRow.setMinimumSize(new Dimension(0, height));
       
       myBackRow.setMaximumSize(new Dimension(width, height));
       myBackRow.setMinimumSize(new Dimension(0, height));
       
       enemyFrontRow.setMaximumSize(new Dimension(width, height));
       enemyFrontRow.setMinimumSize(new Dimension(0, height));
       
       enemyBackRow.setMaximumSize(new Dimension(width, height));
       enemyBackRow.setMinimumSize(new Dimension(0, height));
    }//GEN-LAST:event_formComponentResized


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel PlayerCards;
    private javax.swing.JLabel PlayerCards1;
    private javax.swing.JLabel enemyBackPoint;
    private GUI.RowGui enemyBackRow;
    private javax.swing.JLabel enemyCards;
    private javax.swing.JLabel enemyFrontPoint;
    private GUI.RowGui enemyFrontRow;
    private javax.swing.JLabel enemyLifes;
    private javax.swing.JLabel enemyName;
    private javax.swing.JLabel enemyPoints;
    private GUI.RowGui handRow;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel myBackPoint;
    private GUI.RowGui myBackRow;
    private javax.swing.JLabel myCards;
    private javax.swing.JLabel myFrontPoint;
    private GUI.RowGui myFrontRow;
    private javax.swing.JLabel myLifes;
    private javax.swing.JLabel myName;
    private javax.swing.JLabel myPoints;
    private javax.swing.JButton passButton;
    private javax.swing.JButton placeButton;
    private javax.swing.JLabel playerLifes;
    private javax.swing.JLabel playerLifes1;
    private javax.swing.JLabel playerName;
    private javax.swing.JLabel playerName1;
    private javax.swing.JPanel playerOnePanel;
    private javax.swing.JLabel playerPoints;
    private javax.swing.JLabel playerPoints1;
    private javax.swing.JPanel playerTwoPanel;
    // End of variables declaration//GEN-END:variables

    public void refreshHandRow() {
        handRow.refresh(Controller.getHand());
        placeButton.setEnabled(enabled);
        passButton.setEnabled(enabled);
        if(enabled){
            handRow.setEnabled();
        }
        
    }
    
    public void refreshRow(List<Card> cards, int row, int points) {
        
        switch(row){
            case 0: myFrontRow.refresh(cards); myFrontPoint.setText(""+points); break;
            
            case 1: myBackRow.refresh(cards); myBackPoint.setText(""+points); break;
            
            case 2: enemyFrontRow.refresh(cards); enemyFrontPoint.setText(""+points); break;
            
            case 3: enemyBackRow.refresh(cards); enemyBackPoint.setText(""+points);break;
        }

        this.revalidate();
        this.repaint();
        this.doLayout();
        
    }
    
    public void enableHand(){
        this.enabled = true;
        handRow.setEnabled();
        passButton.setEnabled(enabled);
        placeButton.setEnabled(enabled);
    }
    
     public void disableHand(){
        this.enabled = false;
        handRow.setDisabled();
        passButton.setEnabled(enabled);
        placeButton.setEnabled(enabled);
    }

    public void setEnemyName(String name) {
        this.enemyName.setText(name);
    }

    void setEnemyCards(String cards) {
        this.enemyCards.setText(cards);
    }

    void setEnemyLifes(String lifes) {
       this.enemyLifes.setText(lifes);
    }

    void setMyCards(String size) {
        this.myCards.setText(size);
    }

    void setMyLifes(String string) {
        this.myLifes.setText(string);
    }

    void setPoints(int myPoints, int enemyPoints) {
        this.myPoints.setText(myPoints + "");
        this.enemyPoints.setText(enemyPoints + "");
        if(enemyPoints > myPoints){
            this.playerOnePanel.setBackground(new Color(255,217,179));
            this.playerTwoPanel.setBackground(Color.GREEN);
        }else if( enemyPoints < myPoints){
            this.playerOnePanel.setBackground(Color.GREEN);
            this.playerTwoPanel.setBackground(new Color(255,217,179));
        }else{
            this.playerOnePanel.setBackground(new Color(255,217,179));
            this.playerTwoPanel.setBackground(new Color(255,217,179));
        }
    }

    void enemyPassed() {
        playerTwoPanel.setBorder(BorderFactory.createLineBorder(Color.red, 4, true));
    }

}
