package Cards;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CardsTest {
    
    private static String playerName = "TEST_PLAYER";
    
    @BeforeClass
    public static void setUpClass() {
        Cards.init();
        Cards.initPlayer(playerName);
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        Cards.resetPlayer(playerName);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void a_playerTest(){
        assertEquals(0, Cards.getCards(playerName, "deck").size());
        assertEquals(21, Cards.getCards(playerName, "mycards").size());
    }
    
    @Test
    public void b_moveTest(){
        assertEquals(0, Cards.getCards(playerName, "deck").size());
        assertEquals(21, Cards.getCards(playerName, "mycards").size());
        
        for(Card c : Cards.getCards(playerName, "mycards")){
            Cards.moveToDeck(playerName, c.getID());
        }
        
        assertEquals(21, Cards.getCards(playerName, "deck").size());
        assertEquals(0, Cards.getCards(playerName, "mycards").size());
        
        for(Card c : Cards.getCards(playerName, "deck")){
            Cards.moveToMycards(playerName, c.getID());
        }
        
        assertEquals(0, Cards.getCards(playerName, "deck").size());
        assertEquals(21, Cards.getCards(playerName, "mycards").size());
    }
    
    @Test
    public void c_resetPlayerTest(){
        assertEquals(0, Cards.getCards(playerName, "deck").size());
        assertEquals(21, Cards.getCards(playerName, "mycards").size());
    }
    
    @Test
    public void d_getCardTest(){
        Card c = Cards.getCard(1);
        assertEquals("Knight", c.getName());
        assertEquals(6, c.getStrength());
        
        c = Cards.getCard(4);
        assertEquals("Sorcerer", c.getName());
        assertEquals(6, c.getStrength());
        assertEquals(2, c.getPower());
        
        c = Cards.getCard(11);
        assertEquals("Plague", c.getName());
        assertEquals(0, c.getStrength());
        assertEquals("plague", c.getAbility());
    }
    
}
