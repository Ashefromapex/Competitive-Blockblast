package com.blockblast.gui.window;

import com.blockblast.controller.controller;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;

public class Multiplayer extends JPanel implements MouseListener, MouseMotionListener {
    controller c;
    ControllerGUI cGUI;
    //instanzvariable erstellen
    JLabel [][] grid = new JLabel[8][8];
    JLabel [][] movementGrid = new JLabel[8][8];
    JLabel [][] hoverGrid = new JLabel[8][8];
    JLabel [][] blockPreview1 = new JLabel[5][5];
    JLabel [][] blockPreview2 = new JLabel[5][5];
    JLabel [][] blockPreview3 = new JLabel[5][5];
    JLabel [] attackCount = new JLabel[16];
    boolean [][] exists = new boolean[8][8]; //colouring stuff
    JLabel score;
    JPanel mainPanel; //displays the placed blocks
    JPanel hoverBoard; //displaying the place where the block will snap to when not placed yet
    int boardSize;
    int mainPanelBorder;
    JPanel movementBoard; //moving the block around in the air
    JPanel block1; //used to show the three blocks at the bottom of the screen
    JPanel block2;
    JPanel block3;
    int blockPreviewSize;
    ImageIcon scaledTexture1; //Textures for the blocks in all states
    ImageIcon scaledTexture2;
    ImageIcon scaledTexture3;
    ImageIcon scaledPlaced1;
    ImageIcon scaledPlaced2;
    ImageIcon scaledPlaced3;
    JPanel attackPanel; //attack + defense visualization
    ImageIcon scaleDefenseIcon;
    ImageIcon scaleOffenseIcon;
    ImageIcon hintergrundTexture = new ImageIcon(("src/com/blockblast/assets/hintergrund.png"));
    Image scaleHintergrundTextureImg;
    ImageIcon scaleHintergrundTextureIcon;
    Image scaleAttackTextureImg;
    ImageIcon scaleAttackTextureIcon;
    ImageIcon empty = new  ImageIcon();
    private boolean block1Chosen = false; //placement variables
    private boolean block2Chosen = false;
    private boolean block3Chosen = false;
    private boolean block1Placed = false;
    private boolean block2Placed = false;
    private boolean block3Placed = false;
    private boolean block1Hover = false;
    private boolean block2Hover = false;
    private boolean block3Hover = false;
    ImageIcon [] texturePlaced = new ImageIcon[8]; //list of all placed textures
    ImageIcon [] textureHover = new ImageIcon[8]; //list of all hovering textures (extension)
    Color backgroundColor = new Color(83,155,255);
    int hoverBoardX;
    int hoverBoardY;




