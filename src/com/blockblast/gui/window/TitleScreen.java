package com.blockblast.gui.window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TitleScreen extends JPanel{

ControllerGUI c;

  public TitleScreen(ControllerGUI c){

      this.c = c;

      setVisible(true);
      setLayout(null);
      setSize(500,600);
      setBackground(Color.BLACK);


//      JLabel firma = new JLabel("such dir was tolles aus Production presents...");
//      firma.setFont(new Font("Tahoma", Font.BOLD, 10));
//      firma.setForeground(Color.GREEN);
//      firma.setBounds(10,500,300,50);
      //Titel
      JLabel titleLabel = new JLabel("BlockBlast");
      titleLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
      titleLabel.setForeground(Color.GREEN);
      titleLabel.setBounds(162,100,300,50);

      //Buttons zum starten

      //singleplayer
      JButton stS = new JButton("Singleplayer");
      stS.setFont(new Font("Tahoma", Font.BOLD, 20));
      stS.setForeground(Color.BLUE);
      stS.setBounds(50,300,175,50);
      stS.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              c.singleplayer();
          }
      });

      //multiplayer
      JButton sM = new JButton("Multiplayer");
      sM.setFont(new Font("Tahoma", Font.BOLD, 20));
      sM.setForeground(Color.BLUE);
      sM.setBounds(250,300,175,50);
      sM.addActionListener(new ActionListener() {
                               @Override
                               public void actionPerformed(ActionEvent e) {
                                   System.out.println("Singleplayer wird gestartet");
                                   c.multiplayer();
                                   System.out.println("To be continued");
                                   //dispose();
                                   }
      });

      //alles hinzufügen

      add(titleLabel);
      add(stS);
      add(sM);

  }




}
