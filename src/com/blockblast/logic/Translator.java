package com.blockblast.logic;

import com.blockblast.blocks.Block;
import com.blockblast.blocks.Blockelement;
import com.blockblast.blocks.BlockEnd;

public class Translator
{
    Blockelement root;
    public Translator()
    {
        root = new Blockelement();
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

        if(type == 0)
        {
            //0 Types need to be rotated differently
            if(ammount == 1 || ammount == 9) //block dont need to be rotated at all
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


}
