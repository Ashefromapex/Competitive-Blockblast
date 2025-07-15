package com.blockblast.controller;

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
    boolean runningSP;
    private Data d;
    private com.blockblast.network.Net net;

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
        if(cGUI.sp == null || !cGUI.sp.gameStarted)
        {
            b = new Board();
            b.alg.setDifficulty(cGUI.titleScreen.getDifficulty());
            System.out.println("Difficulty: " + cGUI.titleScreen.getDifficulty());
            b.getBlocks();
            b.createBlockmatrix();
        }
        cGUI.singleplayer();
        runningSP = true;


    }

    public void startMP()
    {
        //start multiplayer
        b = new Board();
        b.alg.setDifficulty(cGUI.titleScreen.getDifficulty());
        System.out.println("Difficulty: " + cGUI.titleScreen.getDifficulty());
        b.getBlocks();
        b.createBlockmatrix();
        int seed = b.getSeed();
        cGUI.enemySelect();
        runningSP = false;
    }

    public void startResponderGame(int seed, int difficulty)
    {
        b.specificAlg(seed, difficulty);
    }
    public void saveEnemyScore(int score)
    {

    }


    public void GameOver()
    {
        cGUI.GameOver( b.getScore());

        d.pushScore(b.getScore());
        d.exit();
    }
    public void menu()
    {
        cGUI.titleScreen();
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
    public String[] getScoreboard()
    {
        return d.getScoreboard();
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

    //realeted to net:
    public void attackUpdate(int atk)
    {

    }
    public int getSeed()
    {
        return b.getSeed();
    }
    public int getDif()
    {
        return b.getDif();
    }

    public void startCallThread()
    {
        net.startCallThread();
    }
    public void startResponseThread()
    {
        net.startReponseThread(cGUI.enemySelect.ip.getText() ,9000);
    }

}
