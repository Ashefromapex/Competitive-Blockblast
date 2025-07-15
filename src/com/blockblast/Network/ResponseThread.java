package com.blockblast.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ResponseThread extends Thread
{
    Net net;
    final String ip;
    final int port;
    Socket client;
    PrintWriter out;
    BufferedReader in;

    public ResponseThread(Net n, String ip, int port)
    {
        net = n;
        this.ip = ip;
        this.port = port;
    }

    public void run()
    {
        //startet client und verbindet mit server
        try
        {
            client = new Socket(ip, port);
            out = new PrintWriter(client.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
        //accepts seed
        String in = receive();
        if(!(in.charAt(0) == 's'))
        {
            System.out.println("Wrong start of conversation: no seed provided");
            return;
        }
        net.seed = getNum(in);
        respond("y"); //returns succes
        //get difficulty
        in = receive();
        if(!(in.charAt(0) == 'd'))
        {
            System.out.println("Error in conversation: no difficulty provided");
            return;
        }
        net.difficulty = getNum(in);
        respond("y");
        //waits for start
        in = receive();
        if(!in.equals("start"))
        {
            System.out.println("Error: no start signal received");
            return;
        }
        net.startBoard();
        if(!net.startBoard())
        {
            System.out.println("Error: couldn't start board");
            return;
        }
        respond("y");
        while(!isInterrupted())
        {
            in = receive();
            if(in.charAt(0) == 'a')
            {
                //check for gameover
                if(net.gameover)
                {
                    respond(craftMsg('l', net.score));
                }
                //evaluate attack
                int atk = getNum(in); //public attack
                net.pubattack = atk;
                //add local privateattack
                net.pubattack -= net.privattack;
                net.privattack = 0;
                net.attackUpdate(atk);
                respond(craftMsg('a', net.pubattack));

            }
            else if(in.charAt(0) == 'l')
            {
                //caller lost (yipee)
                int escore = getNum(in);
                net.saveScore(escore);

            }
        }



    }

    public String receive()
    {
        try
        {
            return in.readLine();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
    public void respond(String msg)
    {
        out.println(msg);
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
