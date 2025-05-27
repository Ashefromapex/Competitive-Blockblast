package com.blockblast.Test;

//import packages
import com.blockblast.controller.controller;
import com.blockblast.network.Ip;
import com.blockblast.storage.Data;
import com.blockblast.logic.Algo;
import com.blockblast.gui.Gui;

public class Test
{
    public static void Test()
    {

    }
    public void testAll()
    {
       //einzelne testmethoden werden aufgerufen
        testController();
        testIpconf();
        testData();
        testAlgo();
        testGui();
    }

    private void testController()
    {

    }
    private void testIpconf()
    {

    }
    private void testData()
    {
        //set highscore to 100
        Data data = new Data();
        data.pushScore(100);
        //set highscore to 200
        data.pushScore(200);
        //prints highscore
        System.out.println("Highscore: " + data.fetchHighscore());
    }
    private void testAlgo()
    {

    }
    private void testGui()
    {

    }


}
