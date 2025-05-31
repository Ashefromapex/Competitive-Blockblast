package com.blockblast.logic;

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

        switch(ammount)
        {
            case 1:
                return root;
                break;
            case 2:

                //rotation 1 & 3 and 2 & 4 are the same
                if(rotation == 1 || rotation == 3)
                {
                    return root.rotate(1);
                }
                else
                {
                    return root.rotate(2);
                }
            case 3:
                if(rotation == 1 || rotation == 3)
                {
                    return root.rotate(1);
                }
                else
                {
                    return root.rotate(2);
                }
        }
    }

}
