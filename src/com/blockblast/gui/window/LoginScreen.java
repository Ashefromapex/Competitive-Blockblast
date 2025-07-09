package com.blockblast.gui.window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginScreen extends JPanel implements KeyListener
{
    TextField usernameField;
    ControllerGUI c;
    String username = " ";


    public LoginScreen(ControllerGUI c)
    {
        this.c=c;
        setSize(500,600);
        setLayout(null);
        setBackground(Color.BLUE);
        usernameField = new TextField();
        usernameField.setBounds(50,150,250,50);
        usernameField.setFont(new Font("Tahoma",Font.BOLD,40));
        usernameField.setBackground(Color.LIGHT_GRAY);
        usernameField.setFocusable(true);
        usernameField.addKeyListener(this);
        usernameField.requestFocusInWindow();



        JLabel headline = new JLabel("Blockblast");
        headline.setFont(new Font("Tahoma",Font.BOLD,50));
        headline.setBounds(100,50,300,50);

        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Tahoma",Font.BOLD,20));
        loginButton.setBackground(Color.CYAN);
        loginButton.setBounds(310,150,100,50);
//        loginButton.setFocusable(true);
//        loginButton.requestFocusInWindow();
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(!usernameField.getText().isEmpty())
                {
                    System.out.println("Logged in as "+ usernameField.getText());
                    username=usernameField.getText();
                    c.titleScreen();
                }
            }
        });

        add(usernameField);
        add(headline);
        add(loginButton);

    }

    String getUsername()
    {
        return username;
    }


    @Override
    public void keyTyped(KeyEvent e) {


    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        if(e.getKeyCode()== KeyEvent.VK_ENTER)
        {
            if(!usernameField.getText().isEmpty())
            {
                System.out.println("Logged in as "+ usernameField.getText());
                username=usernameField.getText();
                c.titleScreen();
            }
        }
    }


    @Override
    public void keyReleased(KeyEvent e) {

    }


}
