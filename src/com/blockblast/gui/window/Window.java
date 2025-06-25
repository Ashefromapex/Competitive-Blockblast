package com.blockblast.gui.window;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
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
        GridLayout mainPanelGridLayout = new GridLayout(0,8);
        mainPanel.setLayout(mainPanelGridLayout);
        int mainPanelBorder = 50;
        EmptyBorder Distance = new EmptyBorder(mainPanelBorder, mainPanelBorder, mainPanelBorder, mainPanelBorder);
        LineBorder mainPanelOutline = new LineBorder(Color.black);
        CompoundBorder mainPanelCompoundBorder = new CompoundBorder(Distance, mainPanelOutline);
        mainPanel.setBorder(mainPanelCompoundBorder);
        mainPanel.setBackground(Color.DARK_GRAY);
        mainPanel.setPreferredSize(new Dimension(400,400));
        mainPanel.setMaximumSize(new Dimension(400,400));

        //BlockPanel erstellen und Space für die einzelnen Blöcke
        JPanel blockPanel = new JPanel();
        blockPanel.setBackground(Color.DARK_GRAY);
        BoxLayout blockPanelLayout = new BoxLayout(blockPanel,BoxLayout.LINE_AXIS);
        blockPanel.setLayout(blockPanelLayout);
        int blockBorder = 10;
        int blockPreviewSize = 125;
        JPanel block1 = new JPanel();
        block1.setLayout(new GridLayout(5,5));
        block1.setPreferredSize(new Dimension(blockPreviewSize, blockPreviewSize));
        for (int i = 0; i < 25; i++)
        {
            JButton b = new JButton();
            b.setBackground(Color.GRAY);
            block1.add(b);
        }
        JPanel block2 = new JPanel();
        block2.setLayout(new GridLayout(5,5));
        block2.setPreferredSize(new Dimension(blockPreviewSize, blockPreviewSize));
        for (int i = 0; i < 25; i++)
        {
            JButton b = new JButton();
            b.setBackground(Color.GRAY);
            block2.add(b);
        }
        JPanel block3 = new JPanel();
        block3.setLayout(new GridLayout(5,5));
        block3.setPreferredSize(new Dimension(blockPreviewSize, blockPreviewSize));
        for (int i = 0; i < 25; i++)
        {
            JButton b = new JButton();
            b.setBackground(Color.GRAY);
            block3.add(b);
        }
        blockPanel.add(Box.createRigidArea(new Dimension(blockBorder, 0)));
        blockPanel.add(block1);
        blockPanel.add(Box.createRigidArea(new Dimension(blockBorder, 0)));
        blockPanel.add(block2);
        blockPanel.add(Box.createRigidArea(new Dimension(blockBorder, 0)));
        blockPanel.add(block3);
        blockPanel.add(Box.createRigidArea(new Dimension(blockBorder, 0)));

        //Unteren Rand von den BlockPreviews entfernen
        JPanel blockOverlord = new JPanel();
        blockOverlord.setLayout(new BorderLayout());
        JPanel southBumper = new JPanel();
        southBumper.setBackground(Color.DARK_GRAY);
        southBumper.setPreferredSize(new Dimension(blockBorder*4+blockPreviewSize*3, blockBorder));
        blockOverlord.add(southBumper, BorderLayout.SOUTH);
        blockOverlord.add(blockPanel, BorderLayout.CENTER);

        JColorChooser colorChooser = new JColorChooser();
        colorChooser.setColor(Color.GRAY);
        colorChooser.setSize(10,10);
        colorChooser.setBounds(50,50,50,50);

        for(int i = 0;i < 64;i++) //Code Monstrum zusammengefasst
        {
            JButton b = new JButton();
            b.setBackground(colorChooser.getColor());
            this.add(b);
            mainPanel.add(b);
            grid.add(b);
        }


        mainPanel.setVisible(true);
        blockPanel.setVisible(true);


        //Titel erstellen
        JLabel titleLabel = new JLabel("BlockBlast");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));

        //Top label layout
        add(titleLabel, BorderLayout.NORTH);
        add(mainPanel, BorderLayout.CENTER);
        add(blockOverlord, BorderLayout.SOUTH);




        //neue Komponente
        label = new JLabel();
        label.setText("---");

        //Pannel einfügen -> Button einfügen
        /*p.add(b1);
        p.add(b2);
        p.add(label);*/

        //gibt ideale Größe an und centert den Frame
        pack();
        setLocationRelativeTo(null);

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



