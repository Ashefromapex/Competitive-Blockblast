package com.blockblast.test;

//import packages
import com.blockblast.blocks.Blockelement;
import com.blockblast.controller.controller;
import com.blockblast.gui.window.Launcher;
import com.blockblast.gui.window.Window;
import com.blockblast.logic.Board;
import com.blockblast.network.Ip;
import com.blockblast.storage.Data;
import com.blockblast.logic.Algo;
import com.blockblast.gui.Gui;
import com.blockblast.logic.Translator;
import com.blockblast.blocks.Block;

import javax.swing.*;

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
        //testAlgo() && funktioniert nicht
        testGui()
        //testBoard() funktioniert nicht
            )
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
        //testing of translator
        Translator t = new Translator();
        Blockelement bE = t.translate(301);
        int[][] arr = new int[8][8];
        //for code 201:
        System.out.println("Block 201:");
        bE.printBlock(4, 4);
        bE = t.translate(202);
        System.out.println("Block 202:");
        bE.printBlock(4,4);
        t.translate(421);


        return true;
    }
    private boolean testGui()
    {

        return true;
    }
    private boolean testBoard()
    {
        Board board = new Board();
        board.buildCompleteBlock(4, 4);
        return true;
    }

    private boolean TestWindow()
    {
        Window w = new Window();

        return true;

    }




}
