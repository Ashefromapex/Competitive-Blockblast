package com.blockblast.gui.window;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

import com.blockblast.Main;
import com.blockblast.controller.controller;

public class  Window extends JFrame implements KeyListener {
    controller c;
    //instanzvariable erstellen
    int deltax;
    int deltay;
    JLabel label;
    JLabel [][] grid = new JLabel[8][8];
    JLabel [][] fakeGrid = new JLabel[8][8];
    JLabel [][] blockPreview1 = new JLabel[5][5];
    JLabel [][] blockPreview2 = new JLabel[5][5];
    JLabel [][] blockPreview3 = new JLabel[5][5];
    JLabel titleLabel;
    JPanel mainPanel;
    JPanel fakeBoard;
    JPanel block1;
    JPanel block2;
    JPanel block3;
    ImageIcon blockTexture = new  ImageIcon(("src/com/blockblast/assets/block_provisorisch.png"));
    ImageIcon hintergrundTexture = new ImageIcon(("src/com/blockblast/assets/hintergrund.png"));
    Image scaleBlockTextureImgPreview;
    ImageIcon scaleBlockTextureIconPreview;
    Image scaleBlockTextureImgBoard;
    ImageIcon scaleBlockTextureIconBoard;
    Image scaleHintergrundTextureImg;
    ImageIcon scaleHintergrundTextureIcon;
    ImageIcon empty = new  ImageIcon();
    private boolean block1Chosen = false;
    private boolean block2Chosen = false;
    private boolean block3Chosen = false;
    private boolean block1Placed = false;
    private boolean block2Placed = false;
    private boolean block3Placed = false;
    static GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];




    public Window(controller c) {
        deltax = 0;
        deltay = 0;

        this.c = c;
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false); //Window bleibt genausogroß wie wir wollen
        setVisible(true);
        setLayout(null);
        addKeyListener(this);
        //Window erstellen
        setTitle("BlockBlast");


