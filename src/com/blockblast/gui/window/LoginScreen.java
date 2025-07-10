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

    // width ist bei beiden unterschiedlich, heitgth wird über loginbar definiert
    private static int loginButtonWidth = 100;
    private static int usernameFieldWidth = 250;

    // login bar ist der login button + das feld zum username entern.
    private static int loginbarWidth = usernameFieldWidth + loginButtonWidth  + 10 ;
    private static int loginbarHeight = 50;
    private static int loginbarY = 150;
    private static int loginbarX = BildWidth/2 - loginbarWidth/2;

    //durch die postition der loginbar wird die position der einzelnen komponeneten der loginbar berechnet
    private static int usernameFieldX = loginbarX;
    private static int loginButtonX = loginbarX + usernameFieldWidth + 10;





    public LoginScreen(ControllerGUI c)
    {
//        System.out.println(loginbarX);
//        System.out.println(loginButtonX);
//        System.out.println(loginbarX + usernameFieldWidth );
//        System.out.println(loginbarWidth);
//        System.out.println(loginbarWidth + loginbarX * 2 + " = " + BildWidth);


        this.c=c;
        setSize(BildWidth,BildHeigth);
        setLayout(null);
        setBackground(Color.BLACK);


        JLabel headline = new JLabel("Enter Username:");
        headline.setFont(new Font("Tahoma",Font.BOLD,40));
        headline.setBounds(0,50,BildWidth,50);
        headline.setForeground(new Color(0, 200, 0));
        headline.setHorizontalAlignment(JLabel.CENTER);
        headline.setHorizontalTextPosition(SwingConstants.CENTER);


        usernameField = new TextField();
        usernameField.setFont(new Font("Tahoma",Font.BOLD,40));
        usernameField.setBackground(Color.LIGHT_GRAY);
        usernameField.setBounds(usernameFieldX,loginbarY,usernameFieldWidth,loginbarHeight);
        usernameField.setFocusable(true);
        usernameField.addKeyListener(this);
        usernameField.requestFocusInWindow();


        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Tahoma",Font.BOLD,20));
        loginButton.setBackground(new Color(0, 130, 200));
        setForeground(new Color(0, 0, 0));
        loginButton.setBounds(loginButtonX,loginbarY,loginButtonWidth,loginbarHeight);
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
