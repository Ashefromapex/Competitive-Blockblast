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
    private int seed;
    public int difficulty;

    public Algo()
    {
        blockinfo = 0;
        seed = rand.nextInt(100000);
        rand.setSeed(seed);
        difficulty = 5; // geht von 0 (ez) bis unendlich, aber alles ab 10 ist basically unmöglich

    }

    public int getSeed()
    {
        return seed;
    }

    public void setSeed(int seed)
    {
        this.seed = seed;
        rand.setSeed(seed);
    }
    public void setDiff(int difficulty)
    {
        this.difficulty = difficulty;
    }
  
    public int genRdmNbr(int begin, int end) { return rand.nextInt(begin, end);}

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

    public void setDifficulty(int difficulty)
    {
        if(difficulty < 0)
        {
            //theoretisch geht auch kleiner null aber das wäre way too ez
            return;
        }
        this.difficulty = difficulty;
    }

    public int generateBlock()
    {
        //difficulty setting
        //2 is default
        //for lower difficulter (= easier) small blocks (1-3) are more common
        //fpr higher difficulty bigger blocks are more common
        //Bernoulli can help i figured :)
        double p = 0.5 + 0.02 * (double) (difficulty - 5); //difficulty ig
        int sum = 0;
        for(int i = 0; i < 14; i++)
        {
            if(rand.nextDouble(1) < p)
            {
                sum++;
            }
        }
        //an 4ter stelle ist block 1
        //an 10ter ist block 9
       switch (sum)
       {
           case 5:
               amount = 2;
               typ = 0;
               break;
           case 6:
               amount = 3;
               typ = rand.nextInt(2);
               break;
           case 7:
               amount = 4;
               typ = rand.nextInt(7);
               break;
           case 8:
               amount = 5;
               typ = rand.nextInt(2);
               break;
           case 9:
               amount = 6;
               typ = 0;
               break;
           default:
               if(sum < 5)
               {
                   amount = 1;
                   typ = 0;
               }
               else
               {
                   amount = 9;
                   typ = 0;
               }
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
        Blockelement block = new Blockelement().buildBlock(ammount, type);

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
        return block.rotate(rotation);
    }

    public Blockelement modifyBlock(Blockelement b, int  lvl)
    {
        //loop based on lvl
        int r = rand.nextInt(4); //rotation where block gets added
        switch (r)
        {
            //adding block
            case 0 :


        }
        //check that blockdiff from the root (2,2) doesnt exceed 3, if it does rerun
        return b;
    }

    public int getCode1()
    {
        return code1;
    }
    public int getCode2()
    {
        return code2;
    }
    public int getCode3()
    {
        return code3;
    }
}

