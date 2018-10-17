package GUI;

import Cards.Card;
import com.sun.prism.impl.Disposer;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JToggleButton;

class Mybutton extends JToggleButton{
    Card card;
    
    public void setCard(Card card){
        this.card = card;
    }
    
    public Card getCard(){
        return this.card;
    }
}

public class RowGui extends javax.swing.JPanel {
    
    //private List<Card> cards = new ArrayList<Card>();
    //private List<JToggleButton> buttons = new ArrayList<JToggleButton>();
    
    private List<Mybutton> buttons = new ArrayList<Mybutton>();

    private javax.swing.ButtonGroup cardDisplay;    
    
    public RowGui() {
        initComponents();

    }
    
    private Image getScaledImage(Image srcImg, int w, int h){
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();

        return resizedImg;
}
    
    public void setDisabled(){
        for(Mybutton mb : buttons){
            mb.setEnabled(false);
        }
    }
    
    public void setEnabled(){
        for(Mybutton mb : buttons){
            mb.setEnabled(true);
        }
    }
    
    public void addCard(Card card){
        //this.cards.add(card);
        GridBagLayout gl = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        int height = (int) Math.round(this.getHeight() * 0.75);
        int width = (int) Math.round( height * 0.7);
        ImageIcon image = new ImageIcon(card.getPictureLoc());
        
        Mybutton button = new Mybutton();
        button.setLayout(gl);
        button.setCard(card);
        button.setBorder(BorderFactory.createLineBorder(Color.black, 3, true));
        button.setBackground(card.getColor());
        //button.setMaximumSize(new Dimension(width, height));
        //button.setPreferredSize(new Dimension(width, height));
        Image resized = getScaledImage(image.getImage(), width, height);
        
        //button.setIcon(new ImageIcon(resized));
        button.setEnabled(false);
        
        JLabel inner = new JLabel();
        inner.setMaximumSize(new Dimension(width, height));
        inner.setPreferredSize(new Dimension(width, height));
        inner.setIcon(new ImageIcon(resized));
        JLabel strength = new JLabel("Strength: "+card.getStrength());
        strength.setForeground(Color.BLACK);
        //strength.setMaximumSize(new Dimension(width, height / 10));
        //strength.setMinimumSize(new Dimension(width, height /10));
        c.gridy = 1; c.weighty = 0.9;
        button.add(strength,c);
        c.gridy = 0; c.weighty = 0.1;
        button.add(inner,c);
        
        this.buttons.add(button);
        cardDisplay.add(button);
       
        this.add(button);
       
        this.revalidate();
        this.repaint();
        this.doLayout();
    }
    
    public void refresh(List<Card> cards){
        for(Mybutton mb :  buttons){
            cardDisplay.remove(mb);
            this.remove(mb);
        }
        buttons.clear();
        
        for(Card c : cards){
            this.addCard(c);
            //System.out.println("name : " + c.getName() );
        }
        
        this.revalidate();
        this.repaint();
        this.doLayout();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        cardDisplay = new javax.swing.ButtonGroup();

        setBackground(new java.awt.Color(255, 217, 179));
        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        setPreferredSize(new java.awt.Dimension(1000, 130));

        this.setLayout(new GridBagLayout());
        //GridBagConstraints c = new GridBagConstraints();
    }                    

    public Card getSelected(){
        Mybutton selected = null;
        for(Mybutton mb : buttons){
            if(mb.isSelected()){
                selected = mb;
            }
        }
        cardDisplay.clearSelection();
        return selected.getCard();
    }
                          
}
