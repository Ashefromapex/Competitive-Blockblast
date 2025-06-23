package com.blockblast.logic;

import com.blockblast.blocks.Block;
import com.blockblast.blocks.Blockelement;
import com.blockblast.logic.Translator;
import com.blockblast.logic.BlockAlgo;

public class Algo {
    Board board;
    Translator t;
    BlockAlgo ba;
    public Blockelement b1;
    public Blockelement b2;
    public Blockelement b3;

    public Algo() {
        board = new Board();
        t = new Translator();
        ba = new BlockAlgo();
    }

    public void genBlocks() {
        b1 = t.translate(ba.generateBlock());
        b2 = t.translate(ba.generateBlock());
        b3 = t.translate(ba.generateBlock());
    }

    public Blockelement getBlock1() {
        return b1;
    }

    public Blockelement getBlock2() {
        return b2;
    }

    public Blockelement getBlock3() {
        return b3;
    }
}

