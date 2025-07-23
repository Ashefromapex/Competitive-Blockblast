package com.blockblast.network;

import java.net.*;
import java.util.Enumeration;
import java.util.Objects;

import com.blockblast.controller.controller;

public class Net
{
    final int DEFAULT_PORT = 9000;
    int seed;
    int difficulty;
    public int pubattack;
    public int privattack; //always negative or 0
    private controller c;
    private CallThread ct;
    private ResponseThread rp;
    public boolean gameover;
    public int score;
    public boolean isUp;
    public final Object lock;

    public Net(controller c)
    {
        this.c = c;
        pubattack = 0;
        privattack = 0;
        lock = new Object();
    }

    public String getIp()
    {
        try
        {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            while(interfaces.hasMoreElements())
            {
                NetworkInterface netif = interfaces.nextElement();
                if(!netif.isUp() || netif.isLoopback())
                {
                    continue;
                }
                Enumeration<InetAddress> addresses = netif.getInetAddresses();
                while(addresses.hasMoreElements())
                {
                    InetAddress address = addresses.nextElement();
                    if(!address.isLoopbackAddress() && address instanceof java.net.Inet4Address)
                    {
                        return address.getHostAddress();
                    }
                }
            }
        }
        catch (SocketException e)
        {
            throw new RuntimeException(e);
        }
        System.out.println("no adresses found!");
        return "";
    }

    public void attackUpdate(int atk)
    {
        pubattack = atk;
        c.attackUpdate(atk);
        System.out.println("updated attack: " + atk);
    }

    public void blockUpdate(int atk)
    {
        //falls alle drei blöcke platziert wurden, muss thread warten, auf andere
        //muss vom controller nach Platzieren eines blockes aufgerufen werden mit der beim Platzieren entstandenden attacke auch 0
        privattack = atk;
        synchronized (lock)
        {
            lock.notifyAll();
        }
        System.out.println("notified");
    }
    public void waitForNet()
    {
        synchronized (lock)
        {
            try
            {
                lock.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void startCallThread()
    {
        seed = c.getSeed();
        difficulty = c.getDif();
        ct = new CallThread(this);
        ct.start();
    }
    public void startReponseThread(String ip, int port)
    {
        rp = new ResponseThread(this, ip, port);
        rp.start();
    }
    public void saveScore(int escore)
    {
        //saves score of enemy
        //calls controller or something idfk
        c.saveEnemyScore(escore);

    }
    public boolean startBoard()
    {
        c.startResponderGame(seed, difficulty);
        System.out.println("game started with seed" + seed +"diff: " + difficulty) ;
        return true;
    }
    public void stop()
    {
        //makews the player return to the main screen
        if(rp != null)
        {
            rp.stopResponder();
        }
        if(ct != null)
        {
            ct.stopCaller();
        }
        down();
    }
    public void Up()
    {
        isUp = true;
    }
    public void down()
    {
        isUp = false;
    }


}

