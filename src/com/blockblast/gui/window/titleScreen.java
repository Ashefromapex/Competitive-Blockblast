package com.blockblast.gui.window;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

public class titleScreen extends JFrame{

JPanel titleScreen;
JButton startSingleplayer;
JButton startMultiplayer;
  public titleScreen(){

      titleScreen = new JPanel();
      GridLayout mainPanelGridLayout = new GridLayout(0,8);
      titleScreen.setLayout(mainPanelGridLayout);
      titleScreen.setOpaque(true);
      int mainPanelBorder = 50; //Abstand vom Rand des Fensters
      int boardSize = 400; //Größe des Boards
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      titleScreen.setBounds(0,50,boardSize,boardSize);//Position und Größe des Boards im Layout
      EmptyBorder Distance = new EmptyBorder(mainPanelBorder, mainPanelBorder, mainPanelBorder, mainPanelBorder);
      LineBorder mainPanelOutline = new LineBorder(Color.black);
      JButton startSingleplayer = new JButton("Start Singleplayer");
      JButton startMultiplayer = new JButton("Start Multiplayer");
  }


}
