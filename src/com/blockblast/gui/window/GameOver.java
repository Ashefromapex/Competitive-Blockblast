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
    JLabel scoreboard;
    private String scores;

    private static int Bildwidth = 500;
    private static int Bildheight = 600;

    private static int wME = 175;
    private static int hME = 50;
    private static int xME = Bildwidth * 3 / 4 - wME / 2;
    private static int yME = 250;

    private static int wRE = 175;
    private static int hRE = 50;
    private static int xRE = Bildwidth / 4 - wRE / 2;
    private static int yRE = 250;

    public GameOver(controller c, int score) {

        this.c = c;


        setVisible(true);
        setLayout(null);
        setSize(Bildwidth, Bildheight);
        setBackground(Color.RED);
        setOpaque(true);

// fügt gameover screen hinzu

        JLabel gameOver = new JLabel("Game Over");
        gameOver.setFont(new Font("Tahoma", Font.BOLD, 30));
        gameOver.setForeground(Color.WHITE);
        gameOver.setBounds(0, 100, Bildwidth, 50);
        gameOver.setHorizontalTextPosition(JLabel.CENTER);
        gameOver.setHorizontalAlignment(SwingConstants.CENTER);

//fügt den score vom spieker hinzu
        scoreLabel = new JLabel("Your Score: " + score);
        scoreLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        scoreLabel.setForeground(Color.BLACK);
        scoreLabel.setBounds(0, 175, Bildwidth, 50);
        scoreLabel.setHorizontalAlignment(JLabel.CENTER);
        scoreLabel.setHorizontalTextPosition(SwingConstants.CENTER);


        //Button zum neutstarten
        restart = new JButton("Restart");
        restart.setFont(new Font("Tahoma", Font.BOLD, 20));
        restart.setForeground(Color.BLACK);
        restart.setBounds(xRE, yRE, wRE, hRE);
        restart.setVisible(true);
        restart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (c.checkSinglePlayer()) {
                    c.cGUI.sp.gameStarted = false;
                    c.startSP();
                    System.out.println("Singleplayer wird gestartet");
                } else {
                    c.startMP();
                    System.out.println("Multiplayer wird gestartet");

                }

            }
        });

        menu = new JButton("Menü");
        menu.setFont(new Font("Tahoma", Font.BOLD, 20));
        menu.setForeground(Color.BLACK);
        menu.setBounds(xME, yME, wME, hME);
        menu.setVisible(true);
        menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("zurück zum Menü");
                c.cGUI.sp.gameStarted = false;
                c.menu();

            }
        });




//aus dem array ein html bauen damit man es mit einem Zeilen umbruch ins label hinzufügfen kann
        StringBuilder sb = new StringBuilder("<html>"/*<div style='text-align: center;'>"*/);
        for (String Scoreboard : c.getScoreboard()) {
            sb.append(Scoreboard).append("<br>");
        }
        sb.append("</html>");


        scoreboard = new JLabel("Scoreboard");
        scoreboard.setFont(new Font("Tahoma", Font.BOLD, 20));
        scoreboard.setForeground(Color.BLACK);
        scoreboard.setBounds(0, 350, Bildwidth, 250);
        scoreboard.setHorizontalAlignment(JLabel.CENTER);
        scoreboard.setHorizontalTextPosition(SwingConstants.CENTER);
        scoreboard.setVerticalAlignment(JLabel.TOP);
        scoreboard.setText(sb.toString());

        add(gameOver);
        add(menu);
        add(restart);
        add(scoreLabel);
        add(scoreboard);
    }



}

