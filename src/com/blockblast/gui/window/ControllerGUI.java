package com.blockblast.gui.window;

import com.blockblast.controller.controller;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/*
the class used for creating the frame and switching between the scenes, the methods are named after the scene that is being switched to
 */

public class ControllerGUI extends JFrame
{
    //Instanzvariable
    controller c;
    Singleplayer sp;
    Multiplayer mp;
    public TitleScreen titleScreen;
    LoginScreen loginScreen;
    GameOver gameOver;
    EnemySelect enemySelect;
    Queue queue;

    //Erzeugt Fenster
    public ControllerGUI(controller c) {
        setVisible(true);
        this.c = c;
        loginScreen = new LoginScreen(this);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false); //Window bleibt genausogroß wie wir wollen
        setTitle("Blockblast");
        setContentPane(loginScreen);
        setSize(getContentPane().getWidth(), getContentPane().getHeight());
        setLocationRelativeTo(null);
    }

    public void singleplayer() {
        sp = new Singleplayer(c, this);
        sp.requestFocusInWindow();
        setContentPane(sp);
        setSize(getContentPane().getWidth(), getContentPane().getHeight());
        setLocationRelativeTo(null);
    }

    public void multiplayer() {
        mp = new Multiplayer(c, this);
        mp.requestFocusInWindow();
        setContentPane(mp);
        setSize(getContentPane().getWidth(), getContentPane().getHeight());
        setLocationRelativeTo(null);
    }

    public void titleScreen()
    {
        titleScreen = new TitleScreen(c);
        setContentPane(titleScreen);
        setSize(getContentPane().getWidth(), getContentPane().getHeight());
        setLocationRelativeTo(null);
        c.login(loginScreen.getUsername());
    }

    public void GameOver(int score)
    {
        gameOver = new GameOver(c,score);
        setContentPane(gameOver);
        setSize(getContentPane().getWidth(),getContentPane().getHeight());
        setLocationRelativeTo(null);

    }

    public void enemySelect()
    {
        enemySelect = new EnemySelect(this);
        setContentPane(enemySelect);
        setSize(getContentPane().getWidth(), getContentPane().getHeight());
        setLocationRelativeTo(null);
    }

    public void queue()
    {
        queue = new Queue(this);
        setContentPane(queue);
        setSize(getContentPane().getWidth(), getContentPane().getHeight());
        setLocationRelativeTo(null);
    }

}
