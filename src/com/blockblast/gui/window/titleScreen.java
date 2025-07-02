package com.blockblast.gui.window;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;

import com.blockblast.controller.controller;

public class titleScreen extends JFrame{

controller c;

  public titleScreen(controller c){

      this.c = c;
      setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      setResizable(false); //Window bleibt genausogroß wie wir wollen
      setVisible(true);
      setLayout(null);
      setSize(500,600);
      getContentPane().setBackground(Color.BLACK);
      //Window erstellen
      setTitle("BlockBlast");


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
              System.out.println("Singleplayer wird gestartet");
              c.startSP();
              dispose();
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
                                   c.startMP();
                                   System.out.println("To be continued");
                                   //dispose();
                                   }
      });

      //alles hinzufügen

      add(titleLabel);
      add(stS);
      add(sM);
      setLocationRelativeTo(null);

  }




}
