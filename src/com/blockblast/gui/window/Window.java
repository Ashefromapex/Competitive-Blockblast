package com.blockblast.gui.window;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class Window extends JFrame {

    //instanzvariable erstellen
    JLabel label;
    JButton [][] grid = new JButton[8][8];
    JButton [][] fakeGrid = new JButton[8][8];
    JButton [][] blockPreview1 = new JButton[5][5];
    JButton [][] blockPreview2 = new JButton[5][5];
    JButton [][] blockPreview3 = new JButton[5][5];
    static GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];
    public Window(ActionListener listener) {


        //Window erstellen
        setTitle("BlockBlast");


        //Button erstellen south
        //ist zur Zeit nicht verwendet
        JPanel buttonPanel = new JPanel();
        JButton repeatButton = new JButton("Repeat");
        JButton startButton = new JButton("Start");
        buttonPanel.add(repeatButton);
        buttonPanel.add(startButton);

        //MainPanel erstellen
        JPanel mainPanel = new JPanel();
        GridLayout mainPanelGridLayout = new GridLayout(0,8);
        mainPanel.setLayout(mainPanelGridLayout);
        mainPanel.setOpaque(true);
        int mainPanelBorder = 50; //Abstand vom Rand des Fensters
        int boardSize = 640; //Größe des Boards
        mainPanel.setBounds(0,50,boardSize,boardSize); //Position und Größe des Boards im Layout
        EmptyBorder Distance = new EmptyBorder(mainPanelBorder, mainPanelBorder, mainPanelBorder, mainPanelBorder);
        LineBorder mainPanelOutline = new LineBorder(Color.black);
        CompoundBorder mainPanelCompoundBorder = new CompoundBorder(Distance, mainPanelOutline); //Coole schwarze Outline
        mainPanel.setBorder(mainPanelCompoundBorder);
        mainPanel.setBackground(Color.DARK_GRAY);
        for(int j = 0; j < 8; j++)
        {
            for(int i = 0;i < 8;i++) //Code Monstrum zusammengefasst
            {
                JButton b = new JButton();
                b.setBackground(Color.GRAY);
                mainPanel.add(b);
                grid[i][j] = b;
            }
        }

        //Fake Board zum Blöcke hovern erstellen, sieht genauso aus wie das Main Board
        JPanel fakeBoard = new JPanel();
        GridLayout fakeBoardGridLayout = new GridLayout(0,8);
        fakeBoard.setLayout(fakeBoardGridLayout);
        fakeBoard.setBounds(0,50,boardSize,boardSize);
        fakeBoard.setOpaque(false); //macht durchsichtig
        fakeBoard.setBackground(new Color(0,0,0,0)); //macht durchsichtig
        fakeBoard.setBorder(Distance);
        for(int j = 0; j < 8; j++)
        {
            for(int i = 0;i < 8;i++) //Füllen mit Blöcken
            {
                JButton b = new JButton();
                b.setOpaque(false); //macht durchsichtig
                b.setContentAreaFilled(false); //macht Blöcke innen durchsichtig
                b.setBorderPainted(false); //macht Block Outlines durchsichtig
                fakeBoard.add(b);
                fakeGrid[i][j] = b;
            }
        }

        //BlockPanel erstellen und Space für die einzelnen Blöcke
        JPanel blockPanel = new JPanel(); //Panel für die BlockPreviews
        blockPanel.setBackground(Color.DARK_GRAY);
        BoxLayout blockPanelLayout = new BoxLayout(blockPanel,BoxLayout.LINE_AXIS); //horizontales BoxLayout
        blockPanel.setLayout(blockPanelLayout);
        int blockBorder = 10; //Abstand vom Rand
        int blockPreviewSize = 200; //Größe des BlockPreviews
        JPanel block1 = new JPanel(); //1.Block
        block1.setLayout(new GridLayout(5,5));
        block1.setPreferredSize(new Dimension(blockPreviewSize, blockPreviewSize));
        for(int j = 0; j < 5; j++)
        {
            for (int i = 0; i < 5; i++) //Ausfüllen mit JButtons
            {
                JButton b = new JButton();
                b.setBackground(Color.GRAY);
                block1.add(b);
                blockPreview1[i][j] = b;
            }
        }
        JPanel block2 = new JPanel(); //2.Block
        block2.setLayout(new GridLayout(5,5));
        block2.setPreferredSize(new Dimension(blockPreviewSize, blockPreviewSize));
        for(int j = 0; j < 5; j++)
        {
            for (int i = 0; i < 5; i++) //Ausfüllen mit JButtons
            {
                JButton b = new JButton();
                b.setBackground(Color.GRAY);
                block2.add(b);
                blockPreview2[i][j] = b;
            }
        }
        JPanel block3 = new JPanel(); //3.Block
        block3.setLayout(new GridLayout(5,5));
        block3.setPreferredSize(new Dimension(blockPreviewSize, blockPreviewSize));
        for(int j = 0; j < 5; j++)
        {
            for (int i = 0; i < 5; i++) //Ausfüllen mit JButtons
            {
                JButton b = new JButton();
                b.setBackground(Color.GRAY);
                block3.add(b);
                blockPreview3[i][j] = b;
            }
        }
        //Elemente des BoxLayouts, von links nach rechts
        blockPanel.add(Box.createRigidArea(new Dimension(blockBorder, 0)));
        blockPanel.add(block1);
        blockPanel.add(Box.createRigidArea(new Dimension(blockBorder, 0)));
        blockPanel.add(block2);
        blockPanel.add(Box.createRigidArea(new Dimension(blockBorder, 0)));
        blockPanel.add(block3);
        blockPanel.add(Box.createRigidArea(new Dimension(blockBorder, 0)));

        //Abstand von unterem Rand und BlockPreviews erstellen
        JPanel blockOverlord = new JPanel(); //Panel, was blockPanel und Abstandspanel beinhaltet
        blockOverlord.setLayout(new BorderLayout());
        JPanel southBumper = new JPanel(); //Bumper zu unterem Rand
        int southBumperHeight = 20; //Abstand zu unterem Rand
        southBumper.setBackground(Color.DARK_GRAY);
        southBumper.setPreferredSize(new Dimension(blockBorder*4+blockPreviewSize*3, southBumperHeight));
        blockOverlord.add(southBumper, BorderLayout.SOUTH);
        blockOverlord.add(blockPanel, BorderLayout.CENTER);
        blockOverlord.setBounds(0,50+boardSize,boardSize,blockPreviewSize+southBumperHeight); //Position und Größe des Panels im Layout



        //Titel erstellen
        JLabel titleLabel = new JLabel("BlockBlast");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
        titleLabel.setBounds(0,0,boardSize,50); //Bestimmt Position und Größe des Titels


        //Top label layout
        //Start und Stop Stuff
        //fügt alles hinzu, was zuerst hinzugefügt wird ist am weitesten oben
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false); //Window bleibt genausogroß wie wir wollen
        setVisible(true);
        setLayout(null);
        setSize(new Dimension(boardSize+15,50+boardSize+mainPanelBorder+blockPreviewSize+southBumperHeight-15));
        add(titleLabel);
        add(fakeBoard);
        add(mainPanel);
        add(blockOverlord);





        //neue Komponente
        label = new JLabel();
        label.setText("---");

        //Pannel einfügen -> Button einfügen
        /*p.add(b1);
        p.add(b2);
        p.add(label);*/

        //gibt ideale Größe an und centert den Frame
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



