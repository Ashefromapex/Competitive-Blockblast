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
    private int [][] blockarray;



    Blockelement b1;
    Blockelement b2;
    Blockelement b3;

    public Gui()
    {
        //create Window
        /*com.blockblast.gui.window.Window w = new com.blockblast.gui.window.Window(this);
        b1 = new Blockelement();
        b2 = new Blockelement();
        b3 = new Blockelement();*/
    }




    public void pullBlock(Blockelement a, Blockelement b, Blockelement c)
    // gibt die generierten blöcker von der algorithmus zur gui
    {
          b1 = a;
          b2 = b;
          b3 = c;

         // Gui.visualizeBlock(a,b,c);
    }
    public void visualizeBlock(Blockelement b1, Blockelement b2 , Blockelement b3 )
    // visualisiert die blöcke
    {
         //Gui.transformBlock(b1, b2, b3);
    }
//    public blockarray transformBlock(Blockelement b1, Blockelement b2, Blockelement b3)
//
//    {
//
//        return 0;
//    }



}
