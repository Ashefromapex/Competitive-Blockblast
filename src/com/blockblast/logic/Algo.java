package com.blockblast.logic;

import com.blockblast.blocks.Block;
import com.blockblast.blocks.Blockelement;
import java.util.Random;

public class Algo
{
    public Blockelement b1;
    public Blockelement b2;
    public Blockelement b3;
    public int code1;
    public int code2;
    public int code3;
    private int amount;
    private int typ;
    private int rotation;
    Random rand = new Random();
    int blockinfo;   //Liam: Amount = 0; Typ = 1; Rotation = 2;
    Blockelement root;
    private final int seed;

    public Algo()
    {
        blockinfo = 0;
        root = new Blockelement();
        seed = rand.nextInt(100000);
        rand.setSeed(seed);

    }

    public int getSeed()
    {
        return seed;
    }

    public void genBlocks()
    {
        code1 = generateBlock();
        code2 = generateBlock();
        code3 = generateBlock();
        b1 = translate(code1);
        b2 = translate(code2);
        b3 = translate(code3);
    }
    public Blockelement getBlock1()
    {
        return b1;
    }
    public Blockelement getBlock2()
    {
        return b2;
    }
    public Blockelement getBlock3()
    {
        return b3;
    }

    public int generateBlock()
    {
        int probability  = rand.nextInt(70);
        if (probability <= 10)
        {
            amount = 1;
            typ = 0;
        }
        if (probability <= 20 && probability >10)
        {
            amount = 2;
            typ = 0;
        }
        if (probability <= 30 && probability >20)
        {
            amount = 3;
            typ = rand.nextInt(2);
        }
        if (probability <= 40 && probability >30)
        {
            amount = 4;
            typ = rand.nextInt(7);
        }
        if(probability <= 50 && probability >40)
        {
            amount = 5;
            typ = rand.nextInt(2);
        }
        if(probability <= 60 && probability >50)
        {
            amount = 6;
            typ = 0;
        }
        if(probability >60)
        {
            amount = 9;
            typ = 0;
        }
        rotation = rand.nextInt(4)+1;
        blockinfo = amount * 100 + typ * 10 + rotation;
        System.out.println(blockinfo);
        return blockinfo;
    }
    public Blockelement translate(int code)
    {
        //decode code
        int tmp = code % 100;
        int ammount = (code - tmp) / 100;
        int type = (tmp - tmp % 10) / 10;
        int rotation = tmp % 10;
        /*
         *  Rotation works like this:
         *  1 = default
         *  2 = 90 grad nach rechts --> nachbar links wird zu nachbar oben
         *  usw.
         */

        //build block
        root = root.buildBlock(ammount, type);

//        if(type == 0)
//        {
//            //0 Types need to be rotated differently
//            if(ammount == 1 || ammount == 9) //block dont need to be rotated at all
//            {
//                return root;
//            }
//            //ony count roation 1 and 2
//            if(rotation == 1 || rotation == 3)
//            {
//                return root;
//            }
//            else
//            {
//                return root.rotate(2);
//            }
//        }
        return root.rotate(rotation);
    }
}

