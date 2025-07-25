package com.blockblast.blocks;

import com.blockblast.controller.controller;

public class Blockelement extends Block {
    public Block left;
    public Block right;
    public Block above;
    public Block below;

    public Blockelement() {
        left = new BlockEnd();
        right = new BlockEnd();
        above = new BlockEnd();
        below = new BlockEnd();
    }

    protected void insertl(Block b) {
        left = b;
    }

    protected void insertr(Block b) {
        right = b;
    }

    protected void inserta(Block b) {
        above = b;
    }

    protected void insertb(Block b) {
        below = b;
    }

    public Blockelement rotate(int r) {
        //recursion magic
        Block tmp;

        switch (r) {
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

    public Blockelement buildBlock(int ammount, int type) {
        Blockelement b = new Blockelement();
        switch (ammount) {
            case 1:
                if (type == 0) {
                    return b;
                } else {
                    System.out.println("WRONG TYPE");
                    break;
                }
            case 2:
                if (type == 1) {
                    //tells the user/developer to fuck themselves
                    System.out.println("Fuck you");
                } else if (type == 0) {
                    b.insertr(new Blockelement());
                    return b;
                } else {
                    System.out.println("WRONG TYPE ");
                    break;
                }

            case 3:
                if (type == 0) {
                    //line
                    Blockelement tmp = new Blockelement();
                    tmp.insertr(new Blockelement());
                    b.insertr(tmp);
                    return b;
                } else if (type == 1) {
                    //dorito thing
                    b.insertr(new Blockelement());
                    b.insertb(new Blockelement());
                    return b;
                } else {
                    System.out.println("TYPE NOT SUPPORTED");
                    break;
                }

            case 4:
                switch (type) {
                    case 0:
                        //line
                        Blockelement tmp01 = new Blockelement();
                        Blockelement tmp02 = new Blockelement();
                        tmp02.insertr(new Blockelement());
                        tmp01.insertr(tmp02);
                        b.insertr(tmp01);
                        return b;
                    case 1:
                        //BLÖCK
                        Blockelement tmp11 = new Blockelement();
                        tmp11.insertb(new Blockelement());
                        b.insertr(tmp11);
                        b.insertb(new Blockelement());
                        return b;
                    case 2:
                        //L
                        Blockelement tmp21 = new Blockelement();
                        tmp21.insertb(new Blockelement());
                        b.insertb(tmp21);
                        b.insertr(new Blockelement());
                        return b;
                    case 3:
                        //the forgotten one :(
                        Blockelement tmp31 = new Blockelement();
                        tmp31.insertb(new Blockelement());
                        b.insertb(tmp31);
                        b.insertl(new Blockelement());
                        return b;
                    case 4:
                        Blockelement tmp41 = new Blockelement();
                        Blockelement tmp42 = new Blockelement();
                        tmp41.insertb(tmp42);
                        tmp42.insertr(new Blockelement());
                        b.insertr(tmp41);
                        return b;
                    case 5:
                        //ich will nicht mehr
                        Blockelement tmp51 = new Blockelement();
                        Blockelement tmp52 = new Blockelement();
                        tmp51.insertr(new Blockelement());
                        tmp52.inserta(tmp51);
                        b.insertr(tmp52);
                        return b;
                    case 6:
                        //fortnite
                        b.inserta(new Blockelement());
                        b.insertr(new Blockelement());
                        b.insertb(new Blockelement());
                        return b;
                    default:
                        System.out.println("NO VALID TYPE");

                }

            case 5:
                if (type == 0) {
                    //liiiiine
                    Blockelement tmp1 = new Blockelement();
                    Blockelement tmp2 = new Blockelement();
                    Blockelement tmp3 = new Blockelement();
                    tmp1.insertr(new Blockelement());
                    tmp2.insertr(tmp1);
                    tmp3.insertr(tmp2);
                    b.insertr(tmp3);
                    return b;
                } else if (type == 1) {
                    //weird L
                    Blockelement tmp1 = new Blockelement();
                    Blockelement tmp2 = new Blockelement();
                    Blockelement tmp3 = new Blockelement();
                    tmp1.insertb(new Blockelement());
                    tmp2.insertb(tmp1);
                    tmp3.insertr(tmp2);
                    b.insertr(tmp3);
                    return b;
                } else {
                    System.out.println("Wrong type");
                    break;
                }

            case 6:
                if (type == 0) {
                    //BLOCK
                    Blockelement tmp1 = new Blockelement();
                    Blockelement tmp2 = new Blockelement();
                    Blockelement tmp3 = new Blockelement();
                    tmp1.insertr(new Blockelement());
                    b.insertr(tmp1);
                    tmp2.insertr(new Blockelement());
                    tmp3.insertr(tmp2);
                    b.insertb(tmp3);
                    return b;
                } else {
                    System.out.println("WRONG TYPE");
                    break;
                }

            case 9:
                if (type == 0) {
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
                    b.insertr(tmp5);
                    b.insertb(tmp4);
                    return b;
                } else {
                    System.out.println("WRONG TYPE");
                    break;
                }
            default:
                System.out.println("wrong ammount");
                return b;
        }
        return b;
    }

    public boolean isEnd() {
        return false;
    }

    //@Override
    public int checkPlacement(int y, int x) {
        return 1;
    }

    public int placeBlock(int y, int x) {
        return 1;
    }

    //placeBlock() etc; oder so

    public void changeBlock(int direc) {
        switch (direc) {
            case 0:

                if (!above.isEnd()) {
                    above.changeBlock(direc);
                } else {
                    above = new Blockelement();
                }
                break;


            case 1:
                if (!left.isEnd()) {
                    left.changeBlock(direc);
                } else {
                    left = new Blockelement();
                }
                break;

            case 2:
                if (!right.isEnd()) {
                    right.changeBlock(direc);
                } else {
                    right = new Blockelement();
                }
                break;

            case 3:
                if (!below.isEnd()) {
                    below.changeBlock(direc);
                } else {
                    below = new Blockelement();
                }
        }

    }
}


