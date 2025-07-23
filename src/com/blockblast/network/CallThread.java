package com.blockblast.network;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class CallThread extends Thread
{
    /*
     *  call thread ist cool
     *  startet einen Server und wartet bis client connected
     *  dann (wie der name verährt) called diese thread immer etwas, worauf die repsonsethread antwortet
     */
    Net net;
    ServerSocket server;
    Socket client;
    PrintWriter out;
    BufferedReader in;
    int blocks;
    public final Object lock;
    public CallThread(Net n)
    {
        net = n;
        blocks = 0;
        lock = new Object();
    }
    public void run()
    {
        //startet server
        try
        {
            server = new ServerSocket();
            server.bind(new InetSocketAddress("0.0.0.0", net.DEFAULT_PORT));
            client = server.accept();
            out = new PrintWriter(client.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }

        //communication starts here
        //sends seed

        String ans = call(craftMsg('s', net.seed));
        if (!ans.equals("y"))
        {
            System.out.println("Error sending seed");
            return;
        } //seed accepted
        ans = call(craftMsg('d', net.difficulty));
        if (!ans.equals("y"))
        {
            System.out.println("Error sending difficulty");
            return;
        }
        //starts game
        ans = call("start");
        if (!ans.equals("y"))
        {
            System.out.println("Error starting on client side");
            return;
        }
        net.Up();
        System.out.println("started" + net.seed +  " " + net.difficulty);
        while(!isInterrupted()) {
            //waits for block to be placed

            System.out.println("waiting...");
            net.waitForNet();

            //block was placed
            //checks for gameover
            System.out.println("no longer waiting!)");
            if (net.gameover) {
                call(craftMsg('l', net.score));
                net.stop();
                interrupt();
            }
            //get current attack and send it
            //subtracts attack built up by placing block to global attack level:
            net.pubattack -= net.privattack;
            net.privattack = 0;
            ans = call(craftMsg('a', net.pubattack));
            if(ans == null)
            {
                System.out.println("Client is dead :(");
                net.stop();
                return;
            }
            if (ans.charAt(0) == 'a') {
                int returned = getNum(ans);
                net.attackUpdate(-1 * returned); //pushes global attack (but reversed)
            } else if (ans.charAt(0) == 'l') {
                //responder hat verloren (imagine)
                //gets their score
                int escore = getNum(ans);
                net.saveScore(escore);
                stopCaller();
                interrupt();
            } else if (ans.equals("!")) {
                stopCaller();
                interrupt();
            } else {
                System.out.println("Invalid response... clsoing");
                stopCaller();
                interrupt();
            }
        }
            System.out.println("stopped");

    }
    public void stopCaller()
    {
        try
        {
            in.close();
            out.close();
            client.close();
            server.close();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
        interrupt();
    }

    public String call(String msg)
    {
        out.println(msg);
        String ret = null;
        try
        {
            ret = in.readLine();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
        return ret;
    }
    public String craftMsg(char c, int i)
    {
        return c + ":" + String.valueOf(i);
    }
    public int getNum(String msg)
    {
        StringBuilder ret = new StringBuilder();
        for(int i =2; i < msg.length(); i++)
        {
            ret.append(msg.charAt(i));
        }
        return Integer.parseInt(ret.toString());
    }

}
