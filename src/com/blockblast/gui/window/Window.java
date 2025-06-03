package com.blockblast.gui.window;

import javax.swing.*;

public class Window extends JFrame {

    //instanzvariable erstellen
    JLabel label;

    public Window() {


        //Window erstellen
        setTitle("BlockBlast");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setSize(500, 500);

        //JPanel erstellen
        JPanel p = new JPanel();
        add(p);

        //Button erstellen
        JButton b1 = new JButton("Start");
        JButton b2 = new JButton("Close");

        //neue Komponente
        label = new JLabel();
        label.setText("---");

        //Pannel einfügen -> Button einfügen
        p.add(b1);
        p.add(b2);
        p.add(label);

        pack();

        //controller erstellen
        Controller c = new Controller();
        b1.addActionListener(c);
        b2.addActionListener(c);


    }

}

