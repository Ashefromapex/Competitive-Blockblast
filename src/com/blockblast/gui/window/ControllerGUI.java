package com.blockblast.gui.window;

import com.blockblast.controller.controller;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

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

    //Erzeugt Fenster
    public ControllerGUI(controller c) {
        setVisible(true);
        this.c = c;
        enemySelect = new EnemySelect();
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
        enemySelect = new EnemySelect();
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

}
