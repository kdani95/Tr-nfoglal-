package tronfoglalo;

import Cards.Cards;
import GUI.Tronfoglalo;
import Netcode.Server.Server;
import Statistics.Stats;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InitDatabase {
    
    public static void main(String[] args){
        Cards.init();
        Stats.init();
    }
}
