package com.blockblast.controller;

import com.blockblast.logic.Algo;
import com.blockblast.gui.window.Window;
import com.blockblast.logic.Board;
import com.blockblast.storage.Data;
import com.blockblast.network.Ip;
import com.blockblast.gui.window.titleScreen;
import com.blockblast.gui.window.GameOver;
public class controller

{
    private titleScreen t; //Titlebildschirm
    private GameOver g;
    private Window w;//GUI object
    public Board b;//Logic object
    public int [][] testfield = new int [8][8];
    int blockcnt = 3;
    boolean runningSP;

    public controller()
    {

        clearTestfeld();
    }
    //handles communication between the GUI and the logic
    public void start()
    {
        t = new titleScreen(this);
    }
    public void startSP()
    {
        //start single player
        b = new Board();
        b.getBlocks();
        b.createBlockmatrix();
        w = new Window(this);
        runningSP = true;

    }
    public void startMP()
    {
        //start multiplayer
        int seed = b.getSeed();
        runningSP = false;
    }

    public void GameOver()
    {
        g =  new GameOver(this);
    }

    public boolean checkSinglePlayer()// überprüft ob single oder multiplayer
    {
        return runningSP;
    }

    public void startMenu()
    {
        t = new titleScreen(this);
    }
    public boolean placeBlock(int blocknr, int x, int y)
    {
        if(b.placeBlock(blocknr, y, x)) //dont ask why its switched shhhhh
        {
            blockcnt--;
            if(blockcnt == 0)
            {
                clearBlockMatrixes();
                b.getBlocks();
                b.createBlockmatrix();
                blockcnt = 3;

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

    public void clearBlockMatrixes()
    {
        for(int i = 0; i < 5; i++)
        {
            for(int j = 0; j < 5; j++)
            {
                b.bm1[i][j] = 0;
                b.bm2[i][j] = 0;
                b.bm3[i][j] = 0;
            }
        }
    }
}
