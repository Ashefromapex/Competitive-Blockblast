package com.blockblast.logic;

public abstract class Block
{
    private abstract void insertl(Block b);
    private abstract void insertr(Block b);
    private abstract void inserta(Block b);
    private abstract void insertb(Block b);
    public abstract Block rotate(int r);
}
