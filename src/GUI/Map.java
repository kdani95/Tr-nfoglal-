package GUI;

import Logic.Controller;
import Logic.Save;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Map extends javax.swing.JPanel {
    JLabel p1 = new JLabel();
    JLabel p2 = new JLabel();
    JLabel p3 = new JLabel();
    
    public Map() {
        initComponents();
        
        BorderLayout bl = new BorderLayout();
        
        difficultyButtons.add(diff1);
        difficultyButtons.add(diff2);
        difficultyButtons.add(diff3);
       
        JLabel l1 = new JLabel("Beach");
        l1.setBackground(new Color(0, 0, 0, 0));
        sector1.add(l1);
        JLabel l2 = new JLabel("Forest");
        l2.setBackground(new Color(0, 0, 0, 0));
        sector2.add(l2);
        JLabel l3 = new JLabel("Castle");
        l3.setBackground(new Color(0, 0, 0, 0));
        sector3.add(l3);

        diff1.setSelected(true);
    }
    
    public void display(){ 
        p1.setIcon(new ImageIcon(getScaledImage(new ImageIcon("data/map1.png").getImage(), this.getWidth()/3, this.getHeight() - 200)));
        p2.setIcon(new ImageIcon(getScaledImage(new ImageIcon("data/map2.png").getImage(), this.getWidth()/3, this.getHeight() - 200)));
        p3.setIcon(new ImageIcon(getScaledImage(new ImageIcon("data/map3.png").getImage(), this.getWidth()/3, this.getHeight() - 200)));
        
        sector1.add(p1);
        sector2.add(p2);
        sector3.add(p3);
        
        switch(Save.getSave(Controller.getName())){
            case 0: sector1.setOpaque(true); sector2.setOpaque(false); sector3.setOpaque(false); break;
            case 1: sector1.setOpaque(false); sector2.setOpaque(true); sector3.setOpaque(false); break;
            case 2: sector1.setOpaque(false); sector2.setOpaque(false); sector3.setOpaque(true); break;
        }
        
    }

    private Image getScaledImage(Image srcImg, int w, int h){
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();

        return resizedImg;
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        difficultyButtons = new javax.swing.ButtonGroup();
        startButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        diff1 = new javax.swing.JRadioButton();
        diff2 = new javax.swing.JRadioButton();
        diff3 = new javax.swing.JRadioButton();
        difficultyLabel = new javax.swing.JLabel();
        sector1 = new javax.swing.JPanel();
        sector2 = new javax.swing.JPanel();
        sector3 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(221, 188, 169));
        setMinimumSize(new java.awt.Dimension(8, 8));
        setPreferredSize(new java.awt.Dimension(1300, 900));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });
        setLayout(new java.awt.GridBagLayout());

        startButton.setText("Start Game");
        startButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 51, 0), 4, true));
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 0.05;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        add(startButton, gridBagConstraints);

        backButton.setText("Back");
        backButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 51, 0), 4, true));
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        add(backButton, gridBagConstraints);

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 51, 0), 4, true));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        diff1.setText("EASY");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        jPanel1.add(diff1, gridBagConstraints);

        diff2.setText("MEDIUM");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        jPanel1.add(diff2, gridBagConstraints);

        diff3.setText("HARD");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        jPanel1.add(diff3, gridBagConstraints);

        difficultyLabel.setText("DIFFICULTY");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        jPanel1.add(difficultyLabel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.75;
        gridBagConstraints.weighty = 1.0;
        add(jPanel1, gridBagConstraints);

        sector1.setBackground(new java.awt.Color(102, 153, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(sector1, gridBagConstraints);

        sector2.setBackground(new java.awt.Color(102, 153, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(sector2, gridBagConstraints);

        sector3.setBackground(new java.awt.Color(102, 153, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(sector3, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        display();
    }//GEN-LAST:event_formComponentResized

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        Controller.closeMap();
    }//GEN-LAST:event_backButtonActionPerformed

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        if(diff1.isSelected()){
            Controller.setDifficulty(1);
        }else if(diff2.isSelected()){
            Controller.setDifficulty(2);
        }else if (diff3.isSelected()){
            Controller.setDifficulty(3);
        }
        
        Controller.startSinglePlayer();

    }//GEN-LAST:event_startButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JRadioButton diff1;
    private javax.swing.JRadioButton diff2;
    private javax.swing.JRadioButton diff3;
    private javax.swing.ButtonGroup difficultyButtons;
    private javax.swing.JLabel difficultyLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel sector1;
    private javax.swing.JPanel sector2;
    private javax.swing.JPanel sector3;
    private javax.swing.JButton startButton;
    // End of variables declaration//GEN-END:variables
}
