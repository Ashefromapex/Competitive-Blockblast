package com.blockblast.gui.window;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Window extends JFrame {

    //instanzvariable erstellen
    JLabel label;
    JButton [][] grid = new JButton[8][8];
    JButton [][] fakeGrid = new JButton[8][8];
    JButton [][] blockPreview1 = new JButton[5][5];
    JButton [][] blockPreview2 = new JButton[5][5];
    JButton [][] blockPreview3 = new JButton[5][5];
    JPanel mainPanel;
    JPanel fakeBoard;
    JPanel block1;
    JPanel block2;
    JPanel block3;
    private boolean block1Chosen = false;
    private boolean block2Chosen = false;
    private boolean block3Chosen = false;
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
        mainPanel = new JPanel();
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
        fakeBoard = new JPanel();
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


        int blockBorder = 10; //Abstand vom Rand
        int blockPreviewSize = 200; //Größe des BlockPreviews
        block1 = new JPanel(); //1.Block
        block1.setLayout(new GridLayout(5,5));
        block1.setPreferredSize(new Dimension(blockPreviewSize, blockPreviewSize));
        block1.setBounds(blockBorder,50+boardSize,blockPreviewSize,blockPreviewSize);
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
        block2 = new JPanel(); //2.Block
        block2.setLayout(new GridLayout(5,5));
        block2.setPreferredSize(new Dimension(blockPreviewSize, blockPreviewSize));
        block2.setBounds(blockBorder*2+blockPreviewSize,50+boardSize,blockPreviewSize,blockPreviewSize);
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
        block3 = new JPanel(); //3.Block
        block3.setLayout(new GridLayout(5,5));
        block3.setPreferredSize(new Dimension(blockPreviewSize, blockPreviewSize));
        block3.setBounds(blockBorder*3+blockPreviewSize*2,50+boardSize,blockPreviewSize,blockPreviewSize);
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


        JPanel southBumper = new JPanel(); //Bumper zu unterem Rand
        int southBumperHeight = 20; //Abstand zu unterem Rand
        southBumper.setBackground(Color.DARK_GRAY);
        southBumper.setPreferredSize(new Dimension(blockBorder*4+blockPreviewSize*3, blockPreviewSize+southBumperHeight));
        southBumper.setBounds(0,50+boardSize,blockBorder*4+blockPreviewSize*3,blockPreviewSize+southBumperHeight);



        //Titel erstellen
        JLabel titleLabel = new JLabel("BlockBlast");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
        titleLabel.setBounds(0,0,boardSize,50); //Bestimmt Position und Größe des Titels


        //Blöcke zum Testen hardcoden
        blockPreview1[0][0].setText("Block");
        blockPreview1[0][1].setText("Block");
        blockPreview1[0][2].setText("Block");
        blockPreview1[1][2].setText("Block");
        blockPreview1[2][2].setText("Block");

        blockPreview2[0][0].setText("Block");
        blockPreview2[0][1].setText("Block");
        blockPreview2[1][1].setText("Block");
        blockPreview2[1][0].setText("Block");

        blockPreview3[0][0].setText("Block");
        blockPreview3[0][1].setText("Block");
        blockPreview3[0][2].setText("Block");
        blockPreview3[0][3].setText("Block");
        blockPreview3[0][4].setText("Block");


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
        add(block1);
        add(block2);
        add(block3);
        add(southBumper);






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

        do
        {
            if(!block1Chosen && !block2Chosen && !block3Chosen)
            {
                if(Keyboard.isKeyPressed(KeyEvent.VK_1))
                {
                    chooseBlock1();
                }
                if(Keyboard.isKeyPressed(KeyEvent.VK_2))
                {
                    chooseBlock2();
                }
                if(Keyboard.isKeyPressed(KeyEvent.VK_3))
                {
                    chooseBlock3();
                }
            }
            if(Keyboard.isKeyPressed(KeyEvent.VK_ESCAPE))
            {
                deselectBlock();
            }
        } while (!Keyboard.isKeyPressed(KeyEvent.VK_4));
    }

    public void showMessage(String msg)
    {
        label.setText(msg);

    }

    public void chooseBlock1()
    {
        for(int j = 0; j < 5; j++)
        {
            for(int i = 0; i < 5; i++)
            {
                fakeGrid [i][j].setText(blockPreview1[i][j].getText());
            }
        }
        block1.setVisible(false);
        block1Chosen = true;
    }

    public void chooseBlock2()
    {
        for(int j = 0; j < 5; j++)
        {
            for(int i = 0; i < 5; i++)
            {
                fakeGrid [i][j].setText(blockPreview2[i][j].getText());
            }
        }
        block2.setVisible(false);
        block2Chosen = true;
    }

    public void chooseBlock3()
    {
        for(int j = 0; j < 5; j++)
        {
            for(int i = 0; i < 5; i++)
            {
                fakeGrid [i][j].setText(blockPreview3[i][j].getText());
            }
        }
        block3.setVisible(false);
        block3Chosen = true;
    }

    public void deselectBlock()
    {
        for(int j = 0; j < 8; j++)
        {
            for(int i = 0; i < 8; i++)
            {
                fakeGrid [i][j].setText("");
            }
        }

        if(block1Chosen)
        {
            block1.setVisible(true);
            block1Chosen = false;
        }
        if(block2Chosen)
        {
            block2.setVisible(true);
            block2Chosen = false;
        }
        if(block3Chosen)
        {
            block3.setVisible(true);
            block3Chosen = false;
        }
    }
}



