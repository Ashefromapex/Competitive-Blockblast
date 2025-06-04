package com.blockblast.gui.window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class Window extends JFrame {

    //instanzvariable erstellen
    JLabel label;

    public Window(ActionListener listener) {


        //Window erstellen north
        setTitle("BlockBlast");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 1000);

        //MainPanel erstellen
        JPanel mainPanel = new JPanel();
        setLayout(new BorderLayout(5,5));
        setLayout(new GridLayout(8,50));
        mainPanel.setSize(5000,5000);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(50,50,50,50));
        mainPanel.setBackground(Color.DARK_GRAY);
        ;

        //MainPanel Buttons
        GridLayout gridLayout = new GridLayout(8,8);

        JButton[] buttons = new JButton[64];
        for (int i = 0; i < 64; i++)
        {
            buttons[i] = new JButton("");
            buttons[i].addActionListener(listener);
            buttons[i].setBackground(Color.red);
            buttons[i].setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
            buttons[i].setSize(200,200);
            mainPanel.add(buttons[i]);

        }
        mainPanel.setVisible(true);
        add(mainPanel, BorderLayout.CENTER);

        //Button erstellen south
        JPanel buttonPanel = new JPanel();
        JButton repeatButton = new JButton("Repeat");
        JButton startButton = new JButton("Start");
        buttonPanel.add(repeatButton);
        buttonPanel.add(startButton);
        buttonPanel.setSize(50,50);
        buttonPanel.setBackground(Color.blue);
        add(buttonPanel, BorderLayout.SOUTH);





        //Titel erstellen
        JLabel titleLabel = new JLabel("BlockBlast");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 5, 10, 5));

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



