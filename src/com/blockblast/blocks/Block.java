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
}
