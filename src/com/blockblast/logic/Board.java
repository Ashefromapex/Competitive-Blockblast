package com.blockblast.logic;

//import java.lang.reflect.Array;
import com.blockblast.blocks.Blockelement;
import com.blockblast.controller.controller;

public class Board
{
    Blockelement b1;
    Blockelement b2;
    Blockelement b3;

    int[][] board;
    public Board()
    {
        System.out.println("Board created");
        board = new int[8][8];
        for(int x = 0; x < 8; x++) //set all values in matrix to false
        {
            for(int y = 0; y < 8; y++)
            {
                board[x][y] = 0;//x is row and y is column
            }
        }
    }

    public int[][] getBoard()
    {
        return board;
    }

    public void check_field(int[][] board)//score ?
    {
        for (int x = 0; x < 8; x++)
        {
            check_column(x);
            check_row(x);
        }
    }

    public void getBlocks(Blockelement a, Blockelement b, Blockelement c)
    {

    }


    public boolean checkPlacement(int blockx, int x, int y)
    {
       // int x = 2;
       // if ( x == 1 /* da muss noch was gescheids rein, kp wie man checkt ob das geht oder nicht*/)
       // {
            /*switch(blockx)
            {
                case 1:
                    while(board[x][y] == 0)
                    {
                        //board[x][y] = 1; just wanna check
                        b1.above.checkPlacement(blockx,)
                        b1.left.
                        b1.below
                        b1.right.
                        break;
                    }

                case 2:
                    b2.
                    break;

                case 3:
                    b3.
                    break;





            }



       /*     return true;
        }
        else
        {
        return false;
        }
        */
        return false;
    }

    public boolean checkAll()
    {
        for(int z = 0; z < 3; z++)
        {
            for (int x = 0; x < 8; x++)
            {
                for (int y = 0; y < 8; y++)
                {
                    if(board[x][y] == 0)
                    {
                        checkPlacement(z, x, y);
                    }
                }
            }
        }
        return true; // nur damit fehlermedlung weg ist sonst ist des eigl nicht hier bzw ohne gedanken hier
    }


    // wird ausgeführt wenn der nutzer den block platzieren will
    public void placeBlock(int blockx, int x, int y)
    {
        if (this.checkPlacement(blockx, x, y))
        {
            //blockplatzieren
        }
        else
        {
            System.out.println("Placement failed");
        }
    }







    public void check_column(int columnY)
    {
        int check = 0;
        for(int x = 0; x < 8;)//check if column Y is full
        {
            check = check + board[x][columnY];
        }
        if(check == 8)//check is only 8 if all einträge = 1 aka the column is full and needs to be cleared
        {
            reset_column(columnY);//resets the column
        }
    }

    public void check_row(int rowX)
    {
        int check = 0;
        for(int y = 0; y < 8;)//check if row X is full
        {
            check = check + board[rowX][y];
        }
        if(check == 8)
        {
            reset_row(rowX);
        }
    }

    private void reset_column(int columnY)
    {
        for (int y = 0; y < 8; y++)
        {
            board[y][columnY] = 0;
        }
    }

    private void reset_row(int rowX)
    {
        for (int y = 0; y < 8; y++)
        {
            board[rowX][y] = 0;
        }
    }





    public void buildCompleteBlock(controller c, int x, int y)
    {
        BlockAlgo bA = new BlockAlgo();
        int code = bA.generateBlock();
        Translator t = new Translator();
        Blockelement bE = t.translate(code);
        System.out.println();
        System.out.println(code);
        System.out.println();
        bE.printBlock(c, x , y);

    }


}




