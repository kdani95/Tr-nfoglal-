package tronfoglalo;

import Statistics.Stat;
import Statistics.Stats;

public class NewClass {
    
    public static void main(String[] args){
        Stat s = Stats.getStat(8);
        s.addStat(2);
        s.addStat(6);
        s.addStat(10);
        s.getChance(10);
        System.out.println("2: " + s.getChance(2));
        System.out.println("6: " + s.getChance(6));
        System.out.println("10: " + s.getChance(10));
        
    }
}
