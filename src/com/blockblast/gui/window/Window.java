package com.blockblast.gui.window;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;


public class Window extends JFrame {

    //instanzvariable erstellen
    JLabel label;

    public Window(ActionListener listener) {


        //Window erstellen north
        setTitle("BlockBlast");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(650, 800);

        //Titel erstellen
        JLabel titleLabel = new JLabel("BlockBlast");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
        //titleLabel.setBackground(Color.BLUE);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(30, 5, 0, 5));
        add(titleLabel, BorderLayout.NORTH);
        setPreferredSize(new Dimension(50,5000));




        //MainPanel erstellen
        JPanel mainPanel = new JPanel();
        setLayout(new BorderLayout(3,0));

        mainPanel.setSize(5000,5000);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(50,50,5,50));
        //mainPanel.setBackground(Color.DARK_GRAY);;

        ;


        //MainPanel Buttons
        GridLayout gridLayout = new GridLayout(8,8);

        JButton[] buttons = new JButton[64];
        for (int i = 0; i < 64; i++)
        {
            buttons[i] = new JButton("");
            buttons[i].addActionListener(listener);
            buttons[i].setBackground(Color.red);
            buttons[i].setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
            buttons[i].setSize(5000,5000000);
            mainPanel.add(buttons[i]);

        }
        mainPanel.setVisible(true);
        add(mainPanel, BorderLayout.CENTER);


        //Button erstellen south
        JPanel buttonPanel = new JPanel();
        JButton repeatButton = new JButton("Repeat");
        repeatButton.setHorizontalTextPosition(SwingConstants.CENTER);
        JButton startButton = new JButton("Start ");
        repeatButton.setHorizontalTextPosition(SwingConstants.CENTER);

        buttonPanel.add(repeatButton);
        buttonPanel.add(startButton);
        //buttonPanel.setSize(1000,5000);
        //buttonPanel.setBackground(Color.blue);
        add(buttonPanel, BorderLayout.SOUTH);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));


        repeatButton.setBorder(BorderFactory.createEmptyBorder(30,70,30,40));
        repeatButton.setHorizontalAlignment(SwingConstants.CENTER);

        startButton.setBorder(BorderFactory.createEmptyBorder(30,40,30,70));
            startButton.setHorizontalAlignment(SwingConstants.CENTER);


        buttonPanel.setVisible(true);









        //Top label layout
        add(titleLabel, BorderLayout.NORTH);
        add(mainPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);





        //neue Komponente
        label = new JLabel();
        label.setText("---");


        //Pannel einfügen -> Button einfügen
        /*p.add(b1);
        p.add(b2);
        p.add(label);*/

        //gibt ideale Größe an
        //pack();

        //verdrahtung controller mit buttons
        //Controller c = new Controller();
        repeatButton.addActionListener(listener);
        startButton.addActionListener(listener);




    }

    public void showMessage(String msg)
    {
        label.setText(msg);

    }
}



