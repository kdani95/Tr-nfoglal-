package tronfoglalo;

import Statistics.Stat;
import Statistics.Stats;

public class NewClass {
    
    public static void main(String[] args){
        Stat s = Stats.getStat("Fog");
        System.out.println("min: " + s.getChance(s.getMin()));
        System.out.println("avg: " + s.getChance((int)Math.round(s.getAvg())));
        System.out.println("max: " + s.getChance(s.getMax()));
        
        s = Stats.getStat("Frost");
        System.out.println("min: " + s.getChance(s.getMin()));
        System.out.println("avg: " + s.getChance((int)Math.round(s.getAvg())));
        System.out.println("max: " + s.getChance(s.getMax()));
        
        s = Stats.getStat("Plague");
        System.out.println("min: " + s.getChance(s.getMin()));
        System.out.println("avg: " + s.getChance((int)Math.round(s.getAvg())));
        System.out.println("max: " + s.getChance(s.getMax()));
        
    }
}
