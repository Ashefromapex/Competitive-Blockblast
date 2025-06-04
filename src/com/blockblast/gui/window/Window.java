package com.blockblast.gui.window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Window extends JFrame {

    //instanzvariable erstellen
    JLabel label;

    public Window(ActionListener listener) {


        //Window erstellen
        setTitle("BlockBlast");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(210, 500);

        //Button erstellen south
        JPanel buttonPanel = new JPanel();
        JButton repeatButton = new JButton("Repeat");
        JButton startButton = new JButton("Start");
        buttonPanel.add(repeatButton);
        buttonPanel.add(startButton);

        //MainPanel erstellen
        JPanel mainPanel = new JPanel();
        setLayout(new GridLayout(3,3));
        mainPanel.setSize(500,800);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20,20,0,20));
        mainPanel.setBackground(Color.DARK_GRAY);


        GridLayout gridLayout = new GridLayout(5,5);



        JButton b1 = new JButton("");
        JButton b2 = new JButton("");
        JButton b3 = new JButton("");
        JButton b4 = new JButton("");
        JButton b5 = new JButton("");
        JButton b6 = new JButton("");
        JButton b7 = new JButton("");
        JButton b8 = new JButton("");
        JButton b9 = new JButton("");
        JButton b10 = new JButton("");
        JButton b11 = new JButton("");
        JButton b12 = new JButton("");
        JButton b13 = new JButton("");
        JButton b14 = new JButton("");
        JButton b15 = new JButton("");
        JButton b16 = new JButton("");
        JButton b17 = new JButton("");
        JButton b18 = new JButton("");
        JButton b19 = new JButton("");
        JButton b20 = new JButton("");
        JButton b21 = new JButton("");
        JButton b22 = new JButton("");
        JButton b23 = new JButton("");
        JButton b24 = new JButton("");
        JButton b25 = new JButton("");

        mainPanel.add(b1);
        mainPanel.add(b2);
        mainPanel.add(b3);
        mainPanel.add(b4);
        mainPanel.add(b5);
        mainPanel.add(b6);
        mainPanel.add(b7);
        mainPanel.add(b8);
        mainPanel.add(b9);
        mainPanel.add(b10);
        mainPanel.add(b11);
        mainPanel.add(b12);
        mainPanel.add(b13);
        mainPanel.add(b14);
        mainPanel.add(b15);
        mainPanel.add(b16);
        mainPanel.add(b17);
        mainPanel.add(b18);
        mainPanel.add(b19);
        mainPanel.add(b20);
        mainPanel.add(b21);
        mainPanel.add(b22);
        mainPanel.add(b23);
        mainPanel.add(b24);
        mainPanel.add(b25);

        b1.setSize(50,10);
        b2.setSize(50,50);
        b3.setSize(50,50);
        b4.setSize(50,50);
        b5.setSize(50,50);
        b6.setSize(50,50);
        b7.setSize(50,50);
        b8.setSize(50,50);
        b9.setSize(50,50);
        b10.setSize(50,50);
        b11.setSize(50,50);
        b12.setSize(50,50);
        b13.setSize(50,50);
        b14.setSize(50,50);
        b15.setSize(50,50);
        b16.setSize(50,50);
        b17.setSize(50,50);
        b18.setSize(50,50);
        b19.setSize(50,50);
        b20.setSize(50,50);
        b21.setSize(50,50);
        b22.setSize(50,50);
        b23.setSize(50,50);
        b24.setSize(50,50);
        b25.setSize(50,50);

        JColorChooser colorChooser = new JColorChooser();
        colorChooser.setColor(Color.GRAY);
        colorChooser.setSize(10,10);
        colorChooser.setBounds(50,50,50,50);
        b1.setBackground(colorChooser.getColor());
        b2.setBackground(colorChooser.getColor());
        b3.setBackground(colorChooser.getColor());
        b4.setBackground(colorChooser.getColor());
        b5.setBackground(colorChooser.getColor());
        b6.setBackground(colorChooser.getColor());
        b7.setBackground(colorChooser.getColor());
        b8.setBackground(colorChooser.getColor());
        b9.setBackground(colorChooser.getColor());
        b10.setBackground(colorChooser.getColor());
        b11.setBackground(colorChooser.getColor());
        b12.setBackground(colorChooser.getColor());
        b13.setBackground(colorChooser.getColor());
        b14.setBackground(colorChooser.getColor());
        b15.setBackground(colorChooser.getColor());
        b16.setBackground(colorChooser.getColor());
        b17.setBackground(colorChooser.getColor());
        b18.setBackground(colorChooser.getColor());
        b19.setBackground(colorChooser.getColor());
        b20.setBackground(colorChooser.getColor());
        b21.setBackground(colorChooser.getColor());
        b22.setBackground(colorChooser.getColor());
        b23.setBackground(colorChooser.getColor());
        b24.setBackground(colorChooser.getColor());
        b25.setBackground(colorChooser.getColor());


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



