package com.blockblast.gui;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.Graphics;
public class Gui extends JPanel {


    private JPanel[] panel;
    private  BlockGui block;

    public Gui() {

    }
    // die methode sollte eigentlich den block visualisieren
    public void blockVisualisieren(int Blockart, char Rotation, Graphics g)
    {
        int[][] array = block.blockErstellen(Blockart,Rotation);
        for( int i = 0; i < array.length; i++ ) {
            for( int j = 0; j < array[0].length; j++ ) {
                if( array[i][j] == 0 ) g.setColor( Color.red );
                else g.setColor( Color.black );
                g.drawRect( 10*i, 10*j, 10, 10 );
            }
        }



    }

}

class BlockGui extends Gui
{
    int Blockart;
    char Rotation;
  public BlockGui()
  {

  }
  public int [][] blockErstellen(int Blockart, char Rotation) // erstellen von jedem block 1-10 in einem Array
  {
      int[][] Blockarray= new int[5][5];
      switch (Blockart)
      {
        case 1://Block 1 der einser
        {
          Blockarray[0] = new int[]{0, 0, 0, 0, 0};
          Blockarray[1] = new int[]{0, 0 ,0 ,0 ,0};
          Blockarray[2] = new int[]{0, 0, 1, 0, 0};
          Blockarray[3] = new int[]{0, 0, 0, 0, 0};
          Blockarray[4] = new int[]{0, 0, 0, 0, 0};

          return Blockarray;
        }
        case 2: // Block 2 Zweier Linie
        {
            Blockarray[0] = new int[]{0, 0, 0, 0, 0};
            Blockarray[1] = new int[]{0, 0 ,0 ,0 ,0};
            Blockarray[2] = new int[]{0, 1, 1, 0, 0};
            Blockarray[3] = new int[]{0, 0, 0, 0, 0};
            Blockarray[4] = new int[]{0, 0, 0, 0, 0};

            return Blockarray;
        }
        case 3: // Block 3 Dreierlinie
        {
            Blockarray[0] = new int[]{0, 0, 0, 0, 0};
            Blockarray[1] = new int[]{0, 0 ,0 ,0 ,0};
            Blockarray[2] = new int[]{1, 1, 1, 0, 0};
            Blockarray[3] = new int[]{0, 0, 0, 0, 0};
            Blockarray[4] = new int[]{0, 0, 0, 0, 0};

            return Blockarray;
        }
        case 4:// Block 4 Viererlinie
        {
            Blockarray[0] = new int[]{0, 0, 0, 0, 0};
            Blockarray[1] = new int[]{0, 0 ,0 ,0 ,0};
            Blockarray[2] = new int[]{1, 1, 1, 1, 0};
            Blockarray[3] = new int[]{0, 0, 0, 0, 0};
            Blockarray[4] = new int[]{0, 0, 0, 0, 0};

            return Blockarray;
        }




      }
      return Blockarray;
  }

}