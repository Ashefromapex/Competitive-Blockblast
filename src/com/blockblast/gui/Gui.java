package com.blockblast.gui;
import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.blockblast.blocks.BlockEnd;
import com.blockblast.blocks.Blockelement;
import com.blockblast.gui.window.Window;
public class Gui extends JFrame implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent g)
    {}

    private JPanel[] panel;
    private  BlockGui block;



    Blockelement b1;
    Blockelement b2;
    Blockelement b3;

    public Gui()
    {
        //create Window
        com.blockblast.gui.window.Window w = new com.blockblast.gui.window.Window(this);
        b1 = new Blockelement();
        b2 = new Blockelement();
        b3 = new Blockelement();
    }


    public void pullBlock(Blockelement a, Blockelement b, Blockelement c)
    {
          b1 = a;
          b2 = b;
          b3 = c;
    }
    public void visualizeBlock()
    {

    }

}
// Klasse ist nur zum generieren de Blöcke da
class BlockGui extends Gui
{
    int Blockart;
    char Rotation;
  public BlockGui()
  {

  }

}