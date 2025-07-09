package com.blockblast.gui.window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginScreen extends JPanel implements KeyListener
{
    TextField usernameField;
    ControllerGUI c;
    String username = " ";
    private static int BildWidth = 400;
    private static int BildHeigth = 250;
    private static int loginWidth = 44;



    public LoginScreen(ControllerGUI c)
    {
        this.c=c;
        setSize(BildWidth,BildHeigth);
        setLayout(null);
        setBackground(Color.BLACK);
        usernameField = new TextField();
        usernameField.setBounds(15,150,250,50);
        usernameField.setFont(new Font("Tahoma",Font.BOLD,40));
        usernameField.setBackground(Color.LIGHT_GRAY);
        usernameField.setFocusable(true);
        usernameField.addKeyListener(this);
        usernameField.requestFocusInWindow();



        JLabel headline = new JLabel("Enter Username:");
        headline.setFont(new Font("Tahoma",Font.BOLD,40));
        headline.setBounds(0,50,BildWidth,50);
        headline.setForeground(Color.GREEN);
        headline.setHorizontalAlignment(JLabel.CENTER);
        headline.setHorizontalTextPosition(SwingConstants.CENTER);

        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Tahoma",Font.BOLD,20));
        loginButton.setBackground(Color.CYAN);
        loginButton.setBounds(275,150,100,50);
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
