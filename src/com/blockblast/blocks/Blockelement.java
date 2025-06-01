package com.blockblast.blocks;

public class Blockelement extends Block
{
    public Block left;
    public Block right;
    public Block above;
    public Block below;
    public Blockelement()
    {
        left  = new BlockEnd();
        right = new BlockEnd();
        above = new BlockEnd();
        below = new BlockEnd();
    }

    protected void insertl(Block b)
    {
        left = b;
    }
    protected void insertr(Block b)
    {
       right = b;
    }
    protected void inserta(Block b)
    {
        above = b;
    }
    protected void insertb(Block b)
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
    public Block buildBlock(int ammount, int type)
    {
        switch(ammount)
        {
            case 1:
                if(type == 0)
                {
                    return this;
                }
                else
                {
                    System.out.println("WRONG TYPE");
                    break;
                }
            case 2:
                if(type == 1)
                {
                    //tells the user/developer to fuck themselves
                    System.out.println("Fuck you");
                }
                else if(type == 0)
                {
                    this.insertr(new Blockelement());
                    return this;
                }
                else
                {
                    System.out.println("WRONG TYPE ");
                    break;
                }

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
                    break;
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
                        this.insertr(tmp01);
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
                    case 4:
                        //fortnite
                        this.inserta(new Blockelement());
                        this.insertr(new Blockelement());
                        this.insertb(new Blockelement());
                        return this;
                    default:
                        System.out.println("NO VALID TYPE");

                }

            case 5:
                if(type == 0)
                {
                    //liiiiine
                    Blockelement tmp1 = new Blockelement();
                    Blockelement tmp2 = new Blockelement();
                    Blockelement tmp3 = new Blockelement();
                    tmp1.insertr(new Blockelement());
                    tmp2.insertr(tmp1);
                    tmp3.insertr(tmp2);
                    this.insertr(tmp3);
                    return this;
                }
                else if (type == 1)
                {
                    //weird L
                    Blockelement tmp1 = new Blockelement();
                    Blockelement tmp2 = new Blockelement();
                    Blockelement tmp3 = new Blockelement();
                    tmp1.insertb(new Blockelement());
                    tmp2.insertb(tmp1);
                    tmp3.insertr(tmp2);
                    this.insertr(tmp3);
                    return this;
                }
                else
                {
                    System.out.println("Wrong type");
                    break;
                }

            case 6:
                if(type == 0)
                {
                    //BLOCK
                    Blockelement tmp1 = new Blockelement();
                    Blockelement tmp2 = new Blockelement();
                    Blockelement tmp3 = new Blockelement();
                    tmp1.insertr(new Blockelement());
                    this.insertr(tmp1);
                    tmp2.insertr(new Blockelement());
                    tmp3.insertr(tmp2);
                    this.insertb(tmp3);
                    return this;
                }
                else
                {
                    System.out.println("WRONG TYPE");
                    break;
                }

            case 9:
                if(type == 0)
                {
                    //BLOOOOCK
                    Blockelement tmp1 = new Blockelement();
                    Blockelement tmp2 = new Blockelement();
                    Blockelement tmp3 = new Blockelement();
                    Blockelement tmp4 = new Blockelement();
                    Blockelement tmp5 = new Blockelement();

                    //first line
                    tmp1.insertr(new Blockelement());
                    tmp2.insertr(tmp1);
                    //second line
                    tmp3.insertr(new Blockelement());
                    tmp4.insertr(tmp3);
                    tmp4.insertb(tmp2);
                    //final line
                    tmp5.insertr(new Blockelement());
                    this.insertr(tmp5);
                    this.insertb(tmp4);
                    return this;
                }
                else
                {
                    System.out.println("WRONG TYPE");
                    break;
                }
            default:
                System.out.println("wrong ammount");
                return this;
        }
        return this;
    }
    public boolean isEnd()
    {
        return false;
    }
}
