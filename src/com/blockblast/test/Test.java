package com.blockblast.test;

//import packages
import com.blockblast.Network.Ip;

public class Test
{

    public static void test()
    {

    }
    public void testAll()
    {
        Ip i =  new Ip();
        System.out.println(i.startServer(9000));
        i.getIp();
        i.serverPrinter();
    }
}
