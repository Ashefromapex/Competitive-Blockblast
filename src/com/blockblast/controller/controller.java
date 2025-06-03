package com.blockblast.controller;

import com.blockblast.logic.Algo;
import com.blockblast.gui.Gui;
import com.blockblast.storage.Data;
import com.blockblast.network.Ip;

public class controller
{
    private Gui gui; //GUI object
    private Algo alg; //Logic object

    public controller()
    {

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
}
