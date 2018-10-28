package GUI;

import Cards.Card;
import java.awt.Dimension;
import java.util.List;
import Logic.Controller;

public class EditDeck extends javax.swing.JPanel {

    private boolean inMenu = false;
    
    public EditDeck() {
        //System.out.println("widht: " + this.getWidth() + " height: " + this.getHeight());
        initComponents();
        resized();
        
    }
    
    public void init(){
        
        
        inMenu = true;
        deckRow.refresh(Controller.getDeck());
        cardsRow.refresh(Controller.getCards());
        deckRow.setEnabled();
        cardsRow.setEnabled();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        cardScrollPane = new javax.swing.JScrollPane();
        cardsRow = new GUI.RowGui();
        deckScrollPane = new javax.swing.JScrollPane();
        deckRow = new GUI.RowGui();
        addButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(221, 188, 169));
        setMinimumSize(new java.awt.Dimension(1000, 600));
        setPreferredSize(new java.awt.Dimension(1300, 900));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });
        setLayout(new java.awt.GridBagLayout());

        cardScrollPane.setViewportView(cardsRow);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 1186;
        gridBagConstraints.ipady = 109;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(70, 0, 0, 0);
        add(cardScrollPane, gridBagConstraints);

        deckScrollPane.setViewportView(deckRow);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 1190;
        gridBagConstraints.ipady = 109;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(70, 0, 0, 0);
        add(deckScrollPane, gridBagConstraints);

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 109;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(70, 10, 0, 10);
        add(addButton, gridBagConstraints);

        removeButton.setText("Remove");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipady = 109;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(70, 10, 0, 10);
        add(removeButton, gridBagConstraints);

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 16;
        gridBagConstraints.ipady = 96;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(70, 10, 10, 10);
        add(backButton, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        resized();
    }//GEN-LAST:event_formComponentResized

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        Card selected = cardsRow.getSelected();
        Controller.addToDeck(selected);
        Cards.Cards.moveToDeck(selected.getID());
        //Controller.removeFromDeck(selected);
        deckRow.refresh(Controller.getDeck());
        deckRow.setEnabled();
        cardsRow.refresh(Controller.getCards());
        cardsRow.setEnabled();
                
    }//GEN-LAST:event_addButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
       Controller.editDeckBack();
    }//GEN-LAST:event_backButtonActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        Card selected = deckRow.getSelected();
        Controller.removeFromDeck(selected);
        Cards.Cards.moveToMycards(selected.getID());
        deckRow.refresh(Controller.getDeck());
        deckRow.setEnabled();
        cardsRow.refresh(Controller.getCards());
        cardsRow.setEnabled();
    }//GEN-LAST:event_removeButtonActionPerformed
   
    private void resized(){
       //System.out.println("widht: " + this.getWidth() + " height: " + this.getHeight());
       int width = this.getWidth()-this.addButton.getWidth();
       int height = (int) Math.round( (this.getHeight() * 0.9) / 5 );

       cardScrollPane.setMaximumSize(new Dimension(width, height));
       //cardScrollPane.setSize(new Dimension(width, height));
       cardScrollPane.setMinimumSize(new Dimension(1, height));
       
       cardsRow.setMaximumSize(new Dimension(width, height));
       cardsRow.setSize(new Dimension(width, height));
       cardsRow.setMinimumSize(new Dimension(1, height));
       
       deckScrollPane.setMaximumSize(new Dimension(width, height));
       //deckScrollPane.setSize(new Dimension(width, height));
       deckScrollPane.setMinimumSize(new Dimension(1, height));
      
       deckRow.setMaximumSize(new Dimension(width, height));
       deckRow.setSize(new Dimension(width, height));
       deckRow.setMinimumSize(new Dimension(1, height));
       
       if(inMenu){
           deckRow.refresh(Controller.getDeck());
           cardsRow.refresh(Controller.getCards());
       }
       
       deckRow.setEnabled();
       cardsRow.setEnabled();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton backButton;
    private javax.swing.JScrollPane cardScrollPane;
    private GUI.RowGui cardsRow;
    private GUI.RowGui deckRow;
    private javax.swing.JScrollPane deckScrollPane;
    private javax.swing.JButton removeButton;
    // End of variables declaration//GEN-END:variables
}
