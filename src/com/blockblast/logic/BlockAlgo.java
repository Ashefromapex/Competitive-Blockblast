package com.blockblast.logic;
import java.util.Random;

public class BlockAlgo
{
    private int amount;
    private int typ;
    private int rotation;
    Random rand = new Random();
    int blockinfo;   //Liam: Amount = 0; Typ = 1; Rotation = 2;



    public BlockAlgo()
    {
        blockinfo = 0;
        generateBlock();

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
            typ = rand.nextInt(5);
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
        return blockinfo;
    }
}
