package com.blockblast.blocks;

public abstract class Block
{


    protected abstract void insertl(Block b);
    protected abstract void insertr(Block b);
    protected abstract void inserta(Block b);
    protected abstract void insertb(Block b);
    public abstract Block rotate(int r);
    public abstract Block buildBlock(int ammount, int type);
    public abstract boolean isEnd();
    public void printBlock(Block b, int x, int y)
    {}

    protected void printNeighbours() {
    }

    public  int checkPlacement(int test, int x, int i)
    {
      return 99;
    }

    public void changeBlock(int x) {}

}
