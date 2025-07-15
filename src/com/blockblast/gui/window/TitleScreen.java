package com.blockblast.gui.window;



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.blockblast.controller.*;
import java.awt.Font;
import java.io.InputStream;
import java.util.Hashtable;

public class TitleScreen extends JPanel{

 controller c;





    private static int Bildwidth = 500;
    private static int Bildheight = 600;

    private static int wMP = 175;
    private static int hMP = 50;
    private static int xMP = Bildwidth*3/4 - wMP/2;
    private static int yMP = 250;

    private static int wSP = 175;
    private static int hSP = 50;
    private static int xSP = Bildwidth/4 - wSP/2;
    private static int ySP = 250;
    JSlider difficulty;

  public TitleScreen(controller c){


      this.c = c;

      setVisible(true);
      setLayout(null);
      setSize(Bildwidth,Bildheight);
      setBackground(new Color(16, 25, 74));


//      JLabel firma = new JLabel("such dir was tolles aus Production presents...");
//      firma.setFont(new Font("Tahoma", Font.BOLD, 10));
//      firma.setForeground(Color.GREEN);
//      firma.setBounds(10,500,300,50);
      //Titel
      JLabel titleLabel = new JLabel("Block Blast");
      titleLabel.setFont(new Font("Bold", Font.BOLD, 50));
      titleLabel.setForeground(Color.GREEN);
      titleLabel.setBounds(0,100,Bildwidth,60);
      titleLabel.setHorizontalAlignment(JLabel.CENTER);
      titleLabel.setHorizontalTextPosition(SwingConstants.CENTER);

      //Buttons zum starten

      //singleplayer
      JButton sSP = new JButton("Singleplayer");
      sSP.setFont(new Font("Tahoma", Font.BOLD, 20));
      sSP.setForeground(Color.WHITE);
      sSP.setBackground(new Color(221, 203, 6));
      sSP.setBounds(xSP,ySP,wSP,hSP);
      sSP.setHorizontalAlignment(JButton.CENTER);
      sSP.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              c.startSP();

          }
      });


      //multiplayer
      JButton sMP = new JButton("Multiplayer");
      sMP.setFont(new Font("Tahoma", Font.BOLD, 20));
      sMP.setForeground(Color.WHITE);
      sMP.setBackground(new Color(8, 106, 8));
      sMP.setBounds(xMP - 15,yMP,wMP,hMP);
      sMP.setHorizontalAlignment(SwingConstants.CENTER);
      sMP.addActionListener(new ActionListener() {
                               @Override
                               public void actionPerformed(ActionEvent e) {
                                   System.out.println("Singleplayer wird gestartet");
                                   c.startMP();
                                   System.out.println("To be continued");
                                   //dispose();
                                   }
      });

      JButton logout = new JButton("Logout");
      logout.setFont(new Font("Tahoma", Font.BOLD, 20));
      logout.setForeground(Color.WHITE);
      logout.setBounds(200,600,175,50);
      logout.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
              System.out.println("Logout wird gestartet(Luca koch mal)");
          }
      });

      JLabel difficultyLabel = new JLabel("Difficulty");
      difficultyLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
      difficultyLabel.setForeground(Color.WHITE);
      difficultyLabel.setBorder(BorderFactory.createEmptyBorder(0,Bildwidth/5,0,Bildwidth/5));
      difficultyLabel.setBounds(Bildwidth/5,Bildheight*2/3-Bildheight/10,Bildwidth*3/5,Bildheight/6);

      JLabel easy = new JLabel("Easy");
      easy.setFont(new Font("Tahoma", Font.BOLD, 20));
      easy.setForeground(Color.WHITE);
      JLabel hard = new JLabel("Hard");
      hard.setFont(new Font("Tahoma", Font.BOLD, 20));
      hard.setForeground(Color.WHITE);
      JLabel medium = new JLabel("Medium");
      medium.setFont(new Font("Tahoma", Font.BOLD, 20));
      medium.setForeground(Color.WHITE);

      Hashtable difficultyTable = new Hashtable();
      difficultyTable.put(8, hard);
      difficultyTable.put(4, medium);
      difficultyTable.put(0, easy);

      difficulty = new JSlider(JSlider.HORIZONTAL,0,8,4);
      difficulty.setLabelTable(difficultyTable);
      difficulty.setPaintLabels(true);
      difficulty.setBounds(Bildwidth/5,Bildheight*2/3,Bildwidth*3/5,Bildheight/6);
      difficulty.setForeground(Color.WHITE);
      difficulty.setBackground(new Color(16, 25, 74));

      //alles hinzufügen

      add(titleLabel);
      add(sSP);
      add(sMP);
      add(logout);
      add(difficultyLabel);
      add(difficulty);

  }

  public int getDifficulty()
  {
      System.out.println(difficulty.getValue());
      return difficulty.getValue();
  }



}
