package com.blockblast.gui.window;
import javax.swing.*;
import com.blockblast.controller.controller;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOver extends JPanel {
    controller c;

    public GameOver(controller c, int score) {

        this.c = c;

//        //Grundsetup
//        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//      setResizable(false); //Window bleibt genausogroß wie wir wollen
        setVisible(false);
        setLayout(null);
        setSize(500,600);
        setBackground(Color.RED);
        setOpaque(true);


        JLabel GameOver = new JLabel("Game Over");
        GameOver.setFont(new Font("Tahoma", Font.BOLD, 30));
        GameOver.setForeground(Color.WHITE);
        GameOver.setBounds(162, 100,300,50 );
        GameOver.setVisible(true);
        GameOver.

        //Button zum neutstarten
        JButton restart = new JButton("Restart");
        restart.setFont(new Font("Tahoma", Font.BOLD, 20));
        restart.setForeground(Color.BLACK);
        restart.setBounds(50,300,175,50);
        restart.setVisible(true);
        restart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Singleplayer wird gestartet");
                System.out.println("Singleplayer wird gestartet");
                if (c.checkSinglePlayer())
                {
                    c.startSP();
                }
                else
                {
                    c.startMP();

                }

            }
        });

        JButton Menu = new JButton("Menü");
        Menu.setFont(new Font("Tahoma", Font.BOLD, 20));
        Menu.setForeground(Color.BLACK);
        Menu.setBounds(50,300,175,50);
        Menu.setVisible(true);
        Menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Singleplayer wird gestartet");

            }
        });
    }

}
