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


        setExtendedState(JFrame.MAXIMIZED_BOTH); //Windowed Fullscreen
        setVisible(true);

        //Window erstellen
        setTitle("BlockBlast");

        //Titel erstellen
        JLabel titleLabel = new JLabel("BlockBlast");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 5, 0, 5));

        //Button erstellen south
        JPanel buttonPanel = new JPanel();
        //JButton repeatButton = new JButton("Repeat");
        JButton startButton = new JButton("Start");
        //buttonPanel.add(repeatButton);
        buttonPanel.add(startButton);

        //MainPanel erstellen
        JPanel mainPanel = new JPanel();
        //setLayout(new GridLayout(0,8));
        mainPanel.setSize(500,800);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20,20,0,20));
        mainPanel.setPreferredSize(new Dimension(120,120));
        mainPanel.setBackground(Color.DARK_GRAY);

        //Main1Panel erstellen
        JPanel main1Panel = new JPanel();
        //setLayout(new GridLayout(0,8));
        main1Panel.setSize(500,800);
        main1Panel.setBorder(BorderFactory.createEmptyBorder(20,20,0,20));
        main1Panel.setBackground(Color.WHITE);

        //Main2Panel erstellen
        JPanel main2Panel = new JPanel();
        //setLayout(new GridLayout(0,8));
        main2Panel.setSize(500,800);
        main2Panel.setBorder(BorderFactory.createEmptyBorder(20,20,0,20));
        main2Panel.setBackground(Color.WHITE);

        GridLayout gridLayout = new GridLayout(0,8);
        mainPanel.setLayout(gridLayout);


        JColorChooser colorChooser = new JColorChooser();
        colorChooser.setColor(Color.GRAY);
        colorChooser.setSize(15,15);
        colorChooser.setBounds(50,50,50, 50);

        for(int i = 0;i < 64;i++) //Code Monstrum zusammengefasst
        {
            JButton b = new JButton();


            b.setBackground(colorChooser.getColor());
            this.add(b);
            grid.add(b);
            b.setSize(15,15);
            mainPanel.add(b);
        }

        mainPanel.setVisible(true);




        //Top label layout
        add(titleLabel, BorderLayout.NORTH);
        add(mainPanel, BorderLayout.CENTER);
        add(main1Panel, BorderLayout.WEST);
        add(main2Panel, BorderLayout.EAST);
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
        //repeatButton.addActionListener(listener);
        startButton.addActionListener(listener);



    }

    public void showMessage(String msg)
    {
        label.setText(msg);

    }
}