    public Multiplayer(controller c, ControllerGUI cGUI)
    {

        this.c = c;
        this.cGUI = cGUI;
        //Overall settings for the frame
        setVisible(true);
        setLayout(null);
        setFocusable(true);
        addMouseListener(this);
        addMouseMotionListener(this);

        //up here for calculation purposes
        int attackBorder = 36;

        //MainPanel erstellen
        mainPanel = new JPanel();
        GridLayout mainPanelGridLayout = new GridLayout(0,8);
        mainPanel.setLayout(mainPanelGridLayout);
        mainPanel.setOpaque(true);
        mainPanelBorder = 36; //Abstand vom Rand des Fensters
        boardSize = 400; //Größe des Boards
        mainPanel.setBounds((boardSize-mainPanelBorder*2)/8+attackBorder*2,50,boardSize,boardSize); //Position und Größe des Boards im Layout
        EmptyBorder Distance = new EmptyBorder(mainPanelBorder, mainPanelBorder, mainPanelBorder, mainPanelBorder);
        LineBorder mainPanelOutline = new LineBorder(Color.black);
        CompoundBorder mainPanelCompoundBorder = new CompoundBorder(Distance, mainPanelOutline); //Coole schwarze Outline
        mainPanel.setBorder(mainPanelCompoundBorder);
        mainPanel.setBackground(backgroundColor);
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

        //hoverPanel creation, pretty much an invisible copy of the mainPanel on top of it
        hoverBoard = new JPanel();
        GridLayout hoverBoardGridLayout = new GridLayout(0,8);
        hoverBoard.setLayout(hoverBoardGridLayout);
        hoverBoard.setOpaque(false);
        hoverBoard.setBounds((boardSize-mainPanelBorder*2)/8+attackBorder*2 + mainPanelBorder+4,54+mainPanelBorder,boardSize-(mainPanelBorder+4)*2,boardSize-(mainPanelBorder+4)*2);
        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j < 8; j++)
            {
                JLabel b = new JLabel();
                b.setOpaque(false);
                hoverBoard.add(b);
                hoverGrid[i][j] = b;
            }
        }

        //Panel to grab and move blocks around
        movementBoard = new JPanel();
        GridLayout fakeBoardGridLayout = new GridLayout(0,5);
        movementBoard.setLayout(fakeBoardGridLayout);
        movementBoard.setBounds(0,50,(boardSize-mainPanelBorder*2)/8*5,(boardSize-mainPanelBorder*2)/8*5);
        movementBoard.setOpaque(false); //macht durchsichtig
        movementBoard.setBackground(new Color(0,0,0,0)); //macht durchsichtig
        for(int i = 0; i < 5; i++)
        {
            for(int j = 0;j < 5;j++) //Füllen mit Blöcken
            {
                JLabel b = new JLabel();
                b.setOpaque(false);//macht durchsichtig
                movementBoard.add(b);
                movementGrid[i][j] = b;
            }
        }

        //multiplayer only: scaling the images for attack and defense
        ImageIcon defense = new ImageIcon(("src/com/blockblast/assets/block_provisorisch.png"));
        Image scaleDefenseImg = defense.getImage().getScaledInstance((boardSize-mainPanelBorder*2)/8,(boardSize-mainPanelBorder*2)/16,Image.SCALE_DEFAULT);
        scaleDefenseIcon = new ImageIcon(scaleDefenseImg);

        ImageIcon offense = new ImageIcon(("src/com/blockblast/assets/block_placed.png"));
        Image scaleOffenseImg = offense.getImage().getScaledInstance((boardSize-mainPanelBorder*2)/8,(boardSize-mainPanelBorder*2)/16,Image.SCALE_DEFAULT);
        scaleOffenseIcon = new ImageIcon(scaleOffenseImg);

        //multiplayer only: the bar on the side of the screen used to display incoming attacks and defenses
        attackPanel = new JPanel();
        attackPanel.setLayout(new GridLayout(0,1));
        attackPanel.setBackground(backgroundColor);
        EmptyBorder attackDistance = new EmptyBorder(mainPanelBorder, attackBorder, mainPanelBorder, attackBorder);
        LineBorder attackOutline = new LineBorder(Color.BLACK);
        CompoundBorder attackCompoundBorder = new  CompoundBorder(attackDistance,attackOutline);
        attackPanel.setBorder(attackCompoundBorder);
        scaleAttackTextureImg = hintergrundTexture.getImage().getScaledInstance((boardSize-mainPanelBorder*2)/8,(boardSize-mainPanelBorder*2)/16,Image.SCALE_DEFAULT);
        scaleAttackTextureIcon = new ImageIcon(scaleAttackTextureImg);
        for(int h = 0; h < 16; h++)
        {
            JLabel b = new JLabel();
            b.setIcon(scaleAttackTextureIcon);
            attackPanel.add(b);
            attackCount[h] = b;
        }
        attackPanel.setBounds(0,50,(boardSize-mainPanelBorder*2)/8+attackBorder*2,(boardSize-mainPanelBorder*2)+mainPanelBorder*2);

        //configuring the panels to display the blocks at the bottom of the screen
        int blockBorder = 25; //Abstand vom Rand
        blockPreviewSize = 100; //Größe des BlockPreviews
        block1 = new JPanel(); //1.Block
        block1.setLayout(new GridLayout(5,5));
        block1.setBackground(backgroundColor);
        block1.setPreferredSize(new Dimension(blockPreviewSize, blockPreviewSize));
        block1.setBounds((boardSize-mainPanelBorder*2)/8+attackBorder*2+blockBorder,50+boardSize,blockPreviewSize,blockPreviewSize);
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
        block2.setBackground(backgroundColor);
        block2.setPreferredSize(new Dimension(blockPreviewSize, blockPreviewSize));
        block2.setBounds((boardSize-mainPanelBorder*2)/8+attackBorder*2+blockBorder*2+blockPreviewSize,50+boardSize,blockPreviewSize,blockPreviewSize);
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
        block3.setBackground(backgroundColor);
        block3.setPreferredSize(new Dimension(blockPreviewSize, blockPreviewSize));
        block3.setBounds((boardSize-mainPanelBorder*2)/8+attackBorder*2+blockBorder*3+blockPreviewSize*2,50+boardSize,blockPreviewSize,blockPreviewSize);
        for(int h = 0; h < 5; h++)
        {
            for (int g = 0; g < 5; g++)
            {
                JLabel b = new JLabel();
                block3.add(b);
                blockPreview3[h][g]= b;
            }
        }


        //leaving space between the bottom of the window and the blocks
        JPanel southBumper = new JPanel(); //Bumper zu unterem Rand
        int southBumperHeight = blockBorder*2; //Abstand zu unterem Rand
        southBumper.setBackground(backgroundColor);
        southBumper.setPreferredSize(new Dimension(blockBorder*4+blockPreviewSize*3, blockPreviewSize+southBumperHeight));
        southBumper.setBounds(0,50+boardSize,attackPanel.getWidth()+blockBorder*4+blockPreviewSize*3,blockPreviewSize+southBumperHeight);



        //Titel erstellen
        score = new JLabel(c.b.getScore() + "   Kombo: " + c.b.getKombo());
        score.setHorizontalAlignment(SwingConstants.CENTER);
        score.setFont(new Font("Tahoma", Font.BOLD, 30));
        score.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
        score.setBounds(0,0,boardSize,50); //Bestimmt Position und Größe des Titels

        //adding mouseListeners for drag & drop where necessary
        block1.addMouseListener(this);
        block1.addMouseMotionListener(this);
        block2.addMouseListener(this);
        block2.addMouseMotionListener(this);
        block3.addMouseListener(this);
        block3.addMouseMotionListener(this);
        mainPanel.addMouseListener(this);
        movementBoard.addMouseListener(this);
        movementBoard.addMouseMotionListener(this);

        //different colours stuff
        for(int i = 0; i < 8; i++)
        {
            for(int j = 0;j < 8;j++) //Code Monstrum zusammengefasst
            {
                exists[i][j] = false;
            }
        }

        //adding all the textures to both arrays
        texturePlaced[0] = new ImageIcon(("src/com/blockblast/assets/Block_Texture_Blue.png"));
        texturePlaced[1] = new ImageIcon(("src/com/blockblast/assets/Block_Texture_DarkBlue.png"));
        texturePlaced[2] = new ImageIcon(("src/com/blockblast/assets/Block_Texture_Green.png"));
        texturePlaced[3] = new ImageIcon(("src/com/blockblast/assets/Block_Texture_Pink.png"));
        texturePlaced[4] = new ImageIcon(("src/com/blockblast/assets/Block_Texture_Yellow.png"));
        texturePlaced[5] = new ImageIcon(("src/com/blockblast/assets/Block_Texture_Red.png"));
        texturePlaced[6] = new ImageIcon(("src/com/blockblast/assets/Block_Texture_Orange.png"));
        texturePlaced[7] = new ImageIcon(("src/com/blockblast/assets/Block_Texture_Purple.png"));

        //fügt alles hinzu, was zuerst hinzugefügt wird ist am weitesten oben
        setSize(new Dimension((boardSize-mainPanelBorder*2)/8+attackBorder*2+boardSize+15,50+boardSize+mainPanelBorder+blockPreviewSize+southBumperHeight-15));
        add(score);
        add(movementBoard);
        add(hoverBoard);
        add(mainPanel);
        add(block1);
        add(block2);
        add(block3);
        add(attackPanel);
        add(southBumper);
        //imports the blocks
        int[][] testblock1 = c.getBm1();
        int[][] testblock2 = c.getBm2();
        int[][] testblock3 = c.getBm3();
        //displays the blocks
        visualizeBlock1(testblock1);
        visualizeBlock2(testblock2);
        visualizeBlock3(testblock3);
    }

    //scaling the textures for all occasions
    public ImageIcon scaleTexturePreview(ImageIcon preview)
    {
        Image scaleBlockTextureImgPreview = preview.getImage().getScaledInstance(blockPreviewSize/5,blockPreviewSize/5,Image.SCALE_DEFAULT);
        return new ImageIcon(scaleBlockTextureImgPreview);
    }

    public ImageIcon scaleTexturePlaced(ImageIcon placed)
    {
        Image scaleBlockHoverTextureImgBoard = placed.getImage().getScaledInstance((boardSize-mainPanelBorder*2)/8,(boardSize-mainPanelBorder*2)/8,Image.SCALE_DEFAULT);
        return new ImageIcon(scaleBlockHoverTextureImgBoard);
    }

    //copying the block out of the preview into the movement board
    public void chooseBlock1()
    {
        scaledPlaced1 = scaleTexturePlaced(scaledTexture1);
        for(int i = 0; i < 5; i++)
        {
            for(int j = 0; j < 5; j++)
            {
                if(blockPreview1 [i][j].getIcon() == scaledTexture1 )
                {
                    movementGrid[i][j].setIcon(scaledPlaced1); //sets the text of every block in fakeGrid to the equivalent in blockPreview1
                }
            }
        }
        block1.setVisible(false); //the BlockPreview for Block1 is now invisible
        block1Chosen = true; //make sure no other block can be selected
    }

    public void chooseBlock2() //the same as chooseBlock1() but for Block2
    {
        scaledPlaced2 = scaleTexturePlaced(scaledTexture2);
        for(int i = 0; i < 5; i++)
        {
            for(int j = 0; j < 5; j++)
            {
                if(blockPreview2 [i][j].getIcon() == scaledTexture2 )
                {
                    movementGrid[i][j].setIcon(scaledPlaced2); //sets the text of every block in fakeGrid to the equivalent in blockPreview2
                }
            }
        }
        block2.setVisible(false);
        block2Chosen = true;
    }

    public void chooseBlock3() //the same as chooseBlock1() but for Block3
    {
        scaledPlaced3 = scaleTexturePlaced(scaledTexture3);
        for(int i = 0; i < 5; i++)
        {
            for(int j = 0; j < 5; j++)
            {
                if(blockPreview3 [i][j].getIcon() == scaledTexture3 )
                {
                    movementGrid[i][j].setIcon(scaledPlaced3); //sets the image of every block in fakeGrid to the equivalent in blockPreview3
                }
            }
        }
        block3.setVisible(false);
        block3Chosen = true;
    }

    public void deselectBlock() //kein Block mehr ausgewählt
    {
        for(int i = 0; i < 5; i++)
        {
            for(int j = 0; j < 5; j++)
            {
                movementGrid[i][j].setIcon(empty);
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

    public void visualizeBlock1( int[][] array) {

        Random rand = new Random();
        ImageIcon blockTexture1 = texturePlaced [rand.nextInt(8)];
        scaledTexture1 = scaleTexturePreview(blockTexture1);
        // einfärbern des blockpreviews
        for (int j=0; j< 5; j++){

            for (int i=0; i<5; i++){

                if (array[j][i] == 1) //blockmatrix created in board
                {
                    blockPreview1[j][i].setIcon(scaledTexture1); //copies the blockmatrix into the blockPreview
                }

            }
        }
    }
    public void visualizeBlock2(int[][] array) {

        Random rand = new Random();
        ImageIcon blockTexture2 = texturePlaced [rand.nextInt(8)];
        scaledTexture2 = scaleTexturePreview(blockTexture2);
        // einfärbern des blockpreviews
        for (int j=0; j< 5; j++){

            for (int i=0; i<5; i++){

                if (array[j][i] == 1)
                {
                    blockPreview2[j][i].setIcon(scaledTexture2);
                }

            }
        }
    }
    public void visualizeBlock3( int[][] array) {

        Random rand = new Random();
        ImageIcon blockTexture3 = texturePlaced [rand.nextInt(8)];
        scaledTexture3 = scaleTexturePreview(blockTexture3);
        // einfärbern des blockpreviews
        for (int j=0; j< 5; j++){

            for (int i=0; i<5; i++){

                if (array[j][i] == 1)
                {
                    blockPreview3[j][i].setIcon(scaledTexture3);
                }

            }
        }
    }

    //placing the block
    public void placeBlock(int blocknr, int x, int y)
    {
        boolean placeable = false;
        placeable = c.placeBlock(blocknr,x,y); //checking if it is possible to place the block at the given location
        if(placeable)
        {
            for(int g = 0; g < 8; g++)
            {
                for(int h = 0; h < 8; h++)
                {
                    switch(blocknr)
                    {
                        case 1:
                            if(c.b.getBoard()[g][h] >= 1 && !exists[g][h])
                            {
                                grid[g][h].setIcon(scaledPlaced1); //copying the array from board into the GUI
                                exists[g][h] = true; //this prevents the block from being recoloured
                            }
                            break;
                        case 2:
                            if(c.b.getBoard()[g][h] >= 1 && !exists[g][h])
                            {
                                grid[g][h].setIcon(scaledPlaced2);
                                exists[g][h] = true;
                            }
                            break;
                        case 3:
                            if(c.b.getBoard()[g][h] >= 1 && !exists[g][h])
                            {
                                grid[g][h].setIcon(scaledPlaced3);
                                exists[g][h] = true;
                            }
                            break;
                    }
                    if(c.b.getBoard()[g][h] == 0) //needed for cleared rows + columns
                    {
                        grid[g][h].setIcon(scaleHintergrundTextureIcon);
                        exists[g][h] = false;
                    }
                }
            }
            for(int g = 0; g < 5; g++) //resetting the movementGrid and placed blocks
            {
                for(int h = 0; h < 5; h++)
                {
                    movementGrid[g][h].setIcon(empty);
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
                System.out.println("Block1 placed");
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
                System.out.println("Block2 placed");
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
                System.out.println("Block3 placed");
            }
            visualiseBlockAgain();
        }
        else //if block isnt placeable we go back to the original state
        {
            deselectBlock();
        }
    }

    //same as placeBlock() but for hovering so the hoverGrid is used instead of the main grid
    public void hoverBlock(int blocknr, int x, int y)
    {
        boolean placeable = false;
        placeable = c.b.hoverBlock(blocknr, x, y);
        if(placeable)
        {
            for(int g = 0; g < 8; g++)
            {
                for(int h = 0; h < 8; h++)
                {
                    switch(blocknr)
                    {
                        case 1:
                            if(c.b.getFaki()[g][h] >= 1 && !exists[g][h])
                            {
                                hoverGrid[g][h].setIcon(scaledPlaced1);
                            }
                            break;
                        case 2:
                            if(c.b.getFaki()[g][h] >= 1 && !exists[g][h])
                            {
                                hoverGrid[g][h].setIcon(scaledPlaced2);
                            }
                            break;
                        case 3:
                            if(c.b.getFaki()[g][h] >= 1 && !exists[g][h])
                            {
                                hoverGrid[g][h].setIcon(scaledPlaced3);
                            }
                            break;
                    }
                    if(c.b.getFaki()[g][h] == 0)
                    {
                        hoverGrid[g][h].setIcon(empty);
                    }
                }
            }
            hoverBoardX = x;
            hoverBoardY = y;
        }
    }

    //called after every block placed and used to create 3 new blocks after all of them have been used
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

    //correctly placing the block after dropping it in a random location
    public void snapBlock()
    {
        //the coordinates given out at the end
        int boardX = 0;
        int boardY = 0;
        for(int g = 0; g < 5; g++)
        {
            for(int h = 0; h < 5; h++)
            {
                if(block1Chosen)
                {
                    if(movementGrid[g][h].getIcon() == scaledPlaced1)
                    {
                        boardX = Math.round((float) (movementBoard.getX() + movementGrid[g][h].getX()-149)/41) + (c.getRoot(1)[1]-h);
                        boardY = Math.round((float) (movementBoard.getY() + movementGrid[g][h].getY()-86)/41) + (c.getRoot(1)[0]-g);
                        System.out.println("Placement: " + boardX + " " + boardY);
                        placeBlock(1, boardX, boardY);
                    }
                }
                if(block2Chosen)
                {
                    if(movementGrid[g][h].getIcon() == scaledPlaced2)
                    {
                        boardX = Math.round((float) (movementBoard.getX() + movementGrid[g][h].getX()-149)/41) + (c.getRoot(2)[1]-h);
                        boardY = Math.round((float) (movementBoard.getY() + movementGrid[g][h].getY()-86)/41) + (c.getRoot(2)[0]-g);
                        System.out.println("Placement: " + boardX + " " + boardY);
                        placeBlock(2, boardX, boardY);
                    }
                }
                if(block3Chosen)
                {
                    if(movementGrid[g][h].getIcon() == scaledPlaced3)
                    {
                        boardX = Math.round((float) (movementBoard.getX() + movementGrid[g][h].getX()-149)/41) + (c.getRoot(3)[1]-h);
                        boardY = Math.round((float) (movementBoard.getY() + movementGrid[g][h].getY()-86)/41) + (c.getRoot(3)[0]-g);
                        System.out.println("Placement: " + boardX + " " + boardY);
                        placeBlock(3, boardX, boardY);
                    }
                }
            }
        }

    }

    //same as snapBlock() but for hovering
    public void snapBlockHover()
    {
        c.b.clearFaki();
        int boardX = 0;
        int boardY = 0;
        for(int g = 0; g < 5; g++)
        {
            for(int h = 0; h < 5; h++)
            {
                if(block1Chosen)
                {
                    if(movementGrid[g][h].getIcon() == scaledPlaced1)
                    {
                        boardX = Math.round((float) (movementBoard.getX() + movementGrid[g][h].getX()-149)/41) + (c.getRoot(1)[1]-h);
                        boardY = Math.round((float) (movementBoard.getY() + movementGrid[g][h].getY()-86)/41) + (c.getRoot(1)[0]-g);
                        if(hoverBoardX != boardX || hoverBoardY != boardY)
                        {
                            hoverBlock(1, boardX, boardY);
                        }
                    }
                }
                if(block2Chosen)
                {
                    if(movementGrid[g][h].getIcon() == scaledPlaced2)
                    {
                        boardX = Math.round((float) (movementBoard.getX() + movementGrid[g][h].getX()-149)/41) + (c.getRoot(2)[1]-h);
                        boardY = Math.round((float) (movementBoard.getY() + movementGrid[g][h].getY()-86)/41) + (c.getRoot(2)[0]-g);
                        if(hoverBoardX != boardX || hoverBoardY != boardY)
                        {
                            hoverBlock(2, boardX, boardY);
                        }
                    }
                }
                if(block3Chosen)
                {
                    if(movementGrid[g][h].getIcon() == scaledPlaced3)
                    {
                        boardX = Math.round((float) (movementBoard.getX() + movementGrid[g][h].getX()-149)/41) + (c.getRoot(3)[1]-h);
                        boardY = Math.round((float) (movementBoard.getY() + movementGrid[g][h].getY()-86)/41) + (c.getRoot(3)[0]-g);
                        if(hoverBoardX != boardX || hoverBoardY != boardY)
                        {
                            hoverBlock(3, boardX, boardY);
                        }
                    }
                }
            }
        }

    }

    //multiplayer only: visualizing the incoming attacks
    public void attacks()
    {
        //this is where I would put my c.b.getAttacks() if I had one
        int x = -8;
        if(x < 0)
        {
            int y=x*-1+8;
            for(int g = 8; g < 16; g++)
            {
                attackCount[g].setIcon(scaleAttackTextureIcon);
            }
            for(int g = 8; g < y; g++)
            {
                attackCount[g].setIcon(scaleDefenseIcon);
            }
        }
        if(x > 0)
        {
            int y=7-x;
            for(int g = 7; g < 0; g--)
            {
                attackCount[g].setIcon(scaleAttackTextureIcon);
            }
            for(int g = 7; g > y; g--)
            {
                attackCount[g].setIcon(scaleOffenseIcon);
            }
        }
    }

    //moving the movementGrid
    int movementBoardX = 0;
    int movementBoardY = 0;

    @Override
    public void mouseClicked(MouseEvent e)
    {

    }

    @Override
    public void mousePressed(MouseEvent e) //choosing the block and positioning the movementGrid accordingly
    {
        if(block1Hover)
        {
            block1Chosen = true;
            block1.setVisible(false);
            chooseBlock1();
            movementBoard.setLocation(block1.getX()-50, block1.getY()-50); //offset because movementGrid is bigger than blockPreview
            movementBoardX = movementBoard.getX()-e.getX();
            movementBoardY = movementBoard.getY()-e.getY();
        }
        if(block2Hover)
        {
            block2Chosen = true;
            block2.setVisible(false);
            chooseBlock2();
            movementBoard.setLocation(block2.getX()-50, block2.getY()-50);
            movementBoardX = movementBoard.getX()-e.getX();
            movementBoardY = movementBoard.getY()-e.getY();
        }
        if(block3Hover)
        {
            block3Chosen = true;
            block3.setVisible(false);
            chooseBlock3();
            movementBoard.setLocation(block3.getX()-50, block3.getY()-50);
            movementBoardX = movementBoard.getX()-e.getX();
            movementBoardY = movementBoard.getY()-e.getY();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) // placing the block
    {
        for(int g = 0; g < 8; g++)
        {
            for(int h = 0; h < 8; h++)
            {
                hoverGrid[g][h].setIcon(empty);
            }
        }
        snapBlock();
        attacks();
        score.setText(c.b.getScore() + "   Kombo: " + c.b.getKombo());
        block1Chosen = false;
        block2Chosen = false;
        block3Chosen = false;
        movementBoard.setLocation(0,0); // allows spam-clicking on a singular block as much as you want
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {
        if(e.getSource() == block1)
        {
            block1Hover = true;
        }
        if(e.getSource() == block2)
        {
            block2Hover = true;
        }
        if(e.getSource() == block3)
        {
            block3Hover = true;
        }

    }

    @Override
    public void mouseExited(MouseEvent e)
    {
        if(e.getSource() == block1)
        {
            block1Hover = false;
        }
        if(e.getSource() == block2)
        {
            block2Hover = false;
        }
        if(e.getSource() == block3)
        {
            block3Hover = false;
        }
    }

    @Override
    public void mouseDragged(MouseEvent e)
    {
        movementBoard.setLocation(movementBoardX +e.getX(), movementBoardY +e.getY());
        snapBlockHover();
    }

    @Override
    public void mouseMoved(MouseEvent e)
    {

    }

}




