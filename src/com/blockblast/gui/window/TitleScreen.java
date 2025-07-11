package com.blockblast.gui.window;



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.blockblast.controller.*;
import java.awt.Font;
import java.io.InputStream;

public class TitleScreen extends JPanel{

 controller c;

    Font bungee;



    private static int Bildwidth = 500;
    private static int Bildheight = 600;

    private static int wMP = 175;
    private static int hMP = 50;
    private static int xMP = Bildwidth*3/4 - wMP/2;
    private static int yMP = 300;

    private static int wSP = 175;
    private static int hSP = 50;
    private static int xSP = Bildwidth/4 - wSP/2;
    private static int ySP = 300;

  public TitleScreen(controller c){

//      //das hat chat gpt gemacht
//      try {
//          InputStream is = getClass().getResourceAsStream("com/blockblast/assets/fonts/Bungee-fonts.zip");
//          bungee = Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(40f); // 40pt
//          GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
//          ge.registerFont(bungee);
//      } catch (Exception e) {
//          e.printStackTrace();
//
//          bungee = new Font("bungee", Font.PLAIN, 40); // Fallback
//      }
////bis hier

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
      titleLabel.setFont(new Font("bungee", Font.BOLD, 50));
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

      //alles hinzufügen

      add(titleLabel);
      add(sSP);
      add(sMP);

  }




}
