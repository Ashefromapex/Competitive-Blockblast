package com.blockblast.controller;

import com.blockblast.logic.Algo;
import com.blockblast.gui.Gui;
import com.blockblast.storage.Data;
import com.blockblast.network.Ip;

public class controller
{
    private Gui gui; //GUI object
    private Algo alg;//Logic object
    public int [][] testfield = new int [8][8];

    public controller()
    {
        clearTestfeld();
    }
    //handles communication between the GUI and the logic
    public void start()
    {
        //startet die basic Gui → Auswählen, ob single oder multiplayer
    }
    public void startSP()
    {
        //start single player
        alg = new Algo();
        //Block generieren
        alg.genBlocks();
        //push blocks to gui
        gui = new Gui();
        gui.pullBlock(alg.getBlock1(), alg.getBlock2(), alg.getBlock3());


    }
    public void startMP()
    {
        //start multiplayer
    }

    public void printTestfield()
    {
        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j < 8; j++)
            {
                System.out.print(testfield[j][i]+ " ");
            }
            System.out.println();
        }
    }
    public void clearTestfeld()
    {
        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j < 8; j++)
            {
                testfield[j][i] = 0;
            }
        }
    }
}
