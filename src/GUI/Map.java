package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Map extends javax.swing.JPanel {
    JLabel p1 = new JLabel();
    JLabel p2 = new JLabel();
    JLabel p3 = new JLabel();
    
    
    public Map() {
        initComponents();
        GridBagLayout gl = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        
        sector1.setLayout(gl);
        sector2.setLayout(gl);
        sector3.setLayout(gl);
        sectorButtons.add(sector1);
        sectorButtons.add(sector2);
        sectorButtons.add(sector3);
        sector1.setBorder(BorderFactory.createLineBorder(new Color(102, 51, 0), 4, true));
        sector2.setBorder(BorderFactory.createLineBorder(new Color(102, 51, 0), 4, true));
        sector3.setBorder(BorderFactory.createLineBorder(new Color(102, 51, 0), 4, true));
        c.gridy = 1; c.weighty = 0.9;
        sector1.add(p1,c);
        sector2.add(p2,c);
        sector3.add(p3,c);
        c.gridy = 2; c.weighty = 0.1;
        sector1.add(new JLabel("sector1"),c);
        sector2.add(new JLabel("sector2"),c);
        sector3.add(new JLabel("sector3"),c);
        
        sector2.setEnabled(false);
        sector3.setEnabled(false);
    }
    
    public void display(){
       
        p1.setIcon(new ImageIcon(getScaledImage(new ImageIcon("data/map1.png").getImage(), this.getWidth()/3, this.getHeight())));
        p2.setIcon(new ImageIcon(getScaledImage(new ImageIcon("data/map2.png").getImage(), this.getWidth()/3, this.getHeight())));
        p3.setIcon(new ImageIcon(getScaledImage(new ImageIcon("data/map3.png").getImage(), this.getWidth()/3, this.getHeight())));
        
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

        sectorButtons = new javax.swing.ButtonGroup();
        startButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        sector1 = new javax.swing.JToggleButton();
        sector2 = new javax.swing.JToggleButton();
        sector3 = new javax.swing.JToggleButton();

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
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        add(backButton, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(sector1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(sector2, gridBagConstraints);
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
        // TODO add your handling code here:
    }//GEN-LAST:event_backButtonActionPerformed

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_startButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JToggleButton sector1;
    private javax.swing.JToggleButton sector2;
    private javax.swing.JToggleButton sector3;
    private javax.swing.ButtonGroup sectorButtons;
    private javax.swing.JButton startButton;
    // End of variables declaration//GEN-END:variables
}
