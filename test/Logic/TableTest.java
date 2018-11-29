package Logic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TableTest {
    private Table table;
    
    
    public TableTest() {
        
    }
    
    @Before
    public void setUp() {
        this.table = new Table();
    }
    
    @After
    public void tearDown() {
    }

    
    @Test
    public void simpleTest() {
        Cards.Cards.init();
        boolean result = true;
        
        for(int i = 1; i <= 13; i++){
            Cards.Card testCard = Cards.Cards.getCard(i);
            //System.out.println(testCard.getName());
            
            table.addCard(testCard, 1);
            table.addCard(testCard, 2);
            
            assertEquals(table.getPlayerOnePoints(), testCard.getStrength());
            assertEquals(table.getPlayerTwoPoints(), testCard.getStrength());
            
            table = new Table();
        }
        
        System.out.println("Simple test passed");
    }
    
    @Test
    public void allCardsTest() {
        Cards.Cards.init();
        boolean result = true;
        
        for(int i = 1; i <= 13; i++){
            Cards.Card testCard = Cards.Cards.getCard(i);
            Cards.Card testCard2 = Cards.Cards.getCard(i);
            //System.out.println(testCard.getName());
            
            table.addCard(testCard, 1);
            table.addCard(testCard2, 2);
            

        }
        
        assertEquals(24, table.getPlayerOnePoints());
        assertEquals(24, table.getPlayerOnePoints());
        
        System.out.println("All cards test passed");
    }
    
    public int playerPoints(){
        return table.getPlayerOnePoints();
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
