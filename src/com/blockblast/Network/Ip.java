package com.blockblast.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;


public class Ip
{
    final int DEFAULT_PORT = 9000;
    private Socket client;
    private PrintWriter out;
    private BufferedReader in;
    private ServerSocket server;
    boolean clientmode;

    public Ip()
    {

    }
    public String getIp()
    {
        try
        {
            return InetAddress.getLocalHost().getHostAddress();
        }
        catch (UnknownHostException e)
        {
            throw new RuntimeException(e);
        }

    }
    public void startClient(String ip, int port)
    {
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
        clientmode = true;

        String msg;
        while(true)
        {
            msg = readMsg();
            if(msg.equals("!"))
            {
                break;
            }
            System.out.println(msg);
        }

    }
    public void stopClient()
    {
        try
        {
            in.close();
            out.close();
            client.close();
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
        clientmode = false;
    }
    public void sendMsg(String msg)
    {
        out.println(msg);
    }
    public String readMsg()
    {
        String input;
        try
        {
            input = in.readLine();
            if(input != null)
            {
                return input;
            }
            else
            {
                return "ERROR";
            }
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
    public String startServer(int port)
    {
        /*
         *  Starts the server and returns the current ip address
         *  Not recommended for now --> standalone server preferred
         */
        if(clientmode)
        {
            return "ERROR";
        }
        try
        {
            server = new ServerSocket();
            client = server.accept();
            out = new PrintWriter(client.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
        return getIp() + ":" + port;

    }
    public void serverPrinter()
    {
        String msg;
        while(true)
        {
            msg = readMsg();
            if(msg.equals("!"))
            {
                break;
            }
            System.out.println(msg);
        }
    }


}

