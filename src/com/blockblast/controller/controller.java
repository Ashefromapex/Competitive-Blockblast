package com.blockblast.controller;

import com.blockblast.blocks.Blockelement;
import com.blockblast.gui.window.*;
import com.blockblast.logic.Board;
import com.blockblast.storage.Data;
public class controller

{
    public ControllerGUI cGUI;
    private TitleScreen t; //Titlebildschirm
    private GameOver g;
    public Singleplayer sp;//GUI object
    private Multiplayer mp;
    public Board b;//Logic object
    public int [][] testfield = new int [8][8];
    int blockcnt = 3;
    boolean runningSP;
    private Data d;

    public controller()
    {

    }
    //handles communication between the GUI and the logic
    public void start()
    {
        cGUI = new ControllerGUI(this);
        d = new Data();
    }



    public boolean checkSinglePlayer()// überprüft ob single oder multiplayer
    {
        return runningSP;
    }

    public void startSP()
    {
        //start single player
        b = new Board();
        b.getBlocks();
        b.createBlockmatrix();
        runningSP = true;


    }

    public void startMP()
    {
        //start multiplayer
        b = new Board();
        b.getBlocks();
        b.createBlockmatrix();
        int seed = b.getSeed();
        runningSP = false;
    }


    public void GameOver()
    {
        cGUI.GameOver( b.getScore());
        d.pushScore(b.getScore());
        d.exit();
    }

    public boolean placeBlock(int blocknr, int x, int y)
    {
        if(b.placeBlock(blocknr, y, x)) //dont ask why its switched shhhhh
        {
            if(b.gameOver)
            {
                GameOver();
            }
            return true;
        }
        else
        {
            return false;
        }
    }
    public void login(String user)
    {
        d.loginUser(user);
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


}
