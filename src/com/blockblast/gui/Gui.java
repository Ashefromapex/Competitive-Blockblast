package com.blockblast.gui;
import javax.swing.JFrame;
public class Gui extends JFrame {


    BlockGui block1einser;
    BlockGui block2linie2;
    BlockGui block3linie3;
    BlockGui block4linie4;
    BlockGui block5linie5;
    BlockGui block6ecke;
    BlockGui block72x2;
    BlockGui block83x3;
    BlockGui block9LBlock;
    BlockGui block10squiggles;
    BlockGui block11grosseecke;
    BlockGui block12TBlock;
    BlockGui block132x3;


    public Gui()
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
        block1einser = new BlockGui();
        block2linie2 = new BlockGui();
        block3linie3 = new BlockGui();
        block4linie4 = new BlockGui();
        block5linie5 = new BlockGui();
        block6ecke = new BlockGui();
        block72x2 = new BlockGui();
        block83x3 = new BlockGui();
        block9LBlock = new BlockGui();
        block10squiggles = new BlockGui();
        block11grosseecke = new BlockGui();
        block12TBlock = new BlockGui();
        block132x3 = new BlockGui();
    }

}

class BlockGui extends Gui
{
    int Blockart;
    char Rotation;
  public BlockGui()
  {

  }
  private BlockGui blockErstellen(int Blockart, char Rotation)
  {
      int[][] Blockarray= new int[5][5];
      switch (Blockart)
      {
        case 1://Block 1 der einser
        {
          /*Blockarray[0] = {0,0,0,0,0};
          Blockarray[1] = {0,0,0,0,0};
          Blockarray[2] = {0,0,1,0,0};
          Blockarray[3] = {0,0,0,0,0};
          Blockarray[4] = {0,0,0,0,0};*/
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