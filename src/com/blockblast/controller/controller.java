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
    int blockcnt = 3;

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
        b = new Board();
        b.getBlocks();
        b.createBlockmatrix();
        w = new Window(this);

    }
    public void startMP()
    {
        //start multiplayer
        int seed = b.getSeed();
    }

    public boolean placeBlock(int blocknr, int x, int y)
    {
        if(b.placeBlock(blocknr, x, y))
        {
            blockcnt--;
            if(blockcnt == 0)
            {
                b.getBlocks();
                b.createBlockmatrix();
            }
            return true;
        }
        else
        {
            return false;
        }
    }
    public int[][] getBm1()
    {
        return b.bm1;
    }
    public int[][] getBm2()
    {
        return b.bm2;
    }
    public int[][] getBm3()
    {
        return b.bm3;
    }
    public int[] getRoot(int blocknr)
    {
        blocknr--;
        return b.optimalPlacements[blocknr];
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
