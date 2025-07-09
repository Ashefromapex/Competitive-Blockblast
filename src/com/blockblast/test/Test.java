package com.blockblast.test;

//import packages
import com.blockblast.controller.controller;
import com.blockblast.logic.Board;
import com.blockblast.storage.Data;
import com.blockblast.logic.Algo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test
{
    ActionListener listener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    };
    public static void Test()
    {

    }
    public void testAll()
    {
       //einzelne testmethoden werden aufgerufen
        if(testController() &&
        testIp() &&
        testData() &&
        testGui() &&
        testBoard() &&
        testWindow(listener))
        {
            System.out.println("All tests passed successfully!");
        }
        else
        {
            System.out.println("Some tests failed. Please check the output for details.");
        }
    }

    private boolean testController()
    {
        controller c = new controller();
//        c.start();
        return true;
    }
    private boolean testIp()
    {
        return true;
    }
    private boolean testData()
    {
        Data data = new Data();
        String[] tmp = data.getScoreboard();
        for(String s : tmp)
        {
            System.out.println(s);
        }
        return true;
    }
    private boolean testAlgo()
    {

        Algo a = new Algo();
        Board b = new Board();
        a.translate(431);
        a.genBlocks();
        b.getBlocks();
        b.printi();
        //b.checkPlacement(2,7,0);
        /*if(b.checkPlacement(1,3,4))
        {
            System.out.println("Algo test passed successfully!");
        }
        else
        {
            System.out.println("Some tests failed. Please check the output for details.");
        }*/
        b.printi();
        b.checkAll();
        b.printi();

        b.createBlockmatrix();
        b.printArray(b.bm1);
        System.out.println();
        b.printArray(b.bm2);
        System.out.println();
        b.printArray(b.bm3);
        return true;
    }
    private boolean testGui()
    {

        return true;
    }
    private boolean testBoard()
    {
        Board board = new Board();
        return true;
    }


    private boolean testWindow(ActionListener listener)
    {

//        new Window(new controller());

        return true;

    }

    //Methode testet alle Blöcke, es sollte funktionieren afaik, aber habs mal drin gelassen, falls wer nochmal Bock hat drüber zu schauen -Lami
    /*private boolean testAllBlocks()//(pain)
    {
        System.out.println();
        Translator t = new Translator();
        System.out.println("Block: 101");
        t.translate(101);
        System.out.println("Block: 102");
        t.translate(102);
        System.out.println("Block: 103");
        t.translate(103);
        System.out.println("Block: 104");
        t.translate(104);
        System.out.println("Block: 201");
        t.translate(201);
        System.out.println("Block: 202");
        t.translate(202);
        System.out.println("Block: 203");
        t.translate(203);
        System.out.println("Block: 204");
        t.translate(204);
        System.out.println("Block: 301");
        t.translate(301);
        System.out.println("Block: 302");
        t.translate(302);
        System.out.println("Block: 303");
        t.translate(303);
        System.out.println("Block: 304");
        t.translate(304);
        System.out.println("Block: 311");
        t.translate(311);
        System.out.println("Block: 312");
        t.translate(312);
        System.out.println("Block: 313");
        t.translate(313);
        System.out.println("Block: 314");
        t.translate(314);
        System.out.println("Block: 401");
        t.translate(401);
        System.out.println("Block: 402");
        t.translate(402);
        System.out.println("Block: 403");
        t.translate(403);
        System.out.println("Block: 404");
        t.translate(404);
        System.out.println("Block: 411");
        t.translate(411);
        System.out.println("Block: 412");
        t.translate(412);
        System.out.println("Block: 413");
        t.translate(413);
        System.out.println("Block: 414");
        t.translate(414);
        System.out.println("Block: 421");
        t.translate(421);
        System.out.println("Block: 422");
        t.translate(422);
        System.out.println("Block: 423");
        t.translate(423);
        System.out.println("Block: 424");
        t.translate(424);
        System.out.println("Block: 431");
        t.translate(431);
        System.out.println("Block: 432");
        t.translate(432);
        System.out.println("Block: 433");
        t.translate(433);
        System.out.println("Block: 434");
        t.translate(434);
        System.out.println("Block: 441");
        t.translate(441);
        System.out.println("Block: 442");
        t.translate(442);
        System.out.println("Block: 443");
        t.translate(443);
        System.out.println("Block: 444");
        t.translate(444);
        System.out.println("Block: 451");
        t.translate(451);
        System.out.println("Block: 452");
        t.translate(452);
        System.out.println("Block: 453");
        t.translate(453);
        System.out.println("Block: 454");
        t.translate(454);
        System.out.println("Block: 461");
        t.translate(461);
        System.out.println("Block: 462");
        t.translate(462);
        System.out.println("Block: 463");
        t.translate(463);
        System.out.println("Block: 464");
        t.translate(464);
        System.out.println("Block: 501");
        t.translate(501);
        System.out.println("Block: 502");
        t.translate(502);
        System.out.println("Block: 503");
        t.translate(503);
        System.out.println("Block: 504");
        t.translate(504);
        System.out.println("Block: 511");
        t.translate(511);
        System.out.println("Block: 512");
        t.translate(512);
        System.out.println("Block: 513");
        t.translate(513);
        System.out.println("Block: 514");
        t.translate(514);
        System.out.println("Block: 601");
        t.translate(601);
        System.out.println("Block: 602");
        t.translate(602);
        System.out.println("Block: 603");
        t.translate(603);
        System.out.println("Block: 604");
        t.translate(604);
        System.out.println("Block: 901");
        t.translate(901);
        System.out.println("Block: 902");
        t.translate(902);
        System.out.println("Block: 903");
        t.translate(903);
        System.out.println("Block: 904");
        t.translate(904);

        return true;
    }*/


}
