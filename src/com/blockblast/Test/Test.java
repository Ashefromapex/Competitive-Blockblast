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
        if(testController() &&
        testIp() &&
        testData() &&
        testAlgo() &&
        testGui())
        {
            System.out.println("All tests passed successfully!");
        }
        else
        {
            System.out.println("Some tests failed. Please check the output for details.");
        }
    }

    private boolean testController()
    {
        return true;
    }
    private boolean testIp()
    {
        return true;
    }
    private boolean testData()
    {
        //set highscore to 100
        Data data = new Data();
        data.pushScore(100);
        //set highscore to 200
        data.pushScore(200);
        //prints highscore
        System.out.println("Highscore: " + data.fetchHighscore());
        if(data.fetchHighscore() == 200)
        {
            data.deleteFile(data.data);
            return true;
        }
        else
        {
            System.out.println("Data test failed!\n Wrong Highscore!!");
            data.deleteFile(data.data);
            return false;
        }
    }
    private boolean testAlgo()
    {
        return true;
    }
    private boolean testGui()
    {

        return true;
    }


}
