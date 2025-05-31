package com.blockblast.logic;

public class Blockelement extends Block
{
    Block left;
    Block right;
    Block above;
    Block below;
    public Blockelement()
    {
        left  = new BlockEnd();
        right = new BlockEnd();
        above = new BlockEnd();
        below = new BlockEnd();
    }

    private void insertl(Block b)
    {
        left = b;
    }
    private void insertr(Block b)
    {
       right = b;
    }
    private void inserta(Block b)
    {
        above = b;
    }
    private void insertb(Block b)
    {
        below = b;
    }
    public Block rotate(int r)
    {
        //recursion magic
        Block tmp;

        switch (r)
        {
            case 1:
                return this;
            case 2:
                tmp = above;
                above = left.rotate(r);
                left = below.rotate(r);
                below = right.rotate(r);
                right = tmp.rotate(r);
                return this;
            case 3:
                tmp = above;
                above = below.rotate(r);
                below = tmp.rotate(r);
                tmp = left;
                left = right.rotate(r);
                right = tmp.rotate(r);
                return this;
            case 4:
                tmp = above;
                above = right.rotate(r);
                right = below.rotate(r);
                below = left.rotate(r);
                left = tmp.rotate(r);
                return this;
            default:
                System.out.println("WRONG ROTATION!");
                return this;
        }


    }
    public Block buildBLock(int ammount, int type)
    {
        switch(ammount)
        {
            case 2:
                if(type == 1)
                {
                    //tells the user/developer to fuck themselves
                    System.out.println("Fuck you");
                }
                this.insertr(new Blockelement());
                return this;
            case 3:
                if(type == 0)
                {
                    //line
                    Blockelement tmp = new Blockelement();
                    tmp.insertr(new Blockelement());
                    this.insertr(tmp);
                    return this;
                }
                else if(type == 1)
                {
                    //dorito thing
                    this.insertr(new Blockelement());
                    this.insertb(new Blockelement());
                    return this;
                }
                else
                {
                    System.out.println("TYPE NOT SUPPORTED");
                }

            case 4:
                switch (type)
                {
                    case 0:
                        //line
                        Blockelement tmp01 = new Blockelement();
                        Blockelement tmp02 = new Blockelement();
                        tmp02.insertr(new Blockelement());
                        tmp01.insertr(tmp02);
                        this.insertr(tmp10);
                        return this;
                    case 1:
                        //BLÖCK
                        Blockelement tmp11 = new Blockelement();
                        tmp11.insertb(new Blockelement());
                        this.insertr(tmp11);
                        this.insertb(new Blockelement());
                        return this;
                    case 2:
                        //L
                        Blockelement tmp21 = new Blockelement();
                        tmp21.insertb(new Blockelement());
                        this.insertb(tmp21);
                        this.insertr(new Blockelement());
                        return this;
                    case 3:
                        //ich will nicht mehr
                        Blockelement tmp31 = new Blockelement();
                        Blockelement tmp32 = new Blockelement();
                        tmp31.insertr(new Blockelement());
                        tmp32.inserta(tmp32);
                        this.insertr(tmp32);
                        return this;
                }

        }
    }
}
