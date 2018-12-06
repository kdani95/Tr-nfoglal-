package Logic;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TableTest {
    private Table table;
    
    
    public TableTest() {
        
    }
    
    @BeforeClass
    public static void before(){
        Cards.Cards.init();
    }
    
    @Before
    public void setUp() {
        this.table = new Table();
        System.out.println("New table created");
    }
    
    @After
    public void tearDown() {
    }

    
    @Test
    public void oneCardTest() {
        this.table = new Table();
        for(int i = 1; i <= 13; i++){
            Cards.Card testCard = Cards.Cards.getCard(i);

            table.addCard(testCard, 1);
            table.addCard(testCard, 2);
            
            assertEquals(table.getPlayerOnePoints(), testCard.getStrength());
            assertEquals(table.getPlayerTwoPoints(), testCard.getStrength());
            
            table = new Table();
        }
    }
    
    @Test
    public void allCardsTest() {
        this.table = new Table();
        for(int i = 1; i <= 13; i++){
            Cards.Card testCard = Cards.Cards.getCard(i);
            Cards.Card testCard2 = Cards.Cards.getCard(i);
            table.addCard(testCard, 1);
            table.addCard(testCard2, 2);
        }
        
        assertEquals(24, table.getPlayerOnePoints());
        assertEquals(24, table.getPlayerTwoPoints());
    }
    
    @Test
    public void plagueCardsTest() {
        for(int i = 0; i < 4; i++){
            Cards.Card testCard = Cards.Cards.getCard(2); //soldier
            Cards.Card testCard2 = Cards.Cards.getCard(5); //archer
            table.addCard(testCard, 1);
            table.addCard(testCard2, 2);
        }
        
        Cards.Card plague = Cards.Cards.getCard(11);
        
        table.addCard(plague, 1);
        
        assertEquals(0, table.getPlayerOnePoints());
        assertEquals(0, table.getPlayerTwoPoints());
    }
    
    @Test
    public void fogCardsTest() {
        for(int i = 0; i < 4; i++){
            Cards.Card testCard = Cards.Cards.getCard(2); //soldier
            Cards.Card testCard2 = Cards.Cards.getCard(5); //archer
            table.addCard(testCard, 1);
            table.addCard(testCard2, 2);
        }
        
        Cards.Card fog = Cards.Cards.getCard(13);
        
        table.addCard(fog, 1);
        
        assertEquals(16, table.getPlayerOnePoints());
        assertEquals(8, table.getPlayerTwoPoints());
    }
    
    @Test
    public void frostCardsTest() {
        for(int i = 0; i < 4; i++){
            Cards.Card testCard = Cards.Cards.getCard(2); //soldier
            Cards.Card testCard2 = Cards.Cards.getCard(5); //archer
            table.addCard(testCard, 1);
            table.addCard(testCard2, 2);
        }
        
        Cards.Card frost = Cards.Cards.getCard(12);
        
        table.addCard(frost, 0);
        
        assertEquals(8, table.getPlayerOnePoints());
        assertEquals(16, table.getPlayerTwoPoints());
    }
    
    @Test
    public void deleteCardsTest() {
        
        Cards.Card testCard = Cards.Cards.getCard(2); //soldier
        Cards.Card testCard2 = Cards.Cards.getCard(5); //archer

        table.addCard(testCard, 1);
        table.addCard(testCard2, 1);
        
        table.removeCard(testCard);
        table.removeCard(testCard2);
        
        assertEquals(0, table.getPlayerOnePoints());
        assertEquals(0, table.getPlayerTwoPoints());
    }
    
    @Test
    public void tryCardsTest() {
        
        Cards.Card testCard = Cards.Cards.getCard(2); //soldier
        Cards.Card testCard2 = Cards.Cards.getCard(5); //archer

        table.addCard(testCard, 2);
        
        int tryCard = table.tryCard(testCard2, 1);
        
        assertEquals(4, tryCard);
        
    }
    
}
