package GUI;

import tronfoglalo.Controller;


public class MainMenu extends javax.swing.JPanel {

    /**
     * Creates new form MainMenu
     */
    public MainMenu() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        startSinglePlayer = new javax.swing.JButton();
        startMultiPlayer = new javax.swing.JButton();
        joinMultiPlayer = new javax.swing.JButton();

        setBackground(new java.awt.Color(221, 188, 169));
        setMinimumSize(new java.awt.Dimension(1000, 600));
        setPreferredSize(new java.awt.Dimension(1300, 900));

        startSinglePlayer.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        startSinglePlayer.setText("Start SinglePlayer");
        startSinglePlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startSinglePlayerActionPerformed(evt);
            }
        });

        startMultiPlayer.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        startMultiPlayer.setText("Start MultiPlayer");
        startMultiPlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startMultiPlayerActionPerformed(evt);
            }
        });

        joinMultiPlayer.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        joinMultiPlayer.setText("Join MultiPlayer");
        joinMultiPlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                joinMultiPlayerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(216, 216, 216)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(joinMultiPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(startMultiPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(startSinglePlayer, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(225, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(startSinglePlayer, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(startMultiPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(joinMultiPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(296, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void startSinglePlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startSinglePlayerActionPerformed
        Controller.startSinglePlayer();
    }//GEN-LAST:event_startSinglePlayerActionPerformed

    private void startMultiPlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startMultiPlayerActionPerformed
        Controller.startMultiPlayer();
    }//GEN-LAST:event_startMultiPlayerActionPerformed

    private void joinMultiPlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_joinMultiPlayerActionPerformed
        Controller.joinMultiPlayer();
    }//GEN-LAST:event_joinMultiPlayerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton joinMultiPlayer;
    private javax.swing.JButton startMultiPlayer;
    private javax.swing.JButton startSinglePlayer;
    // End of variables declaration//GEN-END:variables
}
