package com.blockblast;

/*
 *  Die Main Klasse hat zwei Aufgaben:
 *  1. Die Testklasse aufrufen → testen aller Funktionen
 *  2. Den Controller starten → startet das Spiel
*/
//import files

import com.blockblast.test.Test;
import com.blockblast.controller.controller;

public class Main
{
    public static void main(String[] args) {
        //DONT TOUCH

        //test project at startup
        boolean testatstartup = true;
        if(testatstartup)
        {
            System.out.println("Testing!");
            Test test = new Test();
            test.testAll();
        }
        controller c = new controller();
        c.start();

    }

}
