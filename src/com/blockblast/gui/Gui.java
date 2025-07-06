package com.blockblast.gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.blockblast.blocks.Blockelement;

public class Gui implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent g)
    {}






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
//    public void visualizeBlock(int[][] testblock)// erstmal mit testblock weil kp wo der übergabe parameter herkommt
//    // visualisiert die blöcke
//    {
//        JPanel panel = new JPanel();
//        panel.setLayout(new GridLayout(5,5));
//        for(int g = 0; g < 5; g++){
//            for(int h = 0; h < 5; h++){
//                panel[g][h] = new JButton();
//                this.add(panel[g][h]);
//
//        for (int i=0; i< 5; i++){
//
//            for (int j=0; j<5; j++){
//
//                if (testblock[i][j] == 1){
//                    panel.[i][j].setBackground(Color.red);
//                }
//                else{
//                    panel[i][j].setBackground(Color.black);
//                }
//
//            }
//        }





}
