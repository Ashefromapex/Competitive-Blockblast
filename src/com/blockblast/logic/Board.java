package com.blockblast.logic;

//import java.lang.reflect.Array;
import com.blockblast.blocks.Block;
import com.blockblast.blocks.Blockelement;
import com.blockblast.controller.controller;

public class Board
{
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

    public boolean checkPlacement()
    {
        int x = 2;
        if ( x == 1 /* da muss noch was gescheids rein, kp wie man checkt ob das geht oder nicht*/)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    // wird ausgeführt wenn der nutzer den block platzieren will
    public void placeBlock()
    {
        if (this.checkPlacement())
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




