package com.blockblast.gui;
import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.blockblast.blocks.BlockEnd;
import com.blockblast.blocks.Blockelement;
import com.blockblast.gui.window.Window;
import com.blockblast.logic.Board;
public class Gui extends JFrame implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent g)
    {}

    private JPanel[] panel;




    Blockelement b1;
    Blockelement b2;
    Blockelement b3;

    int [][] testblock = {{0,0,0,0,0,},
                          {0,0,0,0,0,},
                          {0,0,1,0,0,},
                          {0,0,0,0,0,},
                          {0,0,0,0,0,}};

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
    public void visualizeBlock(int[][] testblock)// erstmal mit testblock weil kp wo der übergabe parameter herkommt
    // visualisiert die blöcke
    {
        panel = new JPanel[];
        panel.setLayout(new GridLayout(5,5));
        //JFrame box = new JFrame();

        for (int i=0; i< 5; i++){

            for (int j=0; j<5; j++){

                if (testblock[i][j] == 1){
                    panel.[i][j].setBackground(Color.red);
                }
                else{
                    panel[i][j].setBackground(Color.black);
                }
                // JPanel dem Frame hinzufuegen
                box.wait(panel[i][j]);
            }
        }
    }




}
