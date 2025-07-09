package com.blockblast.gui.window;
import javax.swing.*;
import javax.swing.border.LineBorder;

import com.blockblast.controller.controller;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOver extends JPanel {
    controller c;
    JButton restart;
    JButton menu;
    JLabel scoreLabel;

    private static int Bildwidth = 500;
    private static int Bildheight = 600;

    private static int wME = 175;
    private static int hME = 50;
    private static int xME = Bildwidth*3/4 - wME/2;
    private static int yME = 300;

    private static int wRE = 175;
    private static int hRE = 50;
    private static int xRE = Bildwidth/4 - wRE/2;
    private static int yRE = 300;

    public GameOver(controller c, int score) {

        this.c = c;

//        //Grundsetup
//        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//      setResizable(false); //Window bleibt genausogroß wie wir wollen
        setVisible(true);
        setLayout(null);
        setSize(Bildwidth, Bildheight);
        setBackground(Color.RED);
        setOpaque(true);


        JLabel gameOver = new JLabel("Game Over");
        gameOver.setFont(new Font("Tahoma", Font.BOLD, 30));
        gameOver.setForeground(Color.WHITE);
        gameOver.setBounds(0, 100,Bildwidth,50 );
        gameOver.setHorizontalTextPosition(JLabel.CENTER);
        gameOver.setHorizontalAlignment(SwingConstants.CENTER);


        scoreLabel = new JLabel("Score: " + score);
        scoreLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        scoreLabel.setForeground(Color.BLACK);
        scoreLabel.setBounds(0, 175,Bildwidth,50 );
        scoreLabel.setHorizontalAlignment(JLabel.CENTER);
        scoreLabel.setHorizontalTextPosition(SwingConstants.CENTER);




        //Button zum neutstarten
        restart = new JButton("Restart");
        restart.setFont(new Font("Tahoma", Font.BOLD, 20));
        restart.setForeground(Color.BLACK);
        restart.setBounds(xRE,yRE,wRE,hRE);
        restart.setVisible(true);
        restart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (c.checkSinglePlayer())
                {
                    c.startSP();
                    System.out.println("Singleplayer wird gestartet");
                }
                else
                {
                    c.startMP();
                    System.out.println("Multiplayer wird gestartet");

                }

            }
        });

        menu = new JButton("Menü");
        menu.setFont(new Font("Tahoma", Font.BOLD, 20));
        menu.setForeground(Color.BLACK);
        menu.setBounds(xME,yME,wME,hME);
        menu.setVisible(true);
        menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("zurück zum Menü");
                c.menu();

            }
        });

        JLabel test = new JLabel("Test");
        test.setFont(new Font("Tahoma", Font.BOLD, 20));
        test.setForeground(Color.BLACK);
        test.setBounds(0,0,300,300);

        add(gameOver);
        add(menu);
        add(restart);
        add(scoreLabel);
        add(test);
    }



}
