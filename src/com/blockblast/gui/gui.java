package com.blockblast.gui;
import javax.swing.*;
import javax.swing.JFrame;
public class gui extends JFrame {


    block block1einser;
    block block2linie2;
    block block3linie3;
    block block4linie4;
    block block5linie5;
    block block6ecke;
    block block72x2;
    block block83x3;
    block block9LBlock;
    block block10squiggles;
    block block11grosseecke;
    block block12TBlock;
    block block132x3;


    public gui()
    {
       this.getContentPane().setLayout(null);
       this.initWindow();
    }
    public void test()
    {
        System.out.println("Hello and welcome fron gui!");
    }
    public void initWindow()
    {
       //Luzia: instanzieren
        block1einser = new block();
        block2linie2 = new block();
        block3linie3 = new block();
        block4linie4 = new block();
        block5linie5 = new block();
        block6ecke = new block();
        block72x2 = new block();
        block83x3 = new block();
        block9LBlock = new block();
        block10squiggles = new block();
        block11grosseecke = new block();
        block12TBlock = new block();
        block132x3 = new block();
    }

}

class block extends gui
{
    int Blockart;
    char Rotation;
  public block()
  {

  }
  private block blockErstellen(int Blockart, char Rotation)
  {
      int[][] Blockarray= new int[5][5];
      switch (Blockart)
      {
        case 1://Block 1 der einser
        {
          Blockarray[0] = {0,0,0,0,0};
          Blockarray[1] = {0,0,0,0,0};
          Blockarray[2] = {0,0,1,0,0};
          Blockarray[3] = {0,0,0,0,0};
          Blockarray[4] = {0,0,0,0,0};
        }
        case 2: // Block 2 Zweier Linie
        {

        }
        case 3: // Block 3 Dreierlinie
        {

        }
        case 4:// Block 4 Viererlinie
        {

        }




      }
      return this;
  }

}