;

        //MainPanel erstellen
        mainPanel = new JPanel();
        GridLayout mainPanelGridLayout = new GridLayout(0,8);
        mainPanel.setLayout(mainPanelGridLayout);
        mainPanel.setOpaque(true);
        int mainPanelBorder = 50; //Abstand vom Rand des Fensters
        int boardSize = 400; //Größe des Boards
        mainPanel.setBounds(0,50,boardSize,boardSize); //Position und Größe des Boards im Layout
        EmptyBorder Distance = new EmptyBorder(mainPanelBorder, mainPanelBorder, mainPanelBorder, mainPanelBorder);
        LineBorder mainPanelOutline = new LineBorder(Color.black);
        CompoundBorder mainPanelCompoundBorder = new CompoundBorder(Distance, mainPanelOutline); //Coole schwarze Outline
        mainPanel.setBorder(mainPanelCompoundBorder);
        mainPanel.setBackground(Color.BLUE);
        scaleHintergrundTextureImg = hintergrundTexture.getImage().getScaledInstance((boardSize-mainPanelBorder*2)/8,(boardSize-mainPanelBorder*2)/8,Image.SCALE_DEFAULT);
        scaleHintergrundTextureIcon = new ImageIcon(scaleHintergrundTextureImg);
        for(int i = 0; i < 8; i++)
        {
            for(int j = 0;j < 8;j++) //Code Monstrum zusammengefasst
            {
                JLabel b = new JLabel();
                b.setIcon(scaleHintergrundTextureIcon);
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
        for(int i = 0; i < 8; i++)
        {
            for(int j = 0;j < 8;j++) //Füllen mit Blöcken
            {
                JLabel b = new JLabel();
                b.setOpaque(false);//macht durchsichtig
                fakeBoard.add(b);
                fakeGrid[i][j] = b;
            }
        }


        int blockBorder = 25; //Abstand vom Rand
        int blockPreviewSize = 100; //Größe des BlockPreviews
        block1 = new JPanel(); //1.Block
        block1.setLayout(new GridLayout(5,5));
        block1.setBackground(Color.BLUE);
        block1.setPreferredSize(new Dimension(blockPreviewSize, blockPreviewSize));
        block1.setBounds(blockBorder,50+boardSize,blockPreviewSize,blockPreviewSize);
        for(int h = 0; h < 5; h++)
        {
            for (int g = 0; g < 5; g++)
            {
                JLabel b = new JLabel();
                block1.add(b);
                blockPreview1[h][g]= b;
            }
        }

        block2 = new JPanel(); //2.Block
        block2.setLayout(new GridLayout(5,5));
        block2.setBackground(Color.BLUE);
        block2.setPreferredSize(new Dimension(blockPreviewSize, blockPreviewSize));
        block2.setBounds(blockBorder*2+blockPreviewSize,50+boardSize,blockPreviewSize,blockPreviewSize);
        for(int h = 0; h < 5; h++)
        {
            for (int g = 0; g < 5; g++)
            {
                JLabel b = new JLabel();
                block2.add(b);
                blockPreview2[h][g]= b;
            }
        }

        block3 = new JPanel(); //3.Block
        block3.setLayout(new GridLayout(5,5));
        block3.setBackground(Color.BLUE);
        block3.setPreferredSize(new Dimension(blockPreviewSize, blockPreviewSize));
        block3.setBounds(blockBorder*3+blockPreviewSize*2,50+boardSize,blockPreviewSize,blockPreviewSize);
        for(int h = 0; h < 5; h++)
        {
            for (int g = 0; g < 5; g++)
            {
                JLabel b = new JLabel();
                block3.add(b);
                blockPreview3[h][g]= b;
            }
        }



        JPanel southBumper = new JPanel(); //Bumper zu unterem Rand
        int southBumperHeight = blockBorder*2; //Abstand zu unterem Rand
        southBumper.setBackground(Color.BLUE);
        southBumper.setPreferredSize(new Dimension(blockBorder*4+blockPreviewSize*3, blockPreviewSize+southBumperHeight));
        southBumper.setBounds(0,50+boardSize,blockBorder*4+blockPreviewSize*3,blockPreviewSize+southBumperHeight);



        //Titel erstellen
        titleLabel = new JLabel(String.valueOf(c.b.getScore()));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
        titleLabel.setBounds(0,0,boardSize,50); //Bestimmt Position und Größe des Titels

        scaleBlockTextureImgPreview = blockTexture.getImage().getScaledInstance(blockPreviewSize/5,blockPreviewSize/5,Image.SCALE_DEFAULT);
        scaleBlockTextureIconPreview = new ImageIcon(scaleBlockTextureImgPreview);
        scaleBlockTextureImgBoard = blockTexture.getImage().getScaledInstance((boardSize-mainPanelBorder*2)/8,(boardSize-mainPanelBorder*2)/8,Image.SCALE_DEFAULT);
        scaleBlockTextureIconBoard = new ImageIcon(scaleBlockTextureImgBoard);




        //Top label layout
        //Start und Stop Stuff
        //fügt alles hinzu, was zuerst hinzugefügt wird ist am weitesten oben
        setSize(new Dimension(boardSize+15,50+boardSize+mainPanelBorder+blockPreviewSize+southBumperHeight-15));
        add(titleLabel);
        add(fakeBoard);
        add(mainPanel);
        add(block1);
        add(block2);
        add(block3);
        add(southBumper);
        //imports the blocks
        int[][] testblock1 = c.getBm1();
        int[][] testblock2 = c.getBm2();
        int[][] testblock3 = c.getBm3();
        visualizeBlock1(testblock1);
        visualizeBlock2(testblock2);
        visualizeBlock3(testblock3);


        //gibt ideale Größe an und centert den Frame
        setLocationRelativeTo(null);

    }

    public void showMessage(String msg)
    {
        label.setText(msg);

    }

    public void chooseBlock1()
    {
        for(int i = 0; i < 5; i++)
        {
            for(int j = 0; j < 5; j++)
            {
                if(blockPreview1 [i][j].getIcon() == scaleBlockTextureIconPreview )
                {
                    fakeGrid[i][j].setIcon(scaleBlockTextureIconBoard); //sets the text of every block in fakeGrid to the equivalent in blockPreview1
                }
            }
        }
        block1.setVisible(false); //the BlockPreview for Block1 is now invisible
        block1Chosen = true; //make sure no other block can be selected
    }

    public void chooseBlock2() //the same as chooseBlock1() but for Block2
    {
        for(int i = 0; i < 5; i++)
        {
            for(int j = 0; j < 5; j++)
            {
                if(blockPreview2 [i][j].getIcon() == scaleBlockTextureIconPreview )
                {
                    fakeGrid[i][j].setIcon(scaleBlockTextureIconBoard); //sets the text of every block in fakeGrid to the equivalent in blockPreview1
                }
            }
        }
        block2.setVisible(false);
        block2Chosen = true;
    }

    public void chooseBlock3() //the same as chooseBlock1() but for Block3
    {
        for(int i = 0; i < 5; i++)
        {
            for(int j = 0; j < 5; j++)
            {
                if(blockPreview3 [i][j].getIcon() == scaleBlockTextureIconPreview )
                {
                    fakeGrid[i][j].setIcon(scaleBlockTextureIconBoard); //sets the image of every block in fakeGrid to the equivalent in blockPreview1
                }
            }
        }
        block3.setVisible(false);
        block3Chosen = true;
    }

    public void deselectBlock() //kein Block mehr ausgewählt
    {
        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j < 8; j++)
            {
                fakeGrid [i][j].setIcon(empty);
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


    @Override
    public void keyTyped(KeyEvent e)
    {

    }
    @Override
    public void keyPressed(KeyEvent e)
    {
        switch (e.getKeyCode())
        {
            case 49:
                if(!block1Chosen && !block2Chosen && !block3Chosen && !block1Placed)
                {
                    chooseBlock1();
                }
                System.out.println("Block1 chosen");
                break;
            case 50:
                if(!block1Chosen && !block2Chosen && !block3Chosen && !block2Placed)
                {
                    chooseBlock2();
                }
                System.out.println("Block2 chosen");
                break;
            case 51:
                if(!block1Chosen && !block2Chosen && !block3Chosen && !block3Placed)
                {
                    chooseBlock3();
                }
                System.out.println("Block3 chosen");
                break;
            case 32:
                placeBlock();
                visualiseBlockAgain();
                titleLabel.setText(String.valueOf(c.b.getScore()));
                c.b.printArray(c.b.getBoard());
                break;

            case 38:
                moveBlockUp();
                System.out.println("Block moved up");
                break;

            case 40:
                moveBlockDown();
                System.out.println("Block moved down");
                break;

            case 37:
                moveBlockLeft();
                System.out.println("Block moved left");
                break;

            case 39:
                moveBlockRight();
                System.out.println("Block moved right");
                break;

            case 27:
                deselectBlock();
                System.out.println("Block deselected");
                deltax = 0;
                deltay = 0;
                break;


        }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {

    }

    public void visualizeBlock1( int[][] array) {


        // einfärbern des blockpreviews
        for (int j=0; j< 5; j++){

            for (int i=0; i<5; i++){

                if (array[j][i] == 1)
                {
                    blockPreview1[j][i].setIcon(scaleBlockTextureIconPreview);
                }
                else
                {
                    blockPreview1[j][i].setBackground(Color.BLUE);
                }

            }
        }
    }
    public void visualizeBlock2(int[][] array) {

        // einfärbern des blockpreviews
        for (int j=0; j< 5; j++){

            for (int i=0; i<5; i++){

                if (array[j][i] == 1)
                {
                    blockPreview2[j][i].setIcon(scaleBlockTextureIconPreview);
                }
                else
                {
                    blockPreview2[j][i].setBackground(Color.BLUE);
                }

            }
        }
    }
    public void visualizeBlock3( int[][] array) {


        // einfärbern des blockpreviews
        for (int j=0; j< 5; j++){

            for (int i=0; i<5; i++){

                if (array[j][i] == 1)
                {
                    blockPreview3[j][i].setIcon(scaleBlockTextureIconPreview);
                }
                else
                {
                    blockPreview3[j][i].setBackground(Color.BLUE);
                }

            }
        }
    }

    public boolean moveBlockLeft()
    {
        for(int g = 0; g < 8; g++)
        {
            if(fakeGrid[g][0].getIcon() == scaleBlockTextureIconBoard)
            {
                return false;
            }
        }
        JLabel[][] movementGrid = new JLabel[8][8];
        for(int g = 0; g < 8; g++)
        {
            for(int h = 0; h < 8; h++)
            {
                JLabel l = new JLabel();
                l.setIcon(empty);
                movementGrid[g][h]=l;
            }
        }
        for(int h = 0; h < 8; h++)
        {
            for (int i=0; i< 8; i++)
            {
                if(fakeGrid[h][i].getIcon() == scaleBlockTextureIconBoard)
                {
                    movementGrid[h][i-1].setIcon(fakeGrid[h][i].getIcon());
                    fakeGrid[h][i].setIcon(empty);
                }
            }
        }
        for(int h = 0; h < 8; h++)
        {
            for (int i=0; i< 8; i++)
            {
                if(movementGrid[h][i].getIcon() == scaleBlockTextureIconBoard)
                {
                    fakeGrid[h][i].setIcon(scaleBlockTextureIconBoard);
                }
            }
        }

        deltax--;
        return true;
    }

    public boolean moveBlockRight()
    {
        for(int g = 0; g < 8; g++)
        {
            if(fakeGrid[g][7].getIcon() == scaleBlockTextureIconBoard)
            {
                return false;
            }
        }
        JLabel[][] movementGrid = new JLabel[8][8];
        for(int g = 0; g < 8; g++)
        {
            for(int h = 0; h < 8; h++)
            {
                JLabel l = new JLabel();
                l.setIcon(empty);
                movementGrid[g][h]=l;
            }
        }
        for(int h = 0; h < 8; h++)
        {
            for (int i=0; i< 8; i++)
            {
                if(fakeGrid[h][i].getIcon() == scaleBlockTextureIconBoard)
                {
                    movementGrid[h][i+1].setIcon(fakeGrid[h][i].getIcon());
                    fakeGrid[h][i].setIcon(empty);
                }
            }
        }
        for(int h = 0; h < 8; h++)
        {
            for (int i=0; i< 8; i++)
            {
                if(movementGrid[h][i].getIcon() == scaleBlockTextureIconBoard)
                {
                    fakeGrid[h][i].setIcon(scaleBlockTextureIconBoard);
                }
            }
        }

        deltax++;
        return true;
    }

    public boolean moveBlockUp()
    {
        for(int g = 0; g < 8; g++)
        {
            if(fakeGrid[0][g].getIcon() == scaleBlockTextureIconBoard)
            {
                return false;
            }
        }
        JLabel[][] movementGrid = new JLabel[8][8];
        for(int g = 0; g < 8; g++)
        {
            for(int h = 0; h < 8; h++)
            {
                JLabel l = new JLabel();
                l.setIcon(empty);
                movementGrid[g][h]=l;
            }
        }
        for(int h = 0; h < 8; h++)
        {
            for (int i=0; i< 8; i++)
            {
                if(fakeGrid[h][i].getIcon() == scaleBlockTextureIconBoard)
                {
                    movementGrid[h-1][i].setIcon(fakeGrid[h][i].getIcon());
                    fakeGrid[h][i].setIcon(empty);
                }
            }
        }
        for(int h = 0; h < 8; h++)
        {
            for (int i=0; i< 8; i++)
            {
                if(movementGrid[h][i].getIcon() == scaleBlockTextureIconBoard)
                {
                    fakeGrid[h][i].setIcon(scaleBlockTextureIconBoard);
                }
            }
        }

        deltay--;
        return true;
    }

    public boolean moveBlockDown()
    {
        for(int g = 0; g < 8; g++)
        {
            if(fakeGrid[7][g].getIcon() == scaleBlockTextureIconBoard)
            {
                return false;
            }
        }
        JLabel[][] movementGrid = new JLabel[8][8];
        for(int g = 0; g < 8; g++)
        {
            for(int h = 0; h < 8; h++)
            {
                JLabel l = new JLabel();
                l.setIcon(empty);
                movementGrid[g][h]=l;
            }
        }
        for(int h = 0; h < 8; h++)
        {
            for (int i=0; i< 8; i++)
            {
                if(fakeGrid[h][i].getIcon() == scaleBlockTextureIconBoard)
                {
                    movementGrid[h+1][i].setIcon(fakeGrid[h][i].getIcon());
                    fakeGrid[h][i].setIcon(empty);
                }
            }
        }
        for(int h = 0; h < 8; h++)
        {
            for (int i=0; i< 8; i++)
            {
                if(movementGrid[h][i].getIcon() == scaleBlockTextureIconBoard)
                {
                    fakeGrid[h][i].setIcon(scaleBlockTextureIconBoard);
                }
            }
        }

        deltay++;
        return true;
    }

    public void placeBlock()
    {
        boolean placeable = false;
        if (block1Chosen)
        {
            int x = c.getRoot(1)[1] + deltax;//+ delta x
            int y = c.getRoot(1)[0] + deltay; //+ delta y
            placeable = c.placeBlock(1, x, y);
            System.out.println("Block1 placed");

        }
        if (block2Chosen)
        {
            int x = c.getRoot(2)[1] + deltax;
            int y = c.getRoot(2)[0] + deltay;
            placeable = c.placeBlock(2, x, y);
            System.out.println("Block2 placed");
        }
        if(block3Chosen)
        {
            int x = c.getRoot(3)[1] + deltax;
            int y = c.getRoot(3)[0] + deltay;
            placeable = c.placeBlock(3, x, y);
            System.out.println("Block3 placed");
        }
        if(placeable)
        {
            for(int g = 0; g < 8; g++)
            {
                for(int h = 0; h < 8; h++)
                {
                    if(fakeGrid[g][h].getIcon() == scaleBlockTextureIconBoard)
                    {
                        fakeGrid[g][h].setIcon(empty);
                    }
                    if(c.b.getBoard()[g][h] >= 1)
                    {
                        grid[g][h].setIcon(scaleBlockTextureIconBoard);
                    }
                    if(c.b.getBoard()[g][h] == 0)
                    {
                        grid[g][h].setIcon(scaleHintergrundTextureIcon);
                    }
                }
            }
            if(block1Chosen)
            {
                for(int g = 0; g < 5; g++)
                {
                    for(int h = 0; h < 5; h++)
                    {
                        blockPreview1[g][h].setIcon(empty);
                    }
                }
                block1Chosen = false;
                block1Placed = true;
                block1.setVisible(true);
            }
            if(block2Chosen)
            {
                for(int g = 0; g < 5; g++)
                {
                    for(int h = 0; h < 5; h++)
                    {
                        blockPreview2[g][h].setIcon(empty);
                    }
                }
                block2Chosen = false;
                block2Placed = true;
                block2.setVisible(true);
            }
            if(block3Chosen)
            {
                for(int g = 0; g < 5; g++)
                {
                    for(int h = 0; h < 5; h++)
                    {
                        blockPreview3[g][h].setIcon(empty);
                    }
                }
                block3Chosen = false;
                block3Placed = true;
                block3.setVisible(true);
            }
            deltax = 0;
            deltay = 0;
        }



    }

    public void visualiseBlockAgain()
    {
        if (block1Placed && block2Placed && block3Placed )
        {
             visualizeBlock1(c.getBm1());
             visualizeBlock2(c.getBm2());
             visualizeBlock3(c.getBm3());
             block1Placed = false;
             block2Placed = false;
             block3Placed = false;
        }
    }



}




