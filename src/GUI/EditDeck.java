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

        cardScrollPane.setViewportView(cardsRow);

        deckScrollPane.setViewportView(deckRow);

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        removeButton.setText("Remove");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cardScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1046, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(deckScrollPane)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cardScrollPane))
                .addGap(154, 154, 154)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(removeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deckScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
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
