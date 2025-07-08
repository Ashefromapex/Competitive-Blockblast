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
    TitleScreen titleScreen;
    LoginScreen loginScreen;
    KeyboardFocusManager focusManager;
    EnemySelect enemySelect;

    //Erzeugt Fenster
    public ControllerGUI(controller c)
    {
        setVisible(true);
        this.c = c;
        enemySelect = new EnemySelect();
        loginScreen = new LoginScreen(this);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false); //Window bleibt genausogroß wie wir wollen
        setTitle("Blockblast");
        setContentPane(loginScreen);
        setSize(getContentPane().getWidth(),getContentPane().getHeight());
        setLocationRelativeTo(null);
        focusManager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
    }

    public void singleplayer()
    {
        c.startSP();
        sp = new Singleplayer(c, this);
        focusManager.addKeyEventDispatcher(new KeyEventDispatcher() {
            @Override
            public boolean dispatchKeyEvent(KeyEvent e)
            {
                if(e.paramString().charAt(4)=='P')
                {
                    sp.keyPressed(e);
                }
                return true;
            }
        });
        setContentPane(sp);
        setSize(getContentPane().getWidth(),getContentPane().getHeight());
        setLocationRelativeTo(null);
    }

    public void multiplayer()
    {
        c.startMP();
        mp = new Multiplayer(c, this);
        setContentPane(mp);
        setSize(getContentPane().getWidth(),getContentPane().getHeight());
        setLocationRelativeTo(null);
    }

    public void loggedtfin()
    {
        titleScreen = new TitleScreen(this);
        setContentPane(titleScreen);
        setSize(getContentPane().getWidth(),getContentPane().getHeight());
        setLocationRelativeTo(null);
        c.login(loginScreen.getUsername());
    }

}
