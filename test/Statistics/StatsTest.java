package Statistics;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StatsTest {
    private Stat stat;
    
    public StatsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        Stats.init();
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void a_initTest(){
        
        stat = Stats.getStat("Frost");
        assertEquals( 0.0, stat.getChance(10), 0.1 );
        
        stat = Stats.getStat("Fog");
        assertEquals( 0.0, stat.getChance(10), 0.1 );
        
        stat = Stats.getStat("Plague");
        assertEquals( 0.0, stat.getChance(10), 0.1 );
    }
    
    @Test
    public void b_threeStatTest(){
        stat = Stats.getStat("Frost");
        stat.addStat(2);
        stat.addStat(6);
        stat.addStat(10);
        Stats.refreshStat(stat);
        assertEquals( 0.0, stat.getChance(10), 0.1 );
        assertEquals( 0.0, stat.getChance(2), 0.1 );
        assertEquals( 0.0, stat.getChance(6), 0.1 );
    }
    
    @Test
    public void c_fourthStatTest(){
        stat = Stats.getStat("Frost");
        stat.addStat(6);
        Stats.refreshStat(stat);
        assertEquals( 1.0, stat.getChance(10), 0.1 );
        assertEquals( 0.0, stat.getChance(2), 0.1 );
        assertEquals( 0.5, stat.getChance(6), 0.1 );
    }
    
    @Test
    public void d_avgBiggerHalfTest(){
        stat = Stats.getStat("Fog");
        stat.addStat(2);
        stat.addStat(6);
        stat.addStat(6);
        stat.addStat(8);
        Stats.refreshStat(stat);
        assertEquals( 1.0, stat.getChance(8), 0.1 );
        assertEquals( 0.0, stat.getChance(2), 0.1 );
        assertEquals( 0.5, stat.getChance(5.5), 0.1 );
    }
    
    @Test
    public void e_avgSmallerHalfTest(){
        stat = Stats.getStat("Plague");
        stat.addStat(2);
        stat.addStat(4);
        stat.addStat(4);
        stat.addStat(8);
        Stats.refreshStat(stat);
        assertEquals( 1.0, stat.getChance(8), 0.1 );
        assertEquals( 0.0, stat.getChance(2), 0.1 );
        assertEquals( 0.5, stat.getChance(4.5), 0.1 );
    }
    
    @Test
    public void f_fourSameStatTest(){
        Stats.init();
        stat = Stats.getStat("Frost");
        stat.addStat(6);
        stat.addStat(6);
        stat.addStat(6);
        stat.addStat(6);
        Stats.refreshStat(stat);
        assertEquals( 1.0, stat.getChance(10), 0.1 );
        assertEquals( 0.0, stat.getChance(5), 0.1 );
        assertEquals( 1.0, stat.getChance(6), 0.1 );
    }
    
}
