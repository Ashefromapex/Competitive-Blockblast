package com.blockblast.network;

import java.net.*;
import com.blockblast.controller.controller;

public class Net
{
    final int DEFAULT_PORT = 9000;
    int seed;
    int difficulty;
    public int pubattack;
    public int privattack;
    private controller c;
    private CallThread ct;


    public Net(controller c) {
        this.c = c;
    }

    public String getIp() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }

    }

    public void attackUpdate(int atk)
    {
        pubattack = atk;
        c.attackUpdate(atk);
    }

    public void blockUpdate(int atk)
    {
        //muss vom controller nach Platzieren eines blockes aufgerufen werden mit der beim Platzieren entstandenden attacke auch 0
        privattack = atk;
        notify();
    }

    public void startCallThread()
    {
        ct = new CallThread(this);
        ct.start();
    }
    public void saveScore(int escore)
    {
        //saves score of enemy
        //calls controller or something idfk

    }



}

