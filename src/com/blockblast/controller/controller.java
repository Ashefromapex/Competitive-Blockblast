package com.blockblast.controller;

import com.blockblast.blocks.Blockelement;
import com.blockblast.gui.window.ControllerGUI;
import com.blockblast.gui.window.Singleplayer;
import com.blockblast.logic.Board;
import com.blockblast.gui.window.TitleScreen;
import com.blockblast.gui.window.GameOver;
import com.blockblast.storage.Data;
public class controller

{
    private ControllerGUI controllerGUI;
    private TitleScreen t; //Titlebildschirm
    private GameOver g;
    private Singleplayer w;//GUI object
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
        controllerGUI = new ControllerGUI(this);
        d = new Data();
    }


    public void GameOver()
    {
        g =  new GameOver(this);
        d.pushScore(b.getScore());
        b = null; //GARBAGE COLLECTOR DO YOUR THING FUCKER
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
