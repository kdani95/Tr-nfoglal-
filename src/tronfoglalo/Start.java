package tronfoglalo;

import GUI.Tronfoglalo;

public class Start {

    public static void main(String[] args) {

        Thread GUI = new Thread(new Tronfoglalo("DANI") );
        GUI.start();

    }
    
}
