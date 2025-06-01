package com.blockblast.logic;

import com.blockblast.blocks.Block;
import com.blockblast.blocks.Blockelement;
import com.blockblast.blocks.BlockEnd;

public class Translator
{
    Block root;
    public Translator()
    {
        root = new Blockelement();
    }

    public Block translate(int code)
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

        if(type == 0)
        {
            //0 Types need to be roated differently
            if(ammount == 1 || ammount == 6 || ammount == 9) //block dont need to be rotated at all
            {
                return root;
            }
            //ony count roation 1 and 2
            if(rotation == 1 || rotation == 3)
            {
                return root;
            }
            else
            {
                return root.rotate(2);
            }
        }
        return root.rotate(rotation);
    }
    public void printBlock(Block b)
    {
        //testfield
        int[][] arr = new int[8][8];
        Blockelement root = (Blockelement) b;

        //funktioniert gerasde nur mit dem zweier block kein bock mehr zu machen und auch keinm plan tbh
        int x = 4;
        int y = 4;
        if(!root.isEnd())
        {
            arr[x][y] = 1;
            if(!root.left.isEnd())
            {
                arr[x - 1][y] = 1;
            }
            if(!root.right.isEnd())
            {
                arr[x + 1][y] = 1;
            }
            if(!root.below.isEnd())
            {
                arr[x][y - 1] = 1;
            }
            if(!root.above.isEnd())
            {
                arr[x][y + 1] = 1;
            }
        }
        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j < 8; j++)
            {
                System.out.print(arr[j][i]+ " ");
            }
            System.out.println();
        }
    }

}
