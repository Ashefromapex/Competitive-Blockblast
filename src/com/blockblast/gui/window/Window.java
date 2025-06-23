package com.blockblast.gui.window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Window extends JFrame {

    //instanzvariable erstellen
    JLabel label;
    ArrayList<JButton> grid = new ArrayList<JButton>();
    static GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];
    public Window(ActionListener listener) {




        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);

        //Window erstellen
        setTitle("BlockBlast");

        //Button erstellen south
        JPanel buttonPanel = new JPanel();
        JButton repeatButton = new JButton("Repeat");
        JButton startButton = new JButton("Start");
        buttonPanel.add(repeatButton);
        buttonPanel.add(startButton);

        //MainPanel erstellen
        JPanel mainPanel = new JPanel();
        setLayout(new GridLayout(0,8));
        mainPanel.setSize(500,800);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20,20,0,20));
        mainPanel.setBackground(Color.DARK_GRAY);

        JColorChooser colorChooser = new JColorChooser();
        colorChooser.setColor(Color.GRAY);
        colorChooser.setSize(10,10);
        colorChooser.setBounds(50,50,50,50);

        for(int i = 0;i < 64;i++)
        {
            JButton b = new JButton();
            mainPanel.add(b);
            b.setSize(25,50);
            b.setBackground(colorChooser.getColor());
            this.add(b);
            grid.add(b);
        }


        mainPanel.setVisible(true);


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
        /*pack();*/

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



