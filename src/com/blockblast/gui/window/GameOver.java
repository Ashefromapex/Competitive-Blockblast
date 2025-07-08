package com.blockblast.gui.window;
import javax.swing.*;
import com.blockblast.controller.controller;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOver extends JPanel {
    controller c;
    JButton restart;
    JButton menu;
    JLabel scoreLabel;

    public GameOver(controller c, int score) {

        this.c = c;

//        //Grundsetup
//        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//      setResizable(false); //Window bleibt genausogroß wie wir wollen
        setVisible(true);
        setLayout(null);
        setSize(500,600);
        setBackground(Color.RED);
        setOpaque(true);


        JLabel gameOver = new JLabel("Game Over");
        gameOver.setFont(new Font("Tahoma", Font.BOLD, 30));
        gameOver.setForeground(Color.WHITE);
        gameOver.setBounds(162, 100,300,50 );
        gameOver.setVisible(true);


        scoreLabel = new JLabel("Score: " + score);
        scoreLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
        scoreLabel.setForeground(Color.BLACK);
        scoreLabel.setBounds(162, 175,300,50 );
        scoreLabel.setVisible(true);





        //Button zum neutstarten
        restart = new JButton("Restart");
        restart.setFont(new Font("Tahoma", Font.BOLD, 20));
        restart.setForeground(Color.BLACK);
        restart.setBounds(50,300,175,50);
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
        menu.setBounds(250,300,175,50);
        menu.setVisible(true);
        menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("zurück zum Menü");
                c.menu();

            }
        });
        add(gameOver);
        add(menu);
        add(restart);
        add(scoreLabel);
    }



}
