package com.blockblast.controller;

import com.blockblast.logic.Algo;
import com.blockblast.gui.window.Window;
import com.blockblast.logic.Board;
import com.blockblast.storage.Data;
import com.blockblast.network.Ip;

public class controller
{
    private Window w; //GUI object
    private Board b;//Logic object
    public int [][] testfield = new int [8][8];

    public controller()
    {
        w = new Window(this);
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
        b.getBlocks();
        b.createBlockmatrix();
        w.pushBM(b.bm1, b.bm2, b.bm3);

    }
    public void startMP()
    {
        //start multiplayer
    }

    public void placeBlock(int blocknr, int x, int y)
    {
        b.placeBlock(blocknr, x, y);
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
