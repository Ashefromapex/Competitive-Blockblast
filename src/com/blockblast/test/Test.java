package com.blockblast.test;

//import packages
import com.blockblast.network.Ip;

public class Test
{

    public static void test()
    {

    }
    public void TestAll()
    {
        Ip i =  new Ip();
        i.startClient(9000);
        i.sendMsg("haiiiii");
        i.sendMsg("haiiiii");
        i.sendMsg("haiiiii");
        i.sendMsg("haiiiii");
        i.sendMsg("haiiiii");
    }
}